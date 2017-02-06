package fr.unice.polytech.si3.qgl.iaad.format.json;

import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public class JsonContextTest
{
    private JsonContext jsonContext;

    @Before
    public void setUp() throws Exception
    {
        jsonContext = new JsonContext(new JSONObject().put("budget", 100).put("heading", "E"));
    }

    @Test
    public void getBudget() throws Exception
    {
        assertEquals(100, jsonContext.getBudget());
    }

    @Test
    public void getHeading() throws Exception
    {
        assertEquals(Direction.EAST, jsonContext.getHeading());
    }
}