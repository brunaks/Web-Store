package webstore;

/**
 * Created by I848075 on 14/07/2015.
 */
public class CartItem
{
    private Product product;
    private int     units;

    public boolean isEmpty()
    {
        if (product != null)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public Product getProduct()
    {
        return this.product;
    }

    public int getUnits()
    {
        return this.units;
    }

    public void addProduct(Product product, int units)
    {
        if ((units > 0) && (product.hasInStock(units)))
        {
            this.units = units;
            this.product = product;
        }
        else if (!product.hasInStock(units))
        {
            throw new NotEnoughtStockForProduct();
        }
    }

    public void addUnits(int units)
    {
        if (product != null && units >= 0)
        {
            this.units += units;
        }
    }

    public void removeUnits(int units)
    {
        if (this.units <= units)
        {
            this.product = null;
        }
        else if (product != null && units >= 0)
        {
            this.units -= units;
        }
    }

    public class NotEnoughtStockForProduct extends RuntimeException
    {

    }
}
