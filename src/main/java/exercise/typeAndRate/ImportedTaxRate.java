package exercise.typeAndRate;

public class ImportedTaxRate implements TaxRate {
    private double domesticRate;
    private double importedRate;

    public ImportedTaxRate(double domesticRate, double importedRate) {
        this.domesticRate = domesticRate;
        this.importedRate = importedRate;
    }

    public double getDomesticRate() {
        return domesticRate;
    }

    public double getImportedRate() {
        return importedRate;
    }

    public void setDomesticRate(double domesticRate) {
        this.domesticRate = domesticRate;
    }

    public void setImportedRate(double importedRate) {
        this.importedRate = importedRate;
    }

    public double getValue(){
        return domesticRate+importedRate;
    }
}
