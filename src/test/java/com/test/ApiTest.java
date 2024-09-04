package com.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.example.Read_Data;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ApiTest extends BaseTest{

@Test
public void getUsers() {
    given()
            .when()
            .get("/api/users?page=2")
            .then()
            .assertThat().statusCode(200)
            .body("page", equalTo(2))
            .body("data[0].id", equalTo(7))
            .body("data[0].email", equalTo("michael.lawson@reqres.in"))
            .body("data[0].first_name", equalTo("Michael"))
            .body("data[0].last_name", equalTo("Lawson"))
            .body("data[1].id", equalTo(8))
            .body("data[1].email", equalTo("lindsay.ferguson@reqres.in"))
            .body("data[1].first_name", equalTo("Lindsay"))
            .body("data[1].last_name", equalTo("Ferguson"))
            .body("data[2].first_name", equalTo("Tobias"))
            .body("data[2].last_name", equalTo("Funke"))
            .body("data[3].first_name", equalTo("Byron"))
            .body("data[3].last_name", equalTo("Fields"))
            .body("data[4].id", equalTo(11))
            .body("data[4].first_name", equalTo("George"))
            .body("data[5].id", equalTo(12))
            .body("support.url", equalTo("https://reqres.in/#support-heading"));
}
@Test(dataProvider = "test_data")
public void createUser(String id,String email, String firstName, String lastName,  String avatar) {
    String jsonPayload = String.format("{\"id\": \"%s\", \"email\": \"%s\", \"first_name\": \"%s\", \"last_name\": \"%s\", \"avatar\": \"%s\"}", id, firstName, lastName, email, avatar);

    Response response = given()
            .contentType(ContentType.JSON)
            .body(jsonPayload)
            .post("/api/users");

    assertEquals(response.getStatusCode(), 201);

}
    @Test(dataProvider = "test_data")
    public void updateUser(String id,String email, String firstName, String lastName,  String avatar) {
        String updateEmail = "Maa@gmail.com";
        String jsonPayload = String.format("{\"id\": \"%s\", \"email\": \"%s\", \"first_name\": \"%s\", \"last_name\": \"%s\", \"avatar\": \"%s\"}",
                id, updateEmail, firstName, lastName, avatar);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonPayload)
                .put("/api/users/2");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("email"), updateEmail);
    }




    @DataProvider
    public static String[][] test_data() throws IOException, InvalidFormatException {
        Read_Data rd =new Read_Data();
        return rd.read_data();

    }
}