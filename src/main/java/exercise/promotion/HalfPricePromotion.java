package exercise.promotion;

import exercise.productDetail.ActualDetail;
import exercise.productDetail.ShelfDetail;

public class HalfPricePromotion implements Promotion {
    @Override
    public double setPromotion(ShelfDetail shelfDetail) {
        return  shelfDetail.getPrice() * 0.5;
    }

    private boolean isHalfBookPricePromotion(Product product){
        boolean flag = false;
        String date = product.getDate();
        String dateNum = date.split(" ")[1];
        String dateForJudge =  dateNum.split("-")[2];
        if (dateForJudge.equals("1") && product.getName().contains("book") && product.getStore().equals("A")){
            flag = true;
        }
        return flag;
    }
}
