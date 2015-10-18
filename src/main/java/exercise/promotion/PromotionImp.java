package exercise.promotion;

import exercise.ShoppingCart.Product;
import exercise.productDetail.ActualDetail;
import exercise.productDetail.ShelfDetail;

import java.util.ArrayList;
import java.util.List;

public class PromotionImp implements Promotion {
    List<Promotion> promotionList = new ArrayList<Promotion>();
    ActualDetail promotedActualDetail;

    public ActualDetail setPromotion(ShelfDetail shelfDetail, ActualDetail actualDetail) {

        promotionList.add(new HalfPricePromotion());
        promotionList.add(new HalfImportedTaxRatePromotion());
        for (Promotion promotion : promotionList) {
            promotedActualDetail = promotion.setPromotion(shelfDetail, actualDetail);
        }
        return promotedActualDetail;
    }
}
