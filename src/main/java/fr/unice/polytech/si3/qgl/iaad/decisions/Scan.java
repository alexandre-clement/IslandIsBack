package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.format.json.JsonArguments;
import org.json.JSONObject;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Scan extends Decision
{
    public Scan()
    {
        super(Actions.SCAN);
    }

    @Override
    public JSONObject toJson()
    {
        return new JSONObject().put(JsonArguments.ACTION.toString(), getActions().toString());
    }
}
