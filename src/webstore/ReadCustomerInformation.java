package webstore;

/**
 * Created by Bruna Koch Schmitt on 03/08/2015.
 */
public class ReadCustomerInformation {

    private Repository repository;
    private Customer customer;
    private String customerId;

    public ReadCustomerInformation(Repository repository) {
        this.repository = repository;
    }

    public void setCustomer(String customerId) {
        if (!customerIsInRepository()) {
            sendErrorThatCustomerWasNotFound();
        }
    }

    public String getName() {
        return this.customer.getName();
    }

    private void sendErrorThatCustomerWasNotFound() {
    }

    public String getId() {
        return customerId;
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
