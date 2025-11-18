import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

import static constants.CommonConstants.BASE_URL;
import static constants.CommonConstants.TOKEN;
import static io.restassured.RestAssured.given;
import static utils.Utils.getToken;

public class AeCartTest extends AeApiBaseTest{
//    private final String token = Utils.getToken();

    @Test
    void getItemCart() {
        System.out.println(TOKEN);
        Response response = given()
                .header("aesite", "AEO_US")
                .header("content-type", "application/json")
                .header("authorization", TOKEN)
                .baseUri(BASE_URL + "bag/v1?inventoryCheck=true")
                .when()
                .get()
                .andReturn();

        Assertions.assertEquals(200, response.statusCode());
        System.out.println(response.asString());
    }
}
