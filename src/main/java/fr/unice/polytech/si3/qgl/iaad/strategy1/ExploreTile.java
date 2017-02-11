package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.contract.Contract;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Explore;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Board;
import fr.unice.polytech.si3.qgl.iaad.resource.Basket;
import fr.unice.polytech.si3.qgl.iaad.resource.ResourceInformation;
import fr.unice.polytech.si3.qgl.iaad.resource.SimpleBasket;
import fr.unice.polytech.si3.qgl.iaad.results.ExploreResult;
import fr.unice.polytech.si3.qgl.iaad.utils.Crew;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
class ExploreTile implements Protocol
{
    private final Context context;
    private final Board board;
    private final Crew crew;
    private Protocol exit;

    ExploreTile(Protocol exit, Context context, Board board, Crew crew)
    {
        this.exit = exit;
        this.context = context;
        this.board = board;
        this.crew = crew;
    }

    @Override
    public Decision takeDecision()
    {
        return new Explore();
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        ExploreResult exploreResult = new ExploreResult(result);
        List<Basket> contracts = context.getContracts().stream().filter(contract -> !contract.isComplete()).map(Contract::getReagentResources).collect(Collectors.toList());
        Basket objective = new SimpleBasket();
        objective.addAll(contracts);

        for (ResourceInformation resourceInformation : exploreResult.getResourceInformation())
        {
            boolean isInAContract = objective.contains(resourceInformation.getResource());
            boolean isUseful = objective.count(resourceInformation.getResource()) > crew.getBasket().count(resourceInformation.getResource());
            boolean fair = resourceInformation.isFair();
            boolean worth = resourceInformation.isWorth();
            if (isInAContract && isUseful && fair && worth)
                exit = new ExploitTile(exit, context, board, crew, resourceInformation.getResource());
        }
        return exit;
    }
}
