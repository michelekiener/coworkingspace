package ch.zli.m223;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.zli.m223.model.User;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class UserControllerTest {
  User user;

  @BeforeEach
  public void addUser() {
    user = new User();
    user.setFirstname("Marrie"); 
    user.setName("Jizzyman");
    user.setAdmin(true);
    user.setBirthday(LocalDate.of(2000, 10, 23));
    user.setEmail("marrie.jzz@gmail.com");
    user.setBookings(Collections.emptyList());
    user.setPassword("");
  }

  @Test
    public void testGetUsers(){    
        given()
        .when().get("/users")
        .then()
            .statusCode(200)
            .body(is("[]"));
    }

    @Test
    public void testGetUser(){ 
      var getUser = given()
        .contentType(ContentType.JSON)
        .body(user)
        .when().post("/users");

        int id = getUser.jsonPath().get("id");
           
        given()
        .when().get("/users" + id)
        .then()
            .statusCode(200)
            .body("id", is(id));
    }

    @Test
    public void testUserDelete(){
        var getUser = given()
        .contentType(ContentType.JSON)
        .body(user)
        .when().post("/users");

        int id = getUser.jsonPath().get("id");

        given()
        .when().delete("/users/" + id)
        .then()
            .statusCode(204);
    }
}
