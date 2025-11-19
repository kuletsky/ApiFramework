package models.request;

import java.util.List;

public class Cart {
    private String cartId;
    private List<String> errors;

    public Cart(String cartId, List<String> errors) {
        this.cartId = cartId;
        this.errors = errors;
    }

    public String getCartId() {
        return cartId;
    }

    public List<String> getErrors() {
        return errors;
    }
}
