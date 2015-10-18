package exercise.ShoppingCart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<CartItem>();
    private Float cartCosts;
    private Float cartTaxes;
    private String date;
    private String store;

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void setCartCosts(Float cartCosts) {
        this.cartCosts = cartCosts;
    }

    public void setCartTaxes(Float cartTaxes) {
        this.cartTaxes = cartTaxes;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getDate() {
        return date;
    }

    public String getStore() {
        return store;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setProductDate(){
        for (CartItem cartItem : cartItems){
            cartItem.getProduct().setDate(date);
        }
    }

    public void setProductStore(){
        for(CartItem cartItem : cartItems){
            cartItem.getProduct().setStore(store);
        }
    }
}
