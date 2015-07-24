package webstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        product = new Product();
        product.addUnits(20);
        cartItem = new CartItem(product, 10);
    }

    @Test
    public void initialCartItemMustHaveAProduct()
    {
        Assert.assertNotNull(cartItem.getProduct());
    }

    @Test
    public void initialCartItemMustHaveAQuantity()
    {
        Assert.assertEquals(10, cartItem.getQuantity());
    }

    @Test (expected = CartItem.NotEnoughtStockForProduct.class)
    public void initialCartItemMustTestStockOfProduct()
    {
        Product product = new Product();
        product.addUnits(20);
        CartItem cartItem = new CartItem(product, 30);
    }

    @Test
    public void initialCartItemQuantityCannotBeZero()
    {

    }

    @Test
    public void initialCartItemQuantityCannotBeBelowZero()
    {

    }

    @Test
    public void productCanBeChangedInCartItem()
    {

    }

    @Test
    public void cartItemProductCanBeChanged()
    {

    }

    @Test
    public void productQuantityCanBeAddedToTheProduct()
    {
        Assert.assertEquals(10, cartItem.getQuantity());
    }

    @Test
    public void quantityCanBeAdded()
    {
        cartItem.addProduct(product, 10);
        cartItem.addQuantity(10);
        Assert.assertEquals(20, cartItem.getQuantity());
    }

    @Test
    public void quantityCanBeRemoved()
    {
        cartItem.addProduct(product, 10);
        cartItem.removeQuantity(4);
        Assert.assertEquals(6, cartItem.getQuantity());
    }

    @Test
    public void productQuantityCannotBeBelowZeroWhenQuantityIsAdded()
    {
        cartItem.addProduct(product, 10);
        cartItem.addQuantity(-8);
        Assert.assertEquals(10, cartItem.getQuantity());
    }

    @Test
    public void productQuantityCannotBeBelowZeroWhenQuantityIsRemoved()
    {
        cartItem.addProduct(product, 10);
        cartItem.removeQuantity(-5);
        Assert.assertEquals(10, cartItem.getQuantity());
    }

    @Test
    public void cartItemCannotHaveProductWithZeroQuantityWhenRemovingQuantity_productIsDeleted()
    {
        cartItem.addProduct(product, 10);
        cartItem.removeQuantity(10);
        Assert.assertNull(cartItem.getProduct());
    }

    @Test (expected = CartItem.NotEnoughtStockForProduct.class)
    public void cartItemTestsProductStockBeforeAddingProduct()
    {
        cartItem.addProduct(product, 25);
    }

    @Test (expected = CartItem.NotEnoughtStockForProduct.class)
    public void cartItemTestsProductStockBeforeAddingQuantity()
    {
        cartItem.addProduct(product, 10);
        cartItem.addQuantity(20);
    }

    @Test
    public void cartItemReturnsItsTotalPrice()
    {
        cartItem.addProduct(product, 15);
        product.setPrice(10.0);
        Assert.assertEquals(150.00, cartItem.getTotalPrice(), 0.001);
    }

    @Test
    public void cartItemMustReturnZeroAsItsTotalPriceWhenItHasNoProduct()
    {

    }



    //cartItemCanReturnProduct
    //cartItemCanReturnUnitsOfProduct
    //cartItemCanReturnItsTotalPrice
    //cartItemCanReturnItsNumberOfProductUnits

    // cartItemCanReturnNameOfProduct
    //cartItemCanSetNameOfProduct
    //cartItemCanSet...
}
