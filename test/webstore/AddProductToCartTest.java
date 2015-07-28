package webstore;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Bruna Koch Schmitt on 26/07/2015.
 */
public class AddProductToCartTest {

    private FakeRepository repository;
    private Customer michel;

    @Test
    public void addZeroProductsAndGetPrice() {
        michel = new Customer();
        michel.setName("Michel");
        repository = new FakeRepository();
        repository.saveCustomer(michel);

        Assert.assertTrue(michel.getCart().isEmpty());
        Assert.assertEquals(repository.getCustomerById(michel.getId()).getId(), michel.getId());
        Assert.assertEquals(0.0, michel.getCart().getTotalPrice(), 0.001);
    }


    @Test
    public void addOneProductAndGetPrice() {
        michel = new Customer();
        michel.setName("Michel");
        repository = new FakeRepository();
        repository.saveCustomer(michel);

        Assert.assertTrue(michel.getCart().isEmpty());
        Assert.assertEquals(repository.getCustomerById(michel.getId()).getId(), michel.getId());
        Assert.assertEquals(0.0, michel.getCart().getTotalPrice(), 0.001);

        Product banana = new Product();
        banana.addUnits(20);
        banana.setName("Banana");
        banana.setPrice(2.00);
        michel.getCart().addItem(banana, 10);

        Assert.assertFalse(michel.getCart().isEmpty());
        Assert.assertEquals(repository.getCustomerById(michel.getId()).getId(), michel.getId());
        Assert.assertEquals(20.0, michel.getCart().getTotalPrice(), 0.001);

    }

    private static class FakeRepository implements Repository {

        private Customer storedCustomer;

        @Override
        public Customer getCustomerById(String id) {
            if (storedCustomer.getId() == id) {
                return storedCustomer;
            } else {
                throw new CustomerNotFound();
            }
        }

        @Override
        public void saveCustomer(Customer customer) {
            this.storedCustomer = customer;
        }

        public class CustomerNotFound extends RuntimeException {

        }
    }
}
