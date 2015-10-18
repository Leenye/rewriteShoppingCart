package exercise.parseFile;

import exercise.ShoppingCart.typeAndRate.ProductType;

import exercise.ShoppingCart.Cart;
import exercise.ShoppingCart.CartItem;
import exercise.ShoppingCart.Product;
import exercise.productDetail.ShelfDetail;
import exercise.ShoppingCart.typeAndRate.ProductType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TxtParserTest {

    String filePath = "src/test/resources/testfile.txt";

    Parser parser;
    Product product;
    CartItem cartItem;
    String date= "Date: 2015-09-17";

    @Before
    public void setUp() throws IOException {
        parser = new TxtParser(filePath);
        ShelfDetail shelfDetail = new ShelfDetail(12.49, ProductType.DOMESTIC_EXEMPT);
        product = new Product(" book", ProductType.DOMESTIC_EXEMPT,shelfDetail);
        product.setStore("A");
        cartItem = new CartItem(product,1);
    }

    @Test
    public void testParseCart() throws Exception {
        List<Cart> carts = parser.parse();
        Cart parsedCart = carts.get(0);
        assertThat(carts.size(),is(1));
        assertThat(parsedCart.getCartItems().size(),is(3));
        assertThat(parsedCart.getStore(), is("A"));
        assertThat(parsedCart.getDate(),is("Date: 2015-9-7 Mon"));
    }

    @Test
    public void testParseCartItem(){
        List<Cart> carts = parser.parse();
        CartItem parsedCartItem = carts.get(0).getCartItems().get(0);
        Product parsedProduct = carts.get(0).getCartItems().get(0).getProduct();
        assertThat(parsedCartItem.getNum(),is(1F));
        assertThat (parsedProduct.getName(),is(product.getName()));
    }

    @Test
    public void testParseProduct(){
        List<Cart> carts = parser.parse();
        Product parsedProduct = carts.get(0).getCartItems().get(0).getProduct();
        assertThat(parsedProduct.getProductType(), is(ProductType.DOMESTIC_EXEMPT));
        assertThat(parsedProduct.getShelfDetail().getCost(),is(12.49));
        assertThat(parsedProduct.getDate(),is("Date: 2015-9-7 Mon"));
        assertThat(parsedProduct.getStore(),is("A"));
    }

    @After
    public void teardown(){

    }
}