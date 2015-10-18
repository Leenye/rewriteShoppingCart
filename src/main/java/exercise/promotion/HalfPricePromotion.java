package exercise.promotion;

import exercise.productDetail.ActualDetail;
import exercise.productDetail.ShelfDetail;

public class HalfPricePromotion implements Promotion {
    @Override
    public ActualDetail setPromotion(ShelfDetail shelfDetail, ActualDetail actualDetail) {
        actualDetail.setPrice(shelfDetail.getPrice() * 0.5);
        return actualDetail;
    }
}
