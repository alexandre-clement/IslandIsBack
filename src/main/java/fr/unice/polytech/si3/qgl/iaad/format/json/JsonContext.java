package fr.unice.polytech.si3.qgl.iaad.format.json;

import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.resource.Contract;
import fr.unice.polytech.si3.qgl.iaad.resource.Resource;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.map.Drone;
import fr.unice.polytech.si3.qgl.iaad.map.AerialMap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
class JsonContext implements Context
{
    private final int budget;
    private final Direction heading;
    private final AerialMap islandMap;
    private final int men;
    private final List<Contract> contracts;

    JsonContext(JSONObject jsonObject)
    {
        heading = Direction.directionOf(jsonObject.get(JsonArguments.HEADING.toString()).toString());
        budget = jsonObject.getInt(JsonArguments.BUDGET.toString());
        islandMap = new AerialMap(new Drone(heading));
        men = jsonObject.getInt(JsonArguments.MEN.toString());
        contracts = retrievesContracts(jsonObject);
    }

    private List<Contract> retrievesContracts(JSONObject jsonObject)
    {
        List<Contract> retrieves = new ArrayList<>();
        JSONArray contractsArray = jsonObject.getJSONArray(JsonArguments.CONTRACTS.toString());
        for (int i = 0; i < contractsArray.length(); i++)
        {
            JSONObject contract = contractsArray.getJSONObject(i);
            Resource resource = Resource.valueOf(contract.get(JsonArguments.RESOURCE.toString()).toString());
            int amount = contract.getInt(JsonArguments.AMOUNT.toString());
            retrieves.add(new Contract(resource, amount));
        }
        return retrieves;
    }

    @Override
    public Direction getHeading()
    {
        return heading;
    }

    @Override
    public int getBudget()
    {
        return budget;
    }

    @Override
    public AerialMap getIslandMap()
    {
        return islandMap;
    }

    @Override
    public int getMen()
    {
        return men;
    }

    @Override
    public List<Contract> getContracts()
    {
        return contracts;
    }
}
