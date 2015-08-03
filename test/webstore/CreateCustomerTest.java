package webstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bruna Koch Schmitt on 02/08/2015.
 */
public class CreateCustomerTest {

    private Repository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = new FakeRepository();
    }

    @Test
    public void createACustomerSuccessfully() {
        CreateCustomer createCustomer = new CreateCustomer(repository);
        createCustomer.setId("customer0001");
        createCustomer.setCustomer("customer0001");
        createCustomer.setName("Bruna");

        ReadCustomerInformation readInfo = new ReadCustomerInformation(repository);
        Assert.assertEquals("Bruna", readInfo.getName());
        Assert.assertEquals("customer0001", readInfo.getId());
    }


}
