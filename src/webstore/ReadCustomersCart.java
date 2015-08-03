package webstore;

/**
 * Created by Bruna Koch Schmitt on 02/08/2015.
 */
public class ReadCustomersCart {

    private Repository repository;
    private String customerId;
    private Customer customer;

    public ReadCustomersCart(Repository repository) {
        this.repository = repository;
    }

    public void setCustomer(String customerId) {
        this.customerId = customerId;
        if (!customerIsInRepository()){
            sendErrorThatCustomerWasNotFound();
        }
    }

    private void sendErrorThatCustomerWasNotFound() {

    }

    public double getTotalPrice() {
        return customer.getCart().getTotalPrice();
    }

    private boolean customerIsInRepository() {
        try {
            this.customer = repository.getCustomerById(this.customerId);
            return true;
        }catch (Repository.CustomerNotFound e){
            return false;
        }
    }
}
