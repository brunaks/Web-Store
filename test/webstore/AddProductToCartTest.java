package webstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bruna Koch Schmitt on 26/07/2015.
 */
public class AddProductToCartTest {

    private FakeRepository repository = new FakeRepository();
    AddProductToCart useCase;

    @Before
    public void setup()
    {
        useCase = new AddProductToCart(this.repository);
        this.populateFakeRepository();
    }

    private void populateFakeRepository() {
        Customer customer = new Customer();
        customer.setId("customer0001");

        Product product = new Product();
        product.addUnits(30);
        product.setPrice(10.00);
    }

    @Test
    public void hasRepository()
    {
        Assert.assertNotNull(useCase.getRepository());
    }

    @Test
    public void addOneProductAndGetPrice()
    {

        useCase.setCustomer("customer0001");
        Assert.assertEquals("customer0001", useCase.getCustomerId());

        useCase.setProductAndQuantity("product0001", 10);
        Assert.assertEquals("product0001", useCase.getProductId());
        Assert.assertEquals(10, useCase.getQuantity());

        useCase.execute();


    }


    private static class FakeRepository implements Repository {

        private Customer storedCustomer;
        private Product storedProduct;
        public int storedQuantity;

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

        @Override
        public void saveProduct(Product product) {
            this.storedProduct = product;
        }

        @Override
        public Product getProductById(String productId) {
            return this.storedProduct;
        }

        @Override
        public int getQuantityByProductId(String productId) {
            if (productId == this.storedProduct.getId()) {
                return this.storedQuantity;
            }
            else
            {
                throw new ProductNotFound();
            }
        }

        @Override
        public void saveQuantity(int quantity) {
            this.storedQuantity = quantity;
        }

        public class CustomerNotFound extends RuntimeException {

        }

        public class ProductNotFound extends RuntimeException {

        }
    }
}
