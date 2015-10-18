package exercise.promotion;

import exercise.productDetail.ActualDetail;
import exercise.productDetail.ShelfDetail;

public class HalfPricePromotion implements Promotion {
    @Override
    public double setPromotion(ShelfDetail shelfDetail) {
        return  shelfDetail.getPrice() * 0.5;
    }
}
