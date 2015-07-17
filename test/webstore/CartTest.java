package webstore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by I848075 on 09/07/2015.
 */
public class CartTest
{
    public Cart cart;

    @Before
    public void setUp() throws Exception
    {
        cart = new Cart();
    }

    @Test
    public void newCartIsEmpty()
    {
        Assert.assertTrue(cart.isEmpty());
    }

    @Test
    public void newCartHasTotalPriceOfZero()
    {
        Assert.assertEquals(0, cart.getTotalPrice(), 0.001);
    }

    @Test
    public void cartCanReturnUnitsOfAProduct()
    {
        Product banana = new Product();
        banana.addUnits(10);
        Assert.assertEquals(10, cart.getUnitsOfProduct("Banana"));
    }

    @Test
    public void productCanBeAddedToTheCart()
    {
        cart.addProduct("Banana Caturra", 10);
        cart.getUnitsOfProduct("Banana");
    }

    @Test
    public void productUnitsCanBeRemovedFromTheCart()
    {

    }


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
