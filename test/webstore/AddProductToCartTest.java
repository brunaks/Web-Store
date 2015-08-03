package webstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Bruna Koch Schmitt on 26/07/2015.
 */
public class AddProductToCartTest {

    private FakeRepository repository = new FakeRepository();
    AddProductToCart addToCart;
    ReadCustomersCart readCart;

    @Before
    public void setup() {
        addToCart = new AddProductToCart(this.repository);
        readCart = new ReadCustomersCart(this.repository);
        this.populateFakeRepository();
    }

    private void populateFakeRepository() {
        Customer customer = new Customer();
        customer.setId("customer0001");
        repository.saveCustomer(customer);

        Product product = new Product();
        product.addUnits(30);
        product.setPrice(10.00);
        product.setId("product0001");
        repository.saveProduct(product);

        Product product2 = new Product();
        product2.addUnits(20);
        product2.setPrice(20.00);
        product2.setId("product0002");
        repository.saveProduct(product2);

    }

    @Test
    public void addOneProductAndGetPrice_SameCustomer() {

        addToCart.setCustomer("customer0001");
        addToCart.setProductAndQuantity("product0001", 10);
        addToCart.execute();

        readCart.setCustomer("customer0001");
        Assert.assertEquals(100.0, readCart.getTotalPrice(), 0.001);
    }

    @Test
    public void addTwoProductsAndGetPrice_SameCustomer() {
        addToCart.setCustomer("customer0001");
        addToCart.setProductAndQuantity("product0001", 10);
        addToCart.execute();

        AddProductToCart addToCart2;
        addToCart2 = new AddProductToCart(this.repository);
        addToCart2.setCustomer("customer0001");
        addToCart2.setProductAndQuantity("product0002", 15);
        addToCart2.execute();

        readCart.setCustomer("customer0001");
        Assert.assertEquals(400.00, readCart.getTotalPrice(), 0.001);
    }


    private static class FakeRepository implements Repository {

        private Customer storedCustomer;
        private ArrayList<Product> storedProducts = new ArrayList<Product>();

        @Override
        public Customer getCustomerById(String id) {
            if (storedCustomer.getId().equalsIgnoreCase(id)) {
                return storedCustomer;
            } else {
                throw new Repository.CustomerNotFound();
            }
        }

        @Override
        public void saveCustomer(Customer customer) {
            this.storedCustomer = customer;
        }

        @Override
        public void saveProduct(Product product) {
            this.storedProducts.add(product);
        }

        @Override
        public Product getProductById(String productId) {
            for (int i = 0; i < storedProducts.size(); i++) {
                if (productId.equalsIgnoreCase(this.storedProducts.get(i).getId())) {
                    return this.storedProducts.get(i);
                }
            }
            throw new Repository.ProductNotFound();
        }
    }
}