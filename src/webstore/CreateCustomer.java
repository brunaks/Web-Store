package webstore;

/**
 * Created by Bruna Koch Schmitt on 02/08/2015.
 */
public class CreateCustomer {


    private Repository repository;
    private String name;
    private Customer customer;
    private String customerId;

    public CreateCustomer(Repository repository) {
        this.repository = repository;
    }

    public void setId(String customerId) {
        this.customerId = customerId;
        this.customer = new Customer();
        customer.setId(customerId);
        repository.saveCustomer(customer);
    }

    public void setName(String name) {
        this.name = name;
        Customer customer = repository.getCustomerById(this.customerId);
        customer.setName(name);
        repository.saveCustomer(customer);
    }

    public void setCustomer(String customerId) {
        this.customerId = customerId;
    }
}
