package fr.unice.polytech.si3.qgl.iaad.format.json;

import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import org.json.JSONObject;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
class JsonContext implements Context
{
    private final JSONObject jsonObject;
    private Direction heading;

    JsonContext(String jsonString)
    {
        jsonObject = new JSONObject(jsonString);
        heading = Direction.directionOf(jsonObject.get(JsonArguments.HEADING.toString()).toString());
    }

    @Override
    public Direction getHeading()
    {
        return heading;
    }
}
