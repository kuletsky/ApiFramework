package models.response.order;

import java.util.List;

public class OrderItemResponse {
    private String cartId;
    private List<String> errors;

    public String getCartId() {
        return cartId;
    }

    public List<String> getErrors() {
        return errors;
    }
}
