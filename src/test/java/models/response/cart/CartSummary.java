package models.response.cart;

public class CartSummary {
    private String id;
    private double shipping;
    private double shippingTax;
    private double subtotal;
    private double discount;
    private double donation;
    private double subtotalMinusDiscount;
    private double tax;
    private double shippingItemsCost;
    private double pickupItemsCost;
    private double total;
    private double amountUntilFreeShipping;
    private double freeShippingThreshold;
    private double giftCardTotal;
    private double giftCardStandardTotal;
    private double giftCardInstantCreditTotal;
    private double roadDeliveryFee;
    private double creditSavingsAmount;
    private double netTotal;

    public String getId() {
        return id;
    }

    public double getShipping() {
        return shipping;
    }

    public double getShippingTax() {
        return shippingTax;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDiscount() {
        return discount;
    }

    public double getDonation() {
        return donation;
    }

    public double getSubtotalMinusDiscount() {
        return subtotalMinusDiscount;
    }

    public double getTax() {
        return tax;
    }

    public double getShippingItemsCost() {
        return shippingItemsCost;
    }

    public double getPickupItemsCost() {
        return pickupItemsCost;
    }

    public double getTotal() {
        return total;
    }

    public double getAmountUntilFreeShipping() {
        return amountUntilFreeShipping;
    }

    public double getFreeShippingThreshold() {
        return freeShippingThreshold;
    }

    public double getGiftCardTotal() {
        return giftCardTotal;
    }

    public double getGiftCardStandardTotal() {
        return giftCardStandardTotal;
    }

    public double getGiftCardInstantCreditTotal() {
        return giftCardInstantCreditTotal;
    }

    public double getRoadDeliveryFee() {
        return roadDeliveryFee;
    }

    public double getCreditSavingsAmount() {
        return creditSavingsAmount;
    }

    public double getNetTotal() {
        return netTotal;
    }
}
