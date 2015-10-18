package exercise.parseFile;

import exercise.ShoppingCart.Cart;
import exercise.ShoppingCart.CartItem;
import exercise.ShoppingCart.Product;
import exercise.productDetail.ShelfDetail;
import exercise.ShoppingCart.typeAndRate.ProductType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtParser implements Parser {
    private String filePath;
    private List<String> contents;

    public TxtParser(String filePath) throws IOException {
        this.filePath = filePath;
        this.contents = Files.readAllLines(Paths.get(filePath));
    }

    public List<Cart> parse() {
        ArrayList<Cart> carts = new ArrayList<Cart>();
        String parsedDate = null;
        String parsedStore = null;
        Cart cart = null;
        for (String line : contents) {
            if (line.equals("INPUT")) {
                continue;
            }
            if (line.contains("Input")) {
                cart = new Cart();
                carts.add(cart);
                continue;
            }
            if (line.contains("Date")) {
                parsedDate = line + " " + parseWeekday(preProcessDate(line));
                cart.setDate(parsedDate);
                continue;
            }
            if (line.contains("Store")) {
                parsedStore = parseStore(line);
                cart.setStore(parsedStore);
            }else {
                cart.getCartItems().add(parseItem(line));
                cart.setProductDate();
                cart.setProductStore();
            }
        }
        return carts;
    }

    private CartItem parseItem(String item) {
        Pattern pattern = Pattern.compile("(?<num>\\d)+\\s\\w+");
        Matcher matcher = pattern.matcher(item);
        if (matcher.find()) {
            CartItem cartItem = new CartItem();
            Product product = parseProduct(item);
            int number = Integer.parseInt(matcher.group("num"));
            cartItem.setProduct(product);
            cartItem.setNum(number);
            return cartItem;
        } else {
            throw new IllegalArgumentException("Illegal item input");
        }
    }

    private Product parseProduct(String item) {
        Pattern pattern = Pattern.compile("(?<name>(\\s\\w*)+)\\sat\\s(?<price>.*)");

        Matcher matcher = pattern.matcher(item);
        if (matcher.find()) {
            String name = matcher.group("name");
            double price = Double.parseDouble(matcher.group("price"));
            ProductType productType = ProductType.getProductType(name);
            ShelfDetail shelfDetail = new ShelfDetail(price,productType);

            Product product = new Product(name, productType, shelfDetail);

            return product;
        } else {
            throw new IllegalArgumentException("Illegal item input");
        }
    }

    private String parseWeekday(String date){
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("E");
        Date d = null;
        try {
            d = simpleDate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(d);
    }

    private  String parseStore(String inputStore){
        String store = null;
        Pattern pattern = Pattern.compile("^Store:\\s(?<store>(\\w)+)");
        Matcher matcher = pattern.matcher(inputStore);
        if (matcher.find()){
            store = matcher.group("store");
        }
        return store;
    }

    private String preProcessDate(String inputDate){
        String date = null;
        Pattern pattern = Pattern.compile("^Date:\\s(?<date>(\\d+-*)+)");
        Matcher matcher = pattern.matcher(inputDate);
        if (matcher.find()){
            date = matcher.group("date");
        }
        return date;
    }
}
