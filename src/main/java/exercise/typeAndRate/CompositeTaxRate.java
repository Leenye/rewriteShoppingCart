package exercise.typeAndRate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CompositeTaxRate implements TaxRate {

    private List<TaxRate> taxRateValues = new ArrayList<TaxRate>();

    public CompositeTaxRate(TaxRate... taxRates) {
        for (TaxRate rate : taxRates) {
            taxRateValues.add(rate);
        }
    }

    public double getValue() {
        double taxRate = 0;
        for (TaxRate rate : taxRateValues) {
            taxRate += rate.getValue();
        }
        return new BigDecimal(taxRate).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


}
