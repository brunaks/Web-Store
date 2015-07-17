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
        return true;
    }

    public Product getProduct()
    {
        return this.product;
    }

    public int getUnits()
    {
        return this.units;
    }

    public void addProduct(String productName, int units)
    {
        if (units > 0)
        {
            this.product = new Product();
            product.setName(productName);
            this.units = units;
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
        if (product != null && units >= 0)
        {
            this.units -= units;
        }
    }
}
