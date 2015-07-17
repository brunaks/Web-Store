package webstore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by I848075 on 09/07/2015.
 */
public abstract class EntityTest
{
    private Entity entity;

    @Before
    public void setUp() throws Exception
    {
        entity = getEntity();
    }

    @Test
    public void customerCanTellIfTheyHaveAnId()
    {
        assertFalse(entity.hasId());
        entity.setId("0000");
        assertTrue(entity.hasId());
    }

    protected abstract Entity getEntity();

    @Test
    public void initialIdIsBlank()
    {
        String id = entity.getId();
        assertEquals("", id);
    }

    @Test
    public void idCanBeChanged()
    {
        entity.setId("00000000000");
        String id = entity.getId();
        assertEquals("00000000000", id);
    }

    @Test(expected = IllegalStateException.class)
    public void idCanBeChangedOnlyOnce()
    {
        entity.setId("00000000000");
        entity.setId("11111111111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void idCannotBeChangedToBlank()
    {
        entity.setId("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void idCannotBeChangedToOnlySpaces()
    {
        entity.setId("    ");
    }

    @Test
    public void spacesSurroundingIdAreIgnored()
    {
        entity.setId(" 00 ");
        assertEquals("00", entity.getId());
    }
}
