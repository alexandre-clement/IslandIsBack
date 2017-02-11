package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.format.json.JsonArguments;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import org.json.JSONObject;

/**
 * @author Alexandre Clement
 * @since 11/02/2017.
 */
abstract class Directed extends Decision
{
    private final Direction direction;

    Directed(Actions actions, Direction direction)
    {
        super(actions);
        this.direction = direction;
    }

    public Direction getDirection()
    {
        return direction;
    }

    @Override
    public JSONObject toJson()
    {
        JSONObject parameters = new JSONObject().put(JsonArguments.DIRECTION.toString(), direction.toString());
        return new JSONObject()
                .put(JsonArguments.ACTION.toString(), getActions().toString())
                .put(JsonArguments.PARAMETERS.toString(), parameters);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        Directed directed = (Directed) o;

        return direction == directed.direction;
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + direction.hashCode();
        return result;
    }
}
