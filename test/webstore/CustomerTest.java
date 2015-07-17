package webstore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by I848075 on 09/07/2015.
 */
public class CustomerTest extends EntityTest
{

    private Customer customer;

    @Before
    public void setUp() throws Exception
    {
        customer = new Customer();
        super.setUp();
    }

    @Test
    public void initialNameIsBlank()
    {

        String name = customer.getName();
        assertEquals("", name);

    }

    @Test
    public void nameCanBeChanged()
    {
        customer.setName("Bruna");
        String name = customer.getName();
        assertEquals("Bruna", name);

    }

    @Test
    public void initialCartIsEmpty()
    {
        assertTrue(customer.getCart().isEmpty());
    }


    @Override
    protected Entity getEntity()
    {
        return this.customer;
    }
}
