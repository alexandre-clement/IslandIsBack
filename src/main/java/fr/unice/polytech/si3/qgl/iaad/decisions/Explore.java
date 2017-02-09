package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.format.json.JsonArguments;
import org.json.JSONObject;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
public class Explore extends Decision
{
    public Explore()
    {
        super(Actions.EXPLORE);
    }

    @Override
    public JSONObject toJson()
    {
        return new JSONObject().put(JsonArguments.ACTION.toString(), getActions().toString());
    }
}
