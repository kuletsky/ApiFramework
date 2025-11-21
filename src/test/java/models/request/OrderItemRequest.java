package models.request;

import java.util.ArrayList;
import java.util.List;

public class OrderItemRequest {
    private final List<OrderItem> items;

    private OrderItemRequest(Builder builder) {
        // defensive copy
        this.items = List.copyOf(builder.items);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private List<OrderItem> items = new ArrayList<>();

        public Builder items(List<OrderItem> items) {
            this.items = new ArrayList<>(items);
            return this;
        }

        // nice for building payloads in tests:
        public Builder addItem(OrderItem item) {
            this.items.add(item);
            return this;
        }

        public OrderItemRequest build() {
            return new OrderItemRequest(this);
        }
    }
}