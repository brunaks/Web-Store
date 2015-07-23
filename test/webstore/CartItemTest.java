package webstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webstore.CartItem;

/**
 * Created by I848075 on 14/07/2015.
 */
public class CartItemTest
{

    public CartItem cartItem;
    public Product product;

    @Before
    public void setUp() throws Exception
    {
        cartItem = new CartItem();
        product = new Product();
        product.addUnits(20);
    }

    @Test
    public void initialCartItemIsEmpty()
    {
        Assert.assertTrue(cartItem.isEmpty());
    }

    @Test
    public void initialCartItemHasNullProduct()
    {
        Assert.assertEquals(null, cartItem.getProduct());
    }

    @Test
    public void initialCartItemUnitsIsZero()
    {
        Assert.assertEquals(0.0, cartItem.getUnits(), 0.001);
    }

    @Test
    public void productCanBeAddedToCartItem()
    {
        cartItem.addProduct(product, 10);
        product.setName("Banana Caturra");
        Assert.assertEquals("Banana Caturra", cartItem.getProduct().getName());
    }

    @Test
    public void productUnitsCanBeAddedToTheProduct()
    {
        cartItem.addProduct(product, 10);
        Assert.assertEquals(10, cartItem.getUnits());
    }

    @Test
    public void productUnitsCannotBeEqualZeroWhenProductIsAdded()
    {
        cartItem.addProduct(product, 0);
        Assert.assertEquals(null, cartItem.getProduct());
    }

    @Test
    public void productUnitsCannotBeBelowZeroWhenProductIsAdded()
    {
        cartItem.addProduct(product, -2);
        Assert.assertEquals(null, cartItem.getProduct());
    }

    @Test
    public void unitsCanBeAdded()
    {
        cartItem.addProduct(product, 10);
        cartItem.addUnits(10);
        Assert.assertEquals(20, cartItem.getUnits());
    }

    @Test
    public void unitsCanBeRemoved()
    {
        cartItem.addProduct(product, 10);
        cartItem.removeUnits(4);
        Assert.assertEquals(6, cartItem.getUnits());
    }

    @Test
    public void unitsCanOnlyBeRemovedWhenProductIsNotNull()
    {
        cartItem.removeUnits(10);
        Assert.assertEquals(0, cartItem.getUnits());
    }

    @Test
    public void unitsCanOnlyBeAddedWhenProductIsNotNull()
    {
        cartItem.addUnits(10);
        Assert.assertEquals(0, cartItem.getUnits());
    }

    @Test
    public void productUnitsCannotBeBelowZeroWhenUnitsAreAdded()
    {
        cartItem.addProduct(product, 10);
        cartItem.addUnits(-8);
        Assert.assertEquals(10, cartItem.getUnits());
    }

    @Test
    public void productUnitsCannotBeBelowZeroWhenUnitsAreRemoved()
    {
        cartItem.addProduct(product, 10);
        cartItem.removeUnits(-5);
        Assert.assertEquals(10, cartItem.getUnits());
    }

    @Test
    public void cartItemIsNotEmptyIfItHasAProduct()
    {
        cartItem.addProduct(product, 10);
        Assert.assertFalse(cartItem.isEmpty());
    }

    @Test
    public void cartItemCannotHaveProductWithZeroUnitsWhenRemovingUnits_productIsDeleted()
    {
        cartItem.addProduct(product, 10);
        cartItem.removeUnits(10);
        Assert.assertNull(cartItem.getProduct());
    }

    @Test (expected = CartItem.NotEnoughtStockForProduct.class)
    public void cartItemTestsProductStockBeforeAddingProduct()
    {
        cartItem.addProduct(product, 25);
    }


    //cartItemCanReturnProduct
    //cartItemCanReturnUnitsOfProduct
    //cartItemCanReturnItsTotalPrice
    //cartItemCanReturnItsNumberOfProductUnits
    //cartItemMustTestIfProductHasUnitsInStock

    // cartItemCanReturnNameOfProduct
    //cartItemCanSetNameOfProduct
    //cartItemCanSet...
}
