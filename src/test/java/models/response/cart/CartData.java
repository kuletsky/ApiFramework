package models.response.cart;

import java.util.List;

public class CartData {
    private String id;
    private String currencyCode;
    private List<CartItem> items;
    private CartSummary summary;
    private List<String> warnings;
    private String userType;
    private String profileId;

    public String getId() {
        return id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public CartSummary getSummary() {
        return summary;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public String getUserType() {
        return userType;
    }

    public String getProfileId() {
        return profileId;
    }

    public int getItemCount() {
        return itemCount;
    }

    private int itemCount;
}
