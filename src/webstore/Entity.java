package webstore;

/**
 * Created by I848075 on 09/07/2015.
 */
public class Entity
{
    protected String id;

    public Entity()
    {
        this.id = "";
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        id = id.trim();

        if (!this.id.equals(""))
        {
            throw new IllegalStateException();
        } else if (id.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        this.id = id;
    }

    public boolean hasId()
    {
        if (this.id.equals(""))
        {
            return false;
        } else
        {
            return true;
        }
    }
}
