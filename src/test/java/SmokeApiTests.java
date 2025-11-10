import controllers.UserController;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.ApiResponse;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static testdata.TestData.DEFAULT_USER;
import static testdata.TestData.INVALID_USER;

public class SmokeApiTests {
    private UserController userController;

    @BeforeEach
    void setUp() {
        // inject/configure dependencies here if needed
        userController = new UserController();
    }

    @Test
    void simpleTest() {
        //AAA -> Arrange -> Act -> Assert
        String body = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";

        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .baseUri("https://petstore.swagger.io/v2/")
                .when()
                .body(body)
                .post("user")
                .andReturn();

        int actualCode = response.getStatusCode();

        Assertions.assertEquals(200, actualCode);
    }

    @Test
    void createUserControllerTest() {
//        User user = new User(0,
//                "username",
//                "firstName",
//                "lastName",
//                "email",
//                "password",
//                "phone",
//                0);

        Response response = userController.createDefaultedUser(DEFAULT_USER);
        ApiResponse createdUserResponse = response.as(ApiResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, createdUserResponse.getCode());
        Assertions.assertEquals("unknown", createdUserResponse.getType());
        Assertions.assertFalse(createdUserResponse.getMessage().isEmpty());
    }

    @Test
    void createUserControllerTest2() {
//        User user = new User(0,
//                "username",
//                "firstName",
//                "lastName",
//                "email",
//                "password",
//                "phone",
//                0);

        Response response = userController.createDefaultedUser(INVALID_USER);
        ApiResponse createdUserResponse = response.as(ApiResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, createdUserResponse.getCode());
        Assertions.assertEquals("unknown", createdUserResponse.getType());
        Assertions.assertEquals("0", createdUserResponse.getMessage());
    }

    @Test
    void updateUserControllerTest() {
        User user = new User(0,
                "user1",
                "firstName",
                "lastName",
                "email",
                "password",
                "phone",
                0);

        Response response = userController.updateUser(user);
        ApiResponse updatedUserResponse = response.as(ApiResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, updatedUserResponse.getCode());
        Assertions.assertEquals("unknown", updatedUserResponse.getType());
        Assertions.assertFalse(updatedUserResponse.getMessage().isEmpty());
    }

    @Test
    void getUserControllerTest() {
        Response response = userController.getUserByUsername("string");
        User user = response.as(User.class);

        Assertions.assertEquals(200, response.statusCode());
//        Assertions.assertEquals(9222968140497192000L, user.getId());
//        Assertions.assertEquals("error", getUserResponse.getType());
//        Assertions.assertEquals("User not found", getUserResponse.getMessage());
    }

    @Test
    void deleteUserControllerTest() {
        User user = new User(0,
                "user1",
                "firstName",
                "lastName",
                "email",
                "password",
                "phone",
                0);

        Response response = userController.deleteUserByUsername("user1");
        ApiResponse deleteUserResponse = response.as(ApiResponse.class);

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(200, deleteUserResponse.getCode());
        Assertions.assertEquals("unknown", deleteUserResponse.getType());
        Assertions.assertEquals("user1", deleteUserResponse.getMessage());
    }

}
