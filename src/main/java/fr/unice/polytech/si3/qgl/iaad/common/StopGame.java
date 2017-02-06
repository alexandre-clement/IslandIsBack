package fr.unice.polytech.si3.qgl.iaad.common;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Stop;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Result;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class StopGame implements Protocol
{
    @Override
    public Decision takeDecision()
    {
        return new Stop();
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        return null;
    }
}
