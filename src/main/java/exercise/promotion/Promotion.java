package exercise.promotion;

import exercise.productDetail.ActualDetail;
import exercise.productDetail.ShelfDetail;

public interface Promotion {
    public ActualDetail setPromotion( ShelfDetail shelfDetail, ActualDetail actualDetail);
}
