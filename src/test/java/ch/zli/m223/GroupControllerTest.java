package ch.zli.m223;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.zli.m223.model.Group;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.Collections;

@QuarkusTest
public class GroupControllerTest {
  Group group;

  @BeforeEach
  public void addGroup() {
    group = new Group();
    group.setName("Gruppe 1");
    group.setMembers(Collections.emptyList());
  }

  @Test
    public void testGetGroups(){    
        given()
        .when().get("/groups")
        .then()
            .statusCode(200)
            .body(is("[]"));
    }

    @Test
    public void testGetGroup(){ 
      var getGroup = given()
        .contentType(ContentType.JSON)
        .body(group)
        .when().post("/groups");

        int id = getGroup.jsonPath().get("id");
           
        given()
        .when().get("/groups" + id)
        .then()
            .statusCode(200)
            .body("id", is(id));
    }

    @Test
    public void testGroupDelete(){
        var getGroup = given()
        .contentType(ContentType.JSON)
        .body(group)
        .when().post("/groups");

        int id = getGroup.jsonPath().get("id");

        given()
        .when().delete("/groups/" + id)
        .then()
            .statusCode(204);
    }
}
