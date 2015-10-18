package exercise.productDetail;

public class ActualDetail implements ProductDetail {
    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public double getTaxRate() {
        return 0;
    }

    @Override
    public double getTax() {
        return 0;
    }

    @Override
    public double getCost() {
        return 0;
    }
}
