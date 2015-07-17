package webstore;

/**
 * Created by I848075 on 09/07/2015.
 */
public class Customer extends Entity
{

    private String name;
    private Cart   cart;

    public Customer() {
        super();
        this.name = "";
        this.cart = new Cart();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cart getCart()
    {
        return this.cart;
    }
}
