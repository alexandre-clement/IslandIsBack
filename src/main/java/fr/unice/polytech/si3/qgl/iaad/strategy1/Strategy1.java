package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.common.StopGame;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Echo;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Found;
import fr.unice.polytech.si3.qgl.iaad.results.EchoResult;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Strategy1 implements Protocol
{
    private final Context context;

    public Strategy1(Context context)
    {
        this.context = context;
    }

    @Override
    public Decision takeDecision()
    {
        return new Echo(context.getHeading());
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        EchoResult echoResult = new EchoResult(result);
        context.getIslandMap().increase(context.getHeading(), result.getRange());
        if (echoResult.getFound() == Found.GROUND)
            return new StopGame();
        return new EchoToFindLimit(context, context.getHeading().getRight());
    }
}
