package exercise.promotion;

import exercise.productDetail.ActualDetail;
import exercise.productDetail.ShelfDetail;
import exercise.typeAndRate.*;

public class HalfImportedTaxRatePromotion implements Promotion {

    @Override
    public ActualDetail setPromotion( ShelfDetail shelfDetail, ActualDetail actualDetail) {
        actualDetail.setTaxRate(new ActualTaxRateFactory().getTaxRate(actualDetail.getProductType()));
        return actualDetail;
    }
}
