package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.common.StopGame;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Echo;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.map.Found;
import fr.unice.polytech.si3.qgl.iaad.map.IslandMap;
import fr.unice.polytech.si3.qgl.iaad.results.EchoResult;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Strategy1 implements Protocol
{
    private final IslandMap map;
    private final Direction heading;

    public Strategy1(Context context)
    {
        map = context.getIslandMap();
        heading = context.getHeading();
    }

    @Override
    public Decision takeDecision()
    {
        return new Echo(heading);
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        EchoResult echoResult = new EchoResult(result);
        map.increase(heading, echoResult.getRange());

        if (echoResult.getFound() == Found.GROUND)
            return new StopGame();
        return new EchoToFindLimit(map, heading.getRight());
    }
}
