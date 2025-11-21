import controllers.ItemController;
import io.restassured.response.Response;
import models.response.cart.*;
import models.response.order.OrderItemResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static testdata.TestData.*;

public class ItemsTest {
    private String token;

    @BeforeEach
    void setUp() {
        token = Utils.getToken();
    }

//    @Test
//    void newItemOld() {
//        String body = """
//                {"items":[
//                    {"skuId":"0037099942",
//                    "quantity":1}
//                    ]
//                }
//                """;
//        System.out.println("POST " + token);
//        Response response = given()
//                .header("aesite", "AEO_US")
//                .header("content-type", "application/json")
//                .header("authorization", token)
//                .baseUri(BASE_URI + "bag/v1/")
//                .when()
//                .body(body)
//                .post("items")
//                .andReturn();
//
//        Assertions.assertEquals(202, response.statusCode());
//
//        System.out.println("GET " + token);
//        Response response1 = given()
//                .header("aesite", "AEO_US")
//                .header("content-type", "application/json")
//                .header("authorization", token)
//                .baseUri(BASE_URI + "bag/v1?inventoryCheck=true")
//                .when()
//                .get()
//                .andReturn();
//
//        Assertions.assertEquals(200, response1.statusCode());
//        System.out.println(response1.asString());
//    }

    @Test
    void addNewItem() {
        Response response = new ItemController()
                .addItem(VALID_ITEM_REQUEST, token)
                .getResponse();

        OrderItemResponse itemResponse = response.as(OrderItemResponse.class);

        assertAll(
                () -> assertEquals(202, response.statusCode()),
                () -> assertNotNull(itemResponse.getCartId()),
                () -> assertFalse(itemResponse.getCartId().isEmpty()),
                () -> assertNotNull(itemResponse.getErrors()),
                () -> assertEquals(0, itemResponse.getErrors().size())
        );
    }

    @Test
    void getItem() {
        Response response = new ItemController()
                .addItem(VALID_ITEM_REQUEST, token)
                .getItem(token)
                .getResponse();

        CartResponse cartResponse = response.as(CartResponse.class);

        CartData data = cartResponse.getData();
        CartSummary summary = data.getSummary();
        CartItem item = data.getItems().getFirst();

        assertAll(
                // HTTP / envelope
                () -> assertEquals(200, response.statusCode()),
                () -> assertNotNull(data, "data should not be null"),
                () -> assertTrue(cartResponse.getErrors().isEmpty(), "errors list should be empty"),

                // Cart-level info
                () -> assertNotNull(data.getId()),
                () -> assertFalse(data.getId().isEmpty()),
                () -> assertEquals("USD", data.getCurrencyCode()),
                () -> assertEquals("GUEST", data.getUserType()),
                () -> assertNotNull(data.getProfileId()),
                () -> assertFalse(data.getProfileId().isEmpty()),
                () -> assertEquals(1, data.getItemCount()),
                () -> assertFalse(data.getItems().isEmpty()),

                // Summary
                () -> assertNotNull(summary),
                () -> assertEquals(35.91, summary.getTotal(), 0.001),
                () -> assertEquals(35.91, summary.getNetTotal(), 0.001),
                () -> assertEquals(75.0, summary.getFreeShippingThreshold(), 0.001),
                () -> assertEquals(0.0, summary.getTax(), 0.001),

                // Single item
                () -> assertEquals(1, data.getItems().size()),
                () -> assertEquals(1, item.getQuantity()),
                () -> assertEquals(27.96, item.getPrice(), 0.001),
                () -> assertEquals("0037099942", item.getSku())
        );
    }

    @Test
    void editItem() {
        ItemController itemController = new ItemController();

        //Arrange
        itemController.addItem(VALID_ITEM_REQUEST, token);

        CartResponse cartBefore = itemController.getItem(token)
                .getResponse()
                .as(CartResponse.class);

        CartItem itemBefore = cartBefore.getData().getItems().getFirst();

        //Act
        Response response = itemController
                .editItem(VALID_ITEM, 4, itemBefore.getItemId(), token)
                .getResponse();
        OrderItemResponse itemResponse = response.as(OrderItemResponse.class);

        CartItem itemAfter = itemController
                .getItem(token)
                .getResponse()
                .as(CartResponse.class)
                .getData()
                .getItems()
                .getFirst();

        //Assert
        assertAll(
                () -> assertEquals(202, response.statusCode()),
                () -> assertNotNull(itemResponse.getCartId()),
                () -> assertFalse(itemResponse.getCartId().isEmpty()),
                () -> assertNotNull(itemResponse.getErrors()),
                () -> assertEquals(0, itemResponse.getErrors().size()),

                () -> assertEquals(1, itemBefore.getQuantity()),
                () -> assertEquals(4, itemAfter.getQuantity())
        );
    }

    @Test
    void deleteItem() {
        Response response = new ItemController()
                .addItem(VALID_ITEM_REQUEST, token)
                .deleteItem(VALID_ITEM, token)
                .getResponse();
    }
}
