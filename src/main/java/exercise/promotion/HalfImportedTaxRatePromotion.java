package exercise.promotion;

import exercise.productDetail.ActualDetail;
import exercise.productDetail.ShelfDetail;
import exercise.typeAndRate.*;

public class HalfImportedTaxRatePromotion implements Promotion {

    @Override
    public double setPromotion( ShelfDetail shelfDetail) {
        return new ActualTaxRateFactory().getTaxRate(shelfDetail.getProductType());
    }
}
