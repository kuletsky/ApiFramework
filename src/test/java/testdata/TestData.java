package testdata;

import models.request.ItemList;
import models.request.OrderItem;
import models.request.OrderItemsRequest;
import models.request.User;

import java.util.List;

public class TestData {

    public static final List<ItemList.Item> VALID_ITEM = List.of(
            new ItemList.Item(
                    "0037099942",
                    1)
    );

    public static final OrderItemsRequest VALID_ITEM_REQUEST =
            OrderItemsRequest.builder()
                    .items(List.of(
                            OrderItem.builder()
                                    .skuId("0037099942")
                                    .quantity(1)
                                    .build()
                    ))
                    .build();
}
