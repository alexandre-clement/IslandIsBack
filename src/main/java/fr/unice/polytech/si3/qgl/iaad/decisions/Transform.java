package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.format.json.JsonArguments;
import fr.unice.polytech.si3.qgl.iaad.resource.Contract;
import org.json.JSONObject;

import java.util.List;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
public class Transform extends Decision
{
    private final List<Contract> contracts;

    public Transform(List<Contract> contracts)
    {
        super(Actions.TRANSFORM);
        this.contracts = contracts;
    }

    @Override
    public JSONObject toJson()
    {
        JSONObject parameters = new JSONObject();
        for (Contract contract : contracts)
            parameters.put(contract.getResource().toString(), contract.getAmount());
        return new JSONObject()
                .put(JsonArguments.ACTION.toString(), getActions().toString())
                .put(JsonArguments.PARAMETERS.toString(), parameters);
    }
}
