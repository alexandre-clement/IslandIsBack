package fr.unice.polytech.si3.qgl.iaad.engine;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.aerial.Initialisation;
import fr.unice.polytech.si3.qgl.iaad.format.Context;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public class Engine
{
    private Protocol protocol;

    public Engine(Context context)
    {
        this.protocol = new Initialisation(context);
    }

    public Decision takeDecision()
    {
        return protocol.takeDecision();
    }

    public void acknowledgeResults(Result result)
    {
        protocol = protocol.acknowledgeResults(result);
    }

    public String deliverFinalReport()
    {
        return null;
    }
}
