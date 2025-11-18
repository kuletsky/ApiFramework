package controllers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static constants.CommonConstants.BASE_URI;

public class BaseController {
    protected final RequestSpecification spec;

    protected BaseController() {
        spec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .addHeader("aesite", "AEO_US")
                .build();
    }

}
