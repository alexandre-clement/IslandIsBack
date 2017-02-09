package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Explore;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.*;
import fr.unice.polytech.si3.qgl.iaad.map.GroundMap;
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

    ExploreTile(Protocol exit, Context context, GroundMap map)
    {
        this.exit = exit;
        this.context = context;
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

        for (ResourceInformation resourceInformation : exploreResult.getResourceInformation())
        {
            for (Contract contract : context.getContracts())
            {
                boolean equals = resourceInformation.getResource() == contract.getResource();
                boolean complete = contract.complete();
                boolean fair = resourceInformation.isFair();
                boolean worth = resourceInformation.isWorth();
                if (equals && !complete && fair && worth)
                    exit = new ExploitTile(exit, contract);
            }
        }
        return exit;
    }
}
