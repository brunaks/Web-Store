package webstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by I848075 on 14/07/2015.
 */
public class CartItemTest {

    public CartItem cartItem;
    public Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product();
        product.addUnits(20);
        cartItem = new CartItem(product, 10);
    }

    @Test
    public void initialCartItemMustHaveAProduct() {
        Assert.assertNotNull(cartItem.getProduct());
    }

    @Test
    public void initialCartItemMustHaveAQuantity() {
        Assert.assertEquals(10, cartItem.getQuantity());
    }

    @Test(expected = CartItem.NotEnoughtStockForProduct.class)
    public void initialCartItemMustTestStockOfProduct() {
        Product product = new Product();
        product.addUnits(20);
        CartItem cartItem = new CartItem(product, 30);
    }

    @Test(expected = CartItem.quantityShouldBeGreaterThanZero.class)
    public void initialCartItemQuantityCannotBeZero() {
        Product product = new Product();
        product.addUnits(20);
        CartItem cartItem = new CartItem(product, 0);
    }

    @Test (expected = CartItem.quantityShouldBeGreaterThanZero.class)
    public void initialCartItemQuantityCannotBeBelowZero() {
        Product product = new Product();
        product.addUnits(20);
        CartItem cartItem = new CartItem(product, -10);
    }

    @Test
    public void productQuantityCanBeAddedToTheProduct() {
        Assert.assertEquals(10, cartItem.getQuantity());
    }

    @Test
    public void quantityCanBeAdded() {
        cartItem.addQuantity(10);
        Assert.assertEquals(20, cartItem.getQuantity());
    }

    @Test
    public void quantityCanBeRemoved() {
        cartItem.removeQuantity(4);
        Assert.assertEquals(6, cartItem.getQuantity());
    }

    @Test
    public void productQuantityCannotBeBelowZeroWhenQuantityIsAdded() {
        cartItem.addQuantity(-8);
        Assert.assertEquals(10, cartItem.getQuantity());
    }

    @Test
    public void productQuantityCannotBeBelowZeroWhenQuantityIsRemoved() {
        cartItem.removeQuantity(-5);
        Assert.assertEquals(10, cartItem.getQuantity());
    }

    @Test
    public void cartItemCannotHaveProductWithZeroQuantityWhenRemovingQuantity_productIsDeleted() {
        cartItem.removeQuantity(10);
        Assert.assertNull(cartItem.getProduct());
    }

    @Test(expected = CartItem.NotEnoughtStockForProduct.class)
    public void cartItemTestsProductStockBeforeAddingQuantity() {
        cartItem.addQuantity(10);
        cartItem.addQuantity(20);
    }

    @Test
    public void cartItemReturnsItsTotalPrice() {
        product.setPrice(15.0);
        Assert.assertEquals(150.00, cartItem.getTotalPrice(), 0.001);
    }

    @Test
    public void cartItemCanReturnQuantity()
    {
        Assert.assertEquals(10, cartItem.getQuantity());
    }

}
