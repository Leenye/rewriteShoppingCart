package exercise.ShoppingCart;

import exercise.productDetail.ActualDetail;
import exercise.productDetail.ShelfDetail;
import exercise.typeAndRate.ProductType;

public class Product {
    private String name;
    private String date;
    private String store;

    private ProductType productType;
    private ShelfDetail shelfDetail;
    private ActualDetail actualDetail;

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

    public ActualDetail getActualDetail() {
        return actualDetail;
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
