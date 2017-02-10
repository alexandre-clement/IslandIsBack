package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Explore;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.GroundMap;
import fr.unice.polytech.si3.qgl.iaad.resource.Basket;
import fr.unice.polytech.si3.qgl.iaad.resource.Contract;
import fr.unice.polytech.si3.qgl.iaad.resource.ResourceInformation;
import fr.unice.polytech.si3.qgl.iaad.results.ExploreResult;


/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
class ExploreTile implements Protocol
{
    private Protocol exit;
    private final Context context;
    private final GroundMap map;

    ExploreTile(Protocol exit, Context context, GroundMap map)
    {
        this.exit = exit;
        this.context = context;
        this.map = map;
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
        Basket objective = new Basket();
        context.getContracts().stream().map(Contract::getBasket).forEach(objective::addAll);

        for (ResourceInformation resourceInformation : exploreResult.getResourceInformation())
        {
            boolean equals = objective.contains(resourceInformation.getResource());
            boolean fair = resourceInformation.isFair();
            boolean worth = resourceInformation.isWorth();
            if (equals && fair && worth)
                exit = new ExploitTile(exit, context, map, resourceInformation.getResource());
        }
        return exit;
    }
}
