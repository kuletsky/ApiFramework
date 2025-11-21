package models.response.cart;

import java.util.List;

public class CartItem {
    private String itemId;
    private int quantity;
    private double discount;
    private double originalPrice;
    private double price;
    private double tax;
    private boolean discounted;
    private int discountPercent;
    private boolean gwp;
    private String itemType;
    private String productId;
    private String productStyle;
    private String productName;
    private String size;
    private String color;
    private List<Object> promotions; // again, simple for now
    private String sku;
    private double unitListPrice;
    private double unitSalePrice;
    private boolean available;
    private List<Object> closenessQualifiers;
    private boolean onDemandItem;
    private String brand;
    private boolean editable;
    private int availabilityStatus;
    private DeliveryOptions deliveryOptions;
    private String addItemTime;          // you can later map to Instant/OffsetDateTime if you like
    private ProductDetails productDetails;
    private double returnValue;
    private double discountAdjustment;
    private List<PriceDetail> priceDetails;
    private boolean hazmat;
    private boolean clearance;
    private boolean nonreturnable;

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getPrice() {
        return price;
    }

    public double getTax() {
        return tax;
    }

    public boolean isDiscounted() {
        return discounted;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public boolean isGwp() {
        return gwp;
    }

    public String getItemType() {
        return itemType;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductStyle() {
        return productStyle;
    }

    public String getProductName() {
        return productName;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public List<Object> getPromotions() {
        return promotions;
    }

    public String getSku() {
        return sku;
    }

    public double getUnitListPrice() {
        return unitListPrice;
    }

    public double getUnitSalePrice() {
        return unitSalePrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public List<Object> getClosenessQualifiers() {
        return closenessQualifiers;
    }

    public boolean isOnDemandItem() {
        return onDemandItem;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isEditable() {
        return editable;
    }

    public int getAvailabilityStatus() {
        return availabilityStatus;
    }

    public DeliveryOptions getDeliveryOptions() {
        return deliveryOptions;
    }

    public String getAddItemTime() {
        return addItemTime;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public double getReturnValue() {
        return returnValue;
    }

    public double getDiscountAdjustment() {
        return discountAdjustment;
    }

    public List<PriceDetail> getPriceDetails() {
        return priceDetails;
    }

    public boolean isHazmat() {
        return hazmat;
    }

    public boolean isClearance() {
        return clearance;
    }

    public boolean isNonreturnable() {
        return nonreturnable;
    }
}
