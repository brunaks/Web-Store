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
        isProductAlreadyInTheCart(product);
        CartItem item = new CartItem(product, quantity);
        this.items.add(item);
    }

    private void isProductAlreadyInTheCart(Product product)
    {
        for (int i = 0; i < this.items.size(); i++)
        {
            if (this.items.get(i).getProduct() == product)
            {
                throw new ItemIsAlreadyInTheCart();
            }
        }
    }

    public void removeProduct(Product product) {
        for (int i = 0; i < this.items.size(); i++)
        {
            if (this.items.get(i).getProduct() == product)
            {
                this.items.remove(i);
            }
        }
    }

    public class ItemIsAlreadyInTheCart extends RuntimeException {
    }
}
