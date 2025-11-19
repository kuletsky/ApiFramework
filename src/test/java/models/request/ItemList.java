package models.request;

import java.util.List;

public record ItemList(List<Item> items) {
    public record Item(String skuId, Integer quantity) {}
}
