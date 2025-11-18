import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constants.CommonConstants.BASE_URI;
import static io.restassured.RestAssured.given;

public class CartTest extends AeApiBaseTest{
//    private final String token = Utils.getToken();

    @Test
    void getItemCart() {
        System.out.println(TOKEN);
        Response response = given()
                .header("aesite", "AEO_US")
                .header("content-type", "application/json")
                .header("authorization", TOKEN)
                .baseUri(BASE_URI + "bag/v1?inventoryCheck=true")
                .when()
                .get()
                .andReturn();

        Assertions.assertEquals(200, response.statusCode());
        System.out.println(response.asString());
    }

}
