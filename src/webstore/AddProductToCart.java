package webstore;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Bruna Koch Schmitt on 24/07/2015.
 */
public class AddProductToCart {

    private Repository repository;
    private String customerId;
    private String productId;
    private int quantity;
    private boolean successful;

    public AddProductToCart(Repository repository)
    {
        this.repository = repository;
    }

    public Repository getRepository()
    {
        return this.repository;
    }

    public boolean execute() {

        Customer customer = repository.getCustomerById(customerId);
        Product product = repository.getProductById(productId);

        try
        {
            customer.getCart().addItem(product, this.quantity);
            return this.successful = true;
        }
        catch (CartItem.NotEnoughtStockForProduct e)
        {
            return this.successful = false;
        }
    }

    public void setCustomer(String customerId) {
        this.customerId = customerId;
    }

    public void setProductAndQuantity(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
