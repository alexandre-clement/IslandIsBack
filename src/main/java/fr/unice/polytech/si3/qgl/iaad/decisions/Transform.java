package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.craft.Craft;
import fr.unice.polytech.si3.qgl.iaad.format.json.JsonArguments;
import fr.unice.polytech.si3.qgl.iaad.resource.Resource;
import org.json.JSONObject;

import java.util.Map;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
public class Transform extends Decision
{
    private final Craft craft;

    public Transform(Craft craft)
    {
        super(Actions.TRANSFORM);
        this.craft = craft;
    }

    @Override
    public JSONObject toJson()
    {
        JSONObject parameters = new JSONObject();
        for (Map.Entry<Resource, Integer> entry : craft.getReagent())
        {
            parameters.put(entry.getKey().toString(), entry.getValue());
        }
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

        Transform transform = (Transform) o;

        return craft.equals(transform.craft);
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + craft.hashCode();
        return result;
    }
}
