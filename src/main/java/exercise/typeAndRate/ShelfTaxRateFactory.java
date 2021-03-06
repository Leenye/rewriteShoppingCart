package exercise.typeAndRate;

import java.math.BigDecimal;
import java.util.EnumMap;

public class ShelfTaxRateFactory {

    private EnumMap<ProductType, TaxRate> productTaxRate = new EnumMap<ProductType, TaxRate>(ProductType.class);
    static TaxRate domesticRate = new DomesticTaxRate(0.10);
    static TaxRate domesticExempt = new DomesticTaxRate(0.00);
    static TaxRate importedRate = new ImportedTaxRate(0.05);
    static TaxRate discountRate = new ImportedTaxRate(0.025);

    static TaxRate domesticTaxableRate = new CompositeTaxRate(domesticRate);
    static TaxRate domesticExemptRate = new CompositeTaxRate(domesticExempt);
    static TaxRate importedTaxableRate = new CompositeTaxRate(domesticRate, importedRate);
    static TaxRate importedExemptRate = new CompositeTaxRate(domesticExempt, importedRate);

    public ShelfTaxRateFactory() {
        productTaxRate.put(ProductType.DOMESTIC_EXEMPT, domesticExemptRate);
        productTaxRate.put(ProductType.DOMESTIC_TAXABLE, domesticTaxableRate);
        productTaxRate.put(ProductType.IMPORTED_EXEMPT, importedExemptRate);
        productTaxRate.put(ProductType.IMPORTED_TAXABLE, importedTaxableRate);
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
