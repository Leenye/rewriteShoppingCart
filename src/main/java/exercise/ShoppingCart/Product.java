package exercise.ShoppingCart;

import exercise.productDetail.ShelfDetail;
import exercise.ShoppingCart.typeAndRate.ProductType;

public class Product {
    private String name;
    private String date;
    private String store;
    private ProductType productType;

    private ShelfDetail shelfDetail;

//    private double shelfPrice;
//    private double soldPrice;
//    private double taxRate;
//    private double tax;

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getStore() {
        return store;
    }

    public ProductType getProductType() {
        return productType;
    }

    public ShelfDetail getShelfDetail() {
        return shelfDetail;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product(String name,  ProductType productType, ShelfDetail shelfDetail) {
        this.name = name;
        this.productType = productType;
        this.shelfDetail = shelfDetail;
    }
}
