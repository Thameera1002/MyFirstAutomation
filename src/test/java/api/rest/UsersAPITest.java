package api.rest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsersAPITest {

    @Test
    public void getAllUsersAPI(){
        given().
                when()
                .get("https://reqres.in/api/users")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }


}
