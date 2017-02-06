package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.format.json.JsonArguments;
import org.json.JSONObject;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public class Stop extends Decision
{
    public Stop()
    {
        super(Actions.STOP);
    }

    @Override
    public JSONObject toJson()
    {
        return new JSONObject().put(JsonArguments.ACTION.toString(), getActions().toString());
    }
}
