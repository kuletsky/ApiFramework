package controllers;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ItemController extends BaseController {

    public Response addItem(String skuId, int qty, String token) {
        String body = """
            {"items":[{"skuId":"%s","quantity":%d}]}
            """.formatted(skuId, qty);

        return given()
                .spec(spec)
                .header("authorization", token)
                .body(body)
                .post("bag/v1/items")
                .andReturn();
    }

}
