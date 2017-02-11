package fr.unice.polytech.si3.qgl.iaad.format.json;

import fr.unice.polytech.si3.qgl.iaad.contract.Contract;
import fr.unice.polytech.si3.qgl.iaad.contract.SimpleContract;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.map.Board;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.map.SimpleBoard;
import fr.unice.polytech.si3.qgl.iaad.resource.Resource;
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
    private final Board board;
    private final int men;
    private final List<Contract> contracts;

    JsonContext(JSONObject jsonObject)
    {
        heading = Direction.directionOf(jsonObject.get(JsonArguments.HEADING.toString()).toString());
        budget = jsonObject.getInt(JsonArguments.BUDGET.toString());
        board = new SimpleBoard();
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
            retrieves.add(new SimpleContract(resource, amount));
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
    public Board getBoard()
    {
        return board;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        JsonContext that = (JsonContext) o;

        boolean sameBudgetAndMen = budget == that.budget && men == that.men;
        boolean sameHeadingAndMap = heading == that.heading && board.equals(that.board);
        return sameBudgetAndMen && sameHeadingAndMap && contracts.equals(that.contracts);
    }

    @Override
    public int hashCode()
    {
        int result = budget;
        result = 31 * result + heading.hashCode();
        result = 31 * result + board.hashCode();
        result = 31 * result + men;
        result = 31 * result + contracts.hashCode();
        return result;
    }
}
