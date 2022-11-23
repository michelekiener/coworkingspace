package ch.zli.m223;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.zli.m223.model.BookingRequest;
import ch.zli.m223.model.User;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;
import java.util.Collections;

@QuarkusTest
public class BookingRequestTest {
  BookingRequest bookingRequest;
  User user;

  @BeforeEach
  public void addBookingRequest() {
    user = new User();
    user.setFirstname("Marrie"); 
    user.setName("Jizzyman");
    user.setAdmin(true);
    user.setBirthday(LocalDate.of(2000, 10, 23));
    user.setEmail("marrie.jzz@gmail.com");
    user.setBookings(Collections.emptyList());
    user.setPassword("");

    bookingRequest = new BookingRequest();
    bookingRequest.setLocalDate(LocalDate.of(2022, 11, 23));
    bookingRequest.setUser(user);
  }

  @Test
    public void testGetBookingRequests(){    
        given()
        .when().get("/booking-requests")
        .then()
            .statusCode(200)
            .body(is("[]"));
    }

    @Test
    public void testGetBookingRequest(){ 
      var getbookingRequest = given()
        .contentType(ContentType.JSON)
        .body(bookingRequest)
        .when().post("/booking-requests");

        int id = getbookingRequest.jsonPath().get("id");
           
        given()
        .when().get("/booking-requests" + id)
        .then()
            .statusCode(200)
            .body("id", is(id));
    }

    @Test
    public void testBookingRequestDelete(){
        var getbookingRequest = given()
        .contentType(ContentType.JSON)
        .body(bookingRequest)
        .when().post("/booking-requests");

        int id = getbookingRequest.jsonPath().get("id");

        given()
        .when().delete("/booking-requests/" + id)
        .then()
            .statusCode(204);
    }

}
