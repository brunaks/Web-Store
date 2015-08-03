package webstore;

/**
 * Created by Bruna Koch Schmitt on 24/07/2015.
 */
public class AddProductToCart {

    private Repository repository;
    private String customerId;
    private String productId;
    private int quantity;
    private boolean successful;
    private Customer customer;
    private Product product;

    public AddProductToCart(Repository repository)
    {
        this.repository = repository;
    }

    public Repository getRepository()
    {
        return this.repository;
    }

    public boolean execute() {
        return productIsAddedToCart();
    }

    private boolean productIsAddedToCart() {
        try {
            customer.getCart().addItem(this.product, this.quantity);
            repository.saveCustomer(customer);
            return this.successful = true;
        }
        catch (CartItem.NotEnoughtStockForProduct e) {
            return this.successful = false;
        }
    }

    private boolean productIsInRepository() {
        try {
            this.product = repository.getProductById(this.productId);
            return true;
        } catch (Repository.ProductNotFound e) {
            return false;
        }
    }

    private boolean customerIsInRepository() {
        try {
            this.customer = repository.getCustomerById(this.customerId);
            return true;
        }catch (Repository.CustomerNotFound e){
            return false;
        }
    }

    public void setCustomer(String customerId) {
        this.customerId = customerId;
        if (!customerIsInRepository()) {
            sendErrorThatCustomerWasNotFound();
        }
    }

    private void sendErrorThatCustomerWasNotFound() {
    }

    public void setProductAndQuantity(String productId, int quantity) {
        this.productId = productId;
        if (!productIsInRepository()) {
            sendErrorThatProductWasNotFound();
        }
        this.quantity = quantity;
    }

    private void sendErrorThatProductWasNotFound() {
    }

}
