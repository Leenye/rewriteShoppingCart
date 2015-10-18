package exercise.typeAndRate;

public class DomesticTaxRate implements TaxRate {
    private double domesticRate;

    public DomesticTaxRate(double domesticRate) {
        this.domesticRate = domesticRate;
    }

    public double getValue() {
        return domesticRate;
    }
}
