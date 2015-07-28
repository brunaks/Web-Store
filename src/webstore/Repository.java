package webstore;

/**
 * Created by Bruna Koch Schmitt on 26/07/2015.
 */
public interface Repository {

    Customer getCustomerById(String id);
    void saveCustomer(Customer customer);
}
