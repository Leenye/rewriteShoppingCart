package exercise.typeAndRate;

public class ImportedTaxRate implements TaxRate {
    private double importedRate;

    public ImportedTaxRate( double importedRate) {
        this.importedRate = importedRate;
    }


    public double getImportedRate() {
        return importedRate;
    }

    public void setImportedRate(double importedRate) {
        this.importedRate = importedRate;
    }

    public double getValue(){
        return importedRate;
    }
}
