package exercise.typeAndRate;

public enum ProductType {
    DOMESTIC_TAXABLE, DOMESTIC_EXEMPT, IMPORTED_TAXABLE, IMPORTED_EXEMPT;

    public static ProductType getProductType(String productName) {
        if (isImported(productName)) {
            if (isBasicExempt(productName)) {
                return ProductType.IMPORTED_EXEMPT;
            }
            return ProductType.IMPORTED_TAXABLE;
        } else {
            if (isBasicExempt(productName)) {
                return ProductType.DOMESTIC_EXEMPT;
            }
            return ProductType.DOMESTIC_TAXABLE;
        }
    }

    public static boolean isImported(String productName) {
        if (productName.contains("imported")) {
            return true;
        }
        return false;
    }

    public static boolean isBasicExempt(String productName) {
        if (productName.contains("book") || productName.contains("chocolate") || productName.contains("pills")) {
            return true;
        }
        return false;
    }
}
