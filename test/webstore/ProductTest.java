package webstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by I848075 on 09/07/2015.
 */
public class ProductTest extends EntityTest
{

    private Product product;

    @Before
    public void setUp() throws Exception
    {
        product = new Product();
        super.setUp();
    }

    @Override
    protected Entity getEntity()
    {
        return product;
    }

    @Test
    public void initialNameIsBlank()
    {
        Assert.assertEquals("", product.getName());
    }

    @Test
    public void nameCanBeChanged()
    {
        product.setName("Banana");
        Assert.assertEquals("Banana", product.getName());
    }

    @Test
    public void initialDescriptionIsBlank()
    {

        Assert.assertEquals("", product.getDescription());
    }

    @Test
    public void descriptionCanBeChanged()
    {
        product.setDescription("Fruta Amarela Sem Sementes");
        Assert.assertEquals("Fruta Amarela Sem Sementes", product.getDescription());
    }

    @Test
    public void initialPriceIsZero()
    {

        Assert.assertEquals(0, product.getPrice(), 0.001);
    }

    @Test
    public void productPriceCanBeChanged()
    {
        product.setPrice(3.00);
        Assert.assertEquals(3.00, product.getPrice(), 0.001);
    }

    @Test
    public void initialStockIsZero()
    {
        Assert.assertEquals(false, product.hasInStock(10));
    }

    @Test
    public void productUnitsCanBeAdded()
    {
        product.addUnits(10);
        Assert.assertTrue(product.hasInStock(10));
    }

    @Test
    public void productUnitsCanBeRemoved()
    {
        product.addUnits(20);
        product.removeUnits(10);
        Assert.assertTrue(product.hasInStock(10));
    }

    @Test
    public void productUnitsCannotGoBelowZero()
    {
        product.removeUnits(10);
        Assert.assertEquals(0, product.getStock());
    }

    @Test
    public void hasInStockReturnsTrueIfParameterIsLessThanUnitsAdded()
    {
        product.addUnits(10);
        Assert.assertTrue(product.hasInStock(9));
    }

    @Test
    public void hasInStockReturnsTrueIfParameterIsEqualToUnitsAdded()
    {
        product.addUnits(10);
        Assert.assertTrue(product.hasInStock(10));
    }

    @Test
    public void hasInStockReturnsFalseIfParameterIsGreaterThanUnitsAdded()
    {
        product.addUnits(10);
        Assert.assertFalse(product.hasInStock(11));
    }










}
