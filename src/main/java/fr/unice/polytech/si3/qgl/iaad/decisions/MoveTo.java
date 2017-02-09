package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.format.json.JsonArguments;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import org.json.JSONObject;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
public class MoveTo extends Decision
{
    private final Direction direction;

    public MoveTo(Direction direction)
    {
        super(Actions.MOVE_TO);
        this.direction = direction;
    }

    @Override
    public JSONObject toJson()
    {
        JSONObject parameters = new JSONObject().put(JsonArguments.DIRECTION.toString(), direction.toString());
        return new JSONObject()
                .put(JsonArguments.ACTION.toString(), getActions().toString())
                .put(JsonArguments.PARAMETERS.toString(), parameters);
    }
}
