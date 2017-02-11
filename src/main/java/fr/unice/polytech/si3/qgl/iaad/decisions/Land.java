package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.format.json.JsonArguments;
import fr.unice.polytech.si3.qgl.iaad.utils.Creek;
import org.json.JSONObject;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Land extends Decision
{
    private final Creek creek;
    private final int people;

    public Land(Creek creek, int people)
    {
        super(Actions.LAND);
        this.creek = creek;
        this.people = people;
    }

    @Override
    public JSONObject toJson()
    {
        JSONObject parameters = new JSONObject()
                .put(JsonArguments.CREEK.toString(), creek.getId())
                .put(JsonArguments.PEOPLE.toString(), people);
        return new JSONObject()
                .put(JsonArguments.ACTION.toString(), getActions().toString())
                .put(JsonArguments.PARAMETERS.toString(), parameters);
    }
}
