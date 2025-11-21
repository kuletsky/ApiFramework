package models.request;

public class OrderItem {
    private final String skuId;
    private final int quantity;
    private final String itemId;

    private OrderItem(Builder builder) {
        this.skuId = builder.skuId;
        this.itemId = builder.itemId;
        this.quantity = builder.quantity;

    }

    public String getSkuId() {
        return skuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String skuId;
        private String itemId;
        private int quantity;

        public Builder skuId(String skuId) {
            this.skuId = skuId;
            return this;
        }

        public Builder itemId(String itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderItem build() {
            // optional simple validation
            return new OrderItem(this);
        }
    }
}
