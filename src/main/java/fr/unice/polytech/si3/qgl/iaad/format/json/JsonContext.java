package fr.unice.polytech.si3.qgl.iaad.format.json;

import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.map.Drone;
import fr.unice.polytech.si3.qgl.iaad.map.IslandMap;
import org.json.JSONObject;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
class JsonContext implements Context
{
    private final int budget;
    private final Direction heading;
    private final IslandMap islandMap;

    JsonContext(JSONObject jsonObject)
    {
        heading = Direction.directionOf(jsonObject.get(JsonArguments.HEADING.toString()).toString());
        budget = jsonObject.getInt(JsonArguments.BUDGET.toString());
        islandMap = new IslandMap(new Drone(heading));
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
    public IslandMap getIslandMap()
    {
        return islandMap;
    }
}
