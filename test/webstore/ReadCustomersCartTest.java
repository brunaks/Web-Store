package webstore;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bruna Koch Schmitt on 02/08/2015.
 */
public class ReadCustomersCartTest {

    ReadCustomersCart readCart;
    Repository repository;

    @Before
    public void setUp() throws Exception {
        readCart = new ReadCustomersCart(repository);
        repository = new FakeRepository();
    }

    @Test
    public void readCartOfCustomerThatDoesNotExist() {
        readCart.getTotalPrice();
        // Testar se o método de erro foi chamado
    }
}
