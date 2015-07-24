package webstore;

/**
 * Created by I848075 on 14/07/2015.
 */
public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity > 0) {
            testProductStock(product, quantity);
            this.product = product;
            this.quantity = quantity;
        } else {

            throw new quantityShouldBeGreaterThanZero();
        }
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addQuantity(int quantity) {
        if (product != null) {
            if (quantity >= 0) {
                testProductStock(product, this.quantity + quantity);
                this.quantity += quantity;
            }
        }
    }

    public void removeQuantity(int quantity) {
        if (this.quantity <= quantity) {
            this.product = null;
        } else if (product != null && quantity >= 0) {
            this.quantity -= quantity;
        }
    }

    public double getTotalPrice() {
        return this.product.getPrice() * this.quantity;
    }

    public void testProductStock(Product product, int quantity) {
        if (!product.hasInStock(quantity)) {
            throw new NotEnoughtStockForProduct();
        }
    }

    public class NotEnoughtStockForProduct extends RuntimeException {

    }

    public class quantityShouldBeGreaterThanZero extends RuntimeException {

    }

}
