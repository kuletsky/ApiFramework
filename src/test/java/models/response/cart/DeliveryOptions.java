package models.response.cart;

public class DeliveryOptions {
    private boolean shippingAvailable;
    private boolean pickupAvailable;

    public boolean isShippingAvailable() {
        return shippingAvailable;
    }

    public boolean isPickupAvailable() {
        return pickupAvailable;
    }
}
