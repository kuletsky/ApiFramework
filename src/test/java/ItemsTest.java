import controllers.ItemController;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.Utils;

import static constants.CommonConstants.BASE_URI;
import static io.restassured.RestAssured.given;
import static testdata.TestData.VALID_ITEM;
import static testdata.TestData.VALID_ITEM_REQUEST;

public class ItemsTest {
    private static String token;

    @BeforeAll
    static void setUp() {
        token = Utils.getToken();
    }

    @Test
    void newItemOld() {
        String body = """
                {"items":[
                    {"skuId":"0037099942",
                    "quantity":1}
                    ]
                }
                """;
        System.out.println("POST " + token);
        Response response = given()
                .header("aesite", "AEO_US")
                .header("content-type", "application/json")
                .header("authorization", token)
                .baseUri(BASE_URI + "bag/v1/")
                .when()
                .body(body)
                .post("items")
                .andReturn();

        Assertions.assertEquals(202, response.statusCode());

        System.out.println("GET " + token);
        Response response1 = given()
                .header("aesite", "AEO_US")
                .header("content-type", "application/json")
                .header("authorization", token)
                .baseUri(BASE_URI + "bag/v1?inventoryCheck=true")
                .when()
                .get()
                .andReturn();

        Assertions.assertEquals(200, response1.statusCode());
        System.out.println(response1.asString());
    }

    @Test
    void addNewItem() {
        System.out.println("POST " + token);


        Response response = new ItemController()
//                .addItem("0037099942", 1, token)
                .addItem(VALID_ITEM_REQUEST, token);

        System.out.println(VALID_ITEM_REQUEST);

        Assertions.assertEquals(202, response.statusCode());
        Assertions.assertNotNull(response.jsonPath().getString("cartId"));
        Assertions.assertFalse(response.jsonPath().getString("cartId").isEmpty());

        Assertions.assertNotNull(response.jsonPath().getString("errors"));
        Assertions.assertEquals(0, response.jsonPath().getList("errors").size());

    }
}
