package webstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by I848075 on 09/07/2015.
 */
public class CartTest {
    public Cart cart;
    public Product product;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
        product = new Product();
    }

    @Test
    public void newCartIsEmpty() {
        Assert.assertTrue(cart.isEmpty());
    }

    @Test
    public void newCartHasTotalPriceOfZero() {
        Assert.assertEquals(0, cart.getTotalPrice(), 0.001);
    }


    @Test
    public void itemCanBeAddedToTheCart() {
        product.setName("Banana Caturra");
        product.addUnits(20);
        cart.addItem(product, 10);
        Assert.assertEquals("Banana Caturra", cart.getCartItems().get(0).getProduct().getName());
        Assert.assertEquals(10, cart.getCartItems().get(0).getQuantity());

    }

    @Test
    public void itemsCanBeAddedToTheCart()
    {
        Product product2 = new Product();
        product.setName("Banana Caturra");
        product.addUnits(20);
        product2.setName("Banana Prata");
        product2.addUnits(20);
        cart.addItem(product, 10);
        cart.addItem(product2, 10);
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(product);
        products.add(product2);
        Assert.assertEquals(products.get(0).getName(), cart.getCartItems().get(0).getProduct().getName());
        Assert.assertEquals(products.get(1).getName(), cart.getCartItems().get(1).getProduct().getName());
    }

    @Test
    public void cartMustReturnProductAndQuantity()
    {
        product.setName("Banana");
        product.setPrice(15.00);
        product.addUnits(15);
        cart.addItem(product, 10);
        Assert.assertEquals("Banana", cart.getCartItems().get(0).getProduct().getName());
        Assert.assertEquals(10, cart.getCartItems().get(0).getQuantity());
    }

    @Test
    public void productQuantityCanBeRemovedFromTheCart() {

    }


    //noRepeatedProducts
    //productIsAddedToCartItem
    //cartCanReturnUnitsOfAProduct *
    //cartCanReturnItsListOfProducts
    //productCanBeRemovedFromTheCart
    //cartCanBeEmptied
    //mustCheckIfThereIsEnoughStockWhenAProductIsAddedToTheCart
    //removingProductsThatAreNotInTheCartMustNotThrowException
    //cartIsNoLongerEmptyIfTheCartHasAnyAmountOfProductUnits
    //cartCannotHaveNegativeAmountOfProductUnits
    //cartCannotHaveZeroAmountOfProductUnits
    //cartIsEmptyIfAllProductsWereRemoved
    //cartCanReturnItsTotalPrice


}
