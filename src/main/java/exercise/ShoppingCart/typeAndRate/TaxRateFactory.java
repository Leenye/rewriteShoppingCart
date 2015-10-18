package exercise.ShoppingCart.typeAndRate;

import exercise.ShoppingCart.Product;

import java.math.BigDecimal;
import java.util.EnumMap;

public class TaxRateFactory {

    private EnumMap<ProductType, TaxRate> productTaxRate = new EnumMap<ProductType, TaxRate>(ProductType.class);
    private double importedTaxRateAddition = 0.05;
    private double domesticTaxableRate = 0.1;
    private double domesticExemptRate = 0;

    public  TaxRateFactory() {
        productTaxRate.put(ProductType.DOMESTIC_EXEMPT, new DomesticTaxRate(domesticExemptRate));
        productTaxRate.put(ProductType.DOMESTIC_TAXABLE, new DomesticTaxRate(domesticTaxableRate));
        productTaxRate.put(ProductType.IMPORTED_EXEMPT, new ImportedTaxRate(domesticExemptRate, importedTaxRateAddition));
        productTaxRate.put(ProductType.IMPORTED_TAXABLE, new ImportedTaxRate(domesticTaxableRate, importedTaxRateAddition));
    }

    public double getTaxRate(ProductType productType ) {
        if (productTaxRate.containsKey(productType)) {
            double taxRate = productTaxRate.get(productType).getValue();
            return new BigDecimal(taxRate).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
        } else {
            throw new IllegalArgumentException("unspported product type");
        }
    }
}
