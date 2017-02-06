package fr.unice.polytech.si3.qgl.iaad.aerial;

import fr.unice.polytech.si3.qgl.iaad.common.StopGame;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Echo;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.map.Found;
import fr.unice.polytech.si3.qgl.iaad.results.EchoResult;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public class Initialisation extends Aerial
{
    public Initialisation(Context context)
    {
        super(context);
    }

    @Override
    public Decision takeDecision()
    {
        return new Echo(getContext().getHeading());
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        EchoResult echoResult = new EchoResult(result);
        if (echoResult.getFound() == Found.OUT_OF_RANGE)
            return new StopGame();
        if (echoResult.getRange() == 0)
            return new StopGame();
        return new StopGame();
    }
}
