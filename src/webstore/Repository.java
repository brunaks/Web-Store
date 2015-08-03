package webstore;

/**
 * Created by Bruna Koch Schmitt on 26/07/2015.
 */
public interface Repository {

    void saveCustomer(Customer customer);
    void saveProduct(Product product);
    Customer getCustomerById(String id);
    Product getProductById(String productId);

    class CustomerNotFound extends RuntimeException {

    }

    class ProductNotFound extends RuntimeException {

    }
}
