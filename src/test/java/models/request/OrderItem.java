package models.request;

public class OrderItem {
    private String skuId;
    private int quantity;

    private OrderItem(Builder builder) {
        this.skuId = builder.skuId;
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
        private int quantity;

        public Builder skuId(String skuId) {
            this.skuId = skuId;
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
