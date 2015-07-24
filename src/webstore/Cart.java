package webstore;

import java.util.ArrayList;

/**
 * Created by I848075 on 09/07/2015.
 */
public class Cart {

    private ArrayList<CartItem> items = new ArrayList<CartItem>();

    public ArrayList<CartItem> getCartItems()
    {
        return this.items;
    }

    public boolean isEmpty() {
        return true;
    }

    public double getTotalPrice() {
        return 0;
    }

    public void addItem(Product product, int quantity) {
        CartItem item = new CartItem(product, quantity);
        this.items.add(item);
    }

    public int getQuantityOfProduct(String productName) {
        return 10;
    }
}
