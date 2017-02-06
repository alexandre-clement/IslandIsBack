package fr.unice.polytech.si3.qgl.iaad.format.json;

import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public class JsonContextTest
{
    private JsonContext context;

    @Test
    public void getHeading() throws Exception
    {
        context = new JsonContext("{\"heading\": \"W\"}");
        assertEquals(Direction.WEST, context.getHeading());
    }

}