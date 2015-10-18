package exercise.ShoppingCart;

public class CartItem {
    private float num;
    private Product product;

    public float getItemCost(){
        return 0;
    }

    public float getItemTax(){
        return 0;
    }
    
    public float getItemDiscount(){

        return 0;
    }

    public Product getProduct() {
        return product;
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CartItem(Product product, float num) {
        this.product = product;
        this.num = num;
    }

    public CartItem() {
    }
}
