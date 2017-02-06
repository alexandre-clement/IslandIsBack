package fr.unice.polytech.si3.qgl.iaad.format.json;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Format;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import org.json.JSONObject;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public class JsonFormat implements Format
{
    private JsonContext context;

    @Override
    public Context getContext()
    {
        return context;
    }

    @Override
    public void setContext(String jsonString)
    {
        context = new JsonContext(new JSONObject(jsonString));
    }

    @Override
    public Result stringToResult(String result)
    {
        return new JsonResult(new JSONObject(result));
    }

    @Override
    public String decisionToString(Decision decision)
    {
        return decision.toJson().toString();
    }
}
