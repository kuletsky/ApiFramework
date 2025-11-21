package models.response.cart;

import java.util.List;

public class CartResponse {
    private CartData data;
    private List<String> errors;

    public CartData getData() {
        return data;
    }

    public List<String> getErrors() {
        return errors;
    }
}
