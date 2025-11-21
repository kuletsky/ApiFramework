package models.response.cart;

public class PriceDetail {
    private boolean discounted;
    private double amount;
    private int quantity;
    private double returnValue;
    private double orderDiscountShare;
    private double highBound;
    private double lowBound;

    public boolean isDiscounted() {
        return discounted;
    }

    public double getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getReturnValue() {
        return returnValue;
    }

    public double getOrderDiscountShare() {
        return orderDiscountShare;
    }

    public double getHighBound() {
        return highBound;
    }

    public double getLowBound() {
        return lowBound;
    }
}
