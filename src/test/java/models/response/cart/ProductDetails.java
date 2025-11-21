package models.response.cart;

import java.util.List;

public class ProductDetails {
    private String brand;
    private String productName;
    private String productType;
    private String productDept;
    private String productStyle;
    private String productColor;
    private String productClass;
    private String skuSize;
    private String productId;
    private boolean onHold;
    private String taxCode;
    private List<String> productExcludedSites;
    private List<String> skuExcludedSites;
    private List<String> productClearanceSites;
    private boolean productNonReturnable;
    private Object returnInfo; // keep loose until you need it
    private boolean isProductHazmat;
    private boolean isProductThirdParty;

    public String getBrand() {
        return brand;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductDept() {
        return productDept;
    }

    public String getProductStyle() {
        return productStyle;
    }

    public String getProductColor() {
        return productColor;
    }

    public String getProductClass() {
        return productClass;
    }

    public String getSkuSize() {
        return skuSize;
    }

    public String getProductId() {
        return productId;
    }

    public boolean isOnHold() {
        return onHold;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public List<String> getProductExcludedSites() {
        return productExcludedSites;
    }

    public List<String> getSkuExcludedSites() {
        return skuExcludedSites;
    }

    public List<String> getProductClearanceSites() {
        return productClearanceSites;
    }

    public boolean isProductNonReturnable() {
        return productNonReturnable;
    }

    public Object getReturnInfo() {
        return returnInfo;
    }

    public boolean isProductHazmat() {
        return isProductHazmat;
    }

    public boolean isProductThirdParty() {
        return isProductThirdParty;
    }

    public boolean isSkuOnDemand() {
        return isSkuOnDemand;
    }

    private boolean isSkuOnDemand;
}
