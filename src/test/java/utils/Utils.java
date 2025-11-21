package utils;

import io.restassured.response.Response;

import static constants.CommonConstants.BASE_URI;
import static io.restassured.RestAssured.given;

public class Utils {
//    private static final String BASE_URL = "https://www.ae.com/ugp-api/";

    public static String getToken() {
        String base64 = "Basic MjBlNDI2OTAtODkzYS00ODAzLTg5ZTctODliZmI0ZWJmMmZlOjVmNDk5NDVhLTdjMTUtNDczNi05NDgxLWU4OGVkYjQwMGNkNg==";

        Response response = given()
                .header("aesite", "AEO_US")
                .header("authorization", base64)
                .baseUri(BASE_URI + "auth/oauth/v5/token")
                .when()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("grant_type", "client_credentials")
                .post()
                .andReturn();


//        System.out.println("Status: " + response.statusCode());

        String accessToken = response.jsonPath().getString("access_token");
//        System.out.println("Token: " + accessToken);

        return "Bearer " + response.jsonPath().getString("access_token");
    }
}
