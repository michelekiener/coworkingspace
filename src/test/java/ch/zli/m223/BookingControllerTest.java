package ch.zli.m223;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.User;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;
import java.util.Collections;

@QuarkusTest
public class BookingControllerTest {
  Booking booking;
  User user;

  @BeforeEach
  public void addBooking() {
    user = new User();
    user.setFirstname("Marrie"); 
    user.setName("Jizzyman");
    user.setAdmin(true);
    user.setBirthday(LocalDate.of(2000, 10, 23));
    user.setEmail("marrie.jzz@gmail.com");
    user.setBookings(Collections.emptyList());
    user.setPassword("");

    booking = new Booking();
    booking.setLocalDate(LocalDate.of(2022, 11, 23));
    booking.setUser(user);
  }

  @Test
    public void testGetBookings(){    
        given()
        .when().get("/bookings")
        .then()
            .statusCode(200)
            .body(is("[]"));
    }

    @Test
    public void testGetBooking(){ 
      var getbooking = given()
        .contentType(ContentType.JSON)
        .body(booking)
        .when().post("/bookings");

        int id = getbooking.jsonPath().get("id");
           
        given()
        .when().get("/bookings" + id)
        .then()
            .statusCode(200)
            .body("id", is(id));
    }

    @Test
    public void testBookingDelete(){
        var getbooking = given()
        .contentType(ContentType.JSON)
        .body(booking)
        .when().post("/bookings");

        int id = getbooking.jsonPath().get("id");

        given()
        .when().delete("/bookings/" + id)
        .then()
            .statusCode(204);
    }
}
