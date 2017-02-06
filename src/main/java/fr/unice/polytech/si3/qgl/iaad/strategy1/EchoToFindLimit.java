package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.common.StopGame;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Echo;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.results.EchoResult;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
class EchoToFindLimit implements Protocol
{
    private final Context context;
    private final Direction direction;

    EchoToFindLimit(Context context, Direction direction)
    {
        this.context = context;
        this.direction = direction;
    }

    @Override
    public Decision takeDecision()
    {
        return new Echo(direction);
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        EchoResult echoResult = new EchoResult(result);
        context.getIslandMap().increase(direction, echoResult.getRange());
        if (context.getHeading().getRight() == direction)
            return new EchoToFindLimit(context, direction.getBack());
        boolean keepDirection = context.getIslandMap().getRange(direction) > context.getIslandMap().getRange(direction.getBack());
        return new Turn(new StopGame(), keepDirection ? direction : direction.getBack());
    }
}
