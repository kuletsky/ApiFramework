import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

import static constants.CommonConstants.BASE_URL;
import static constants.CommonConstants.TOKEN;
import static io.restassured.RestAssured.given;
import static utils.Utils.getToken;

public class AeItemsTest extends AeApiBaseTest {
//    private final String token = Utils.getToken();

    @Test
    void newItem() {
        String body = """
                {"items":[
                    {"skuId":"0037099942",
                    "quantity":1}
                    ]
                }
                """;
        System.out.println("POST " + TOKEN);
        Response response = given()
                .header("aesite", "AEO_US")
                .header("content-type", "application/json")
                .header("authorization", TOKEN)
                .baseUri(BASE_URL + "bag/v1/")
                .when()
                .body(body)
                .post("items")
                .andReturn();

        Assertions.assertEquals(202, response.statusCode());

//        System.out.println("GET " + TOKEN);
//        Response response1 = given()
//                .header("aesite", "AEO_US")
//                .header("content-type", "application/json")
//                .header("authorization", TOKEN)
//                .baseUri(BASE_URL + "bag/v1?inventoryCheck=true")
//                .when()
//                .get()
//                .andReturn();
//
//        Assertions.assertEquals(200, response1.statusCode());
//        System.out.println(response1.asString());
    }
}
