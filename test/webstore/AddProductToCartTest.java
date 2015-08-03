package webstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bruna Koch Schmitt on 26/07/2015.
 */
public class AddProductToCartTest {

    private FakeRepository repository = new FakeRepository();
    AddProductToCart addToCart;
    ReadCustomersCart readCart;

    @Before
    public void setUp() throws Exception{
        addToCart = new AddProductToCart(this.repository);
        readCart = new ReadCustomersCart(this.repository);
        this.populateFakeRepository();
    }

    private void populateFakeRepository() {
        Customer customer = new Customer();
        customer.setId("customer0001");
        repository.saveCustomer(customer);

        Customer customer2 = new Customer();
        customer2.setId("customer0002");
        repository.saveCustomer(customer2);

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

    @Test
    public void addAProduct_TwoCustomers() {
        addToCart.setCustomer("customer0001");
        addToCart.setProductAndQuantity("product0001", 10);
        addToCart.execute();

        AddProductToCart addToCart2;
        addToCart2 = new AddProductToCart(this.repository);
        addToCart2.setCustomer("customer0002");
        addToCart2.setProductAndQuantity("product0001", 20);
        addToCart2.execute();

        readCart.setCustomer("customer0001");
        Assert.assertEquals(100.0, readCart.getTotalPrice(), 0.001);

        readCart.setCustomer("customer0002");
        Assert.assertEquals(200.0, readCart.getTotalPrice(), 0.001);
    }

    @Test
    public void addProduct_NotEnoughInStock() {
        addToCart.setCustomer("customer0001");
        addToCart.setProductAndQuantity("product0001", 10);
        addToCart.execute();
    }

}