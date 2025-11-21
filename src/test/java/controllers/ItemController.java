package controllers;

import groovyjarjarantlr4.runtime.Token;
import io.restassured.response.Response;
import models.request.OrderItem;
import models.request.OrderItemRequest;
import models.response.cart.CartResponse;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ItemController extends BaseController {
    private Response response;
    private String token;

//    public Response addItem(String skuId, int qty, String token) {
//        String body = """
//            {"items":[{"skuId":"%s","quantity":%d}]}
//            """.formatted(skuId, qty);
//
//        return given()
//                .spec(spec)
//                .header("authorization", token)
//                .body(body)
//                .post("bag/v1/items")
//                .andReturn();
//    }

    public ItemController addItem(OrderItemRequest items, String token) {
        response = given()
                .spec(spec)
                .header("authorization", token)
                .body(items)
                .post("bag/v1/items")
                .andReturn();

        return this;
    }

    public ItemController getItem(String token) {
        response = given()
                .spec(spec)
                .header("authorization", token)
                .get("bag/v1?inventoryCheck=true")
                .andReturn();

        return this;
    }

    public ItemController editItem(String sku, int qty, String itemId, String token) {

        OrderItemRequest request = OrderItemRequest.builder()
                .items(List.of(
                        OrderItem.builder()
                                .skuId(sku)
                                .itemId(itemId)
                                .quantity(qty)
                                .build()
                ))
                .build();

        response = given()
                .spec(spec)
                .header("authorization", token)
                .body(request)
                .patch("bag/v1/items")
                .andReturn();

        return this;
    }

    public Response getResponse() {
        return response;
    }
}
