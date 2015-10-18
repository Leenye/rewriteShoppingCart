package exercise.productDetail;

import exercise.promotion.HalfImportedTaxRatePromotion;
import exercise.promotion.HalfPricePromotion;
import exercise.typeAndRate.ProductType;

public class ActualDetail implements ProductDetail {
    private double price;
    private double taxRate;
    private double tax;
    private double cost;
    private ProductType productType;
    private ShelfDetail shelfDetail;

    HalfImportedTaxRatePromotion halfImportedTaxRatePromotion = new HalfImportedTaxRatePromotion();
    HalfPricePromotion halfPricePromotion = new HalfPricePromotion();


    public ActualDetail(ProductType productType,ShelfDetail shelfDetail) {
        this.productType = productType;
        this.shelfDetail = shelfDetail;
        this.taxRate = shelfDetail.getTaxRate();
        this.price = shelfDetail.getPrice();
    }

    public ActualDetail() {
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public double getPrice() {
        double promotedPrice = halfPricePromotion.setPromotion(shelfDetail);
        return promotedPrice == 0 ? price : promotedPrice;
    }

    @Override
    public double getTaxRate() {
        double promotedTaxRate = promotionImp.setPromotion(shelfDetail,this).getTaxRate();
        return promotedTaxRate  == 0 ? taxRate : promotedTaxRate;
    }

    @Override
    public double getTax() {
        return getTaxRate()*getPrice();
    }

    @Override
    public double getCost() {
        return getPrice()+getTax();
    }
}
