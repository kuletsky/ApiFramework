package testdata;

import models.request.ItemList;
import models.request.OrderItem;
import models.request.OrderItemRequest;

import java.util.List;

public class TestData {
    public static final String VALID_ITEM = "0037099942";

    public static final List<ItemList.Item> VALID_ITEM_OLD = List.of(
            new ItemList.Item(
                    "0037099942",
                    1)
    );

    public static final OrderItemRequest VALID_ITEM_REQUEST =
            OrderItemRequest.builder()
                    .items(List.of(
                            OrderItem.builder()
                                    .skuId(VALID_ITEM)
                                    .quantity(1)
                                    .build()
                    ))
                    .build();

}
