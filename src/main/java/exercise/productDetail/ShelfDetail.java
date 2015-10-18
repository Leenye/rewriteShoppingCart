package exercise.productDetail;

import exercise.typeAndRate.ProductType;
import exercise.typeAndRate.ShelfTaxRateFactory;
import exercise.helper.MoneyFormatHelper;

public class ShelfDetail implements ProductDetail {
    private double price;
    private double taxRate;
    private double tax;
    private double cost;

    public ShelfDetail(double price, ProductType productType) {
        this.price = price;
        this.taxRate = getTaxRateByType(productType);
        this.tax = calculateTax();
        this.cost = calculateCost();
    }

    private double getTaxRateByType(ProductType productType) {
        return new ShelfTaxRateFactory().getTaxRate(productType);
    }

    private double calculateTax() {
        return MoneyFormatHelper.round(taxRate * price);
    }

    private double calculateCost() {
        return price + tax;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public double getTax() {
        return tax;
    }

    @Override
    public double getCost() {
        return cost;
    }

}
