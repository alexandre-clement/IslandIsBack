package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.format.json.JsonArguments;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import org.json.JSONObject;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Heading extends Decision
{
    private final Direction newHeading;

    public Heading(Direction newHeading)
    {
        super(Actions.HEADING);
        this.newHeading = newHeading;
    }

    @Override
    public JSONObject toJson()
    {
        JSONObject parameters = new JSONObject().put(JsonArguments.DIRECTION.toString(), newHeading.toString());
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

        Heading heading = (Heading) o;

        return newHeading == heading.newHeading;
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + newHeading.hashCode();
        return result;
    }
}
