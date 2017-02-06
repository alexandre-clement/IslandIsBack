package fr.unice.polytech.si3.qgl.iaad.engine;

import fr.unice.polytech.si3.qgl.iaad.common.StopGame;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.strategy1.Strategy1;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public class Engine
{
    private static final int MINIMAL_BUDGET = 200;
    private static final String REPORT = "We're gonna be rich !";
    private Protocol protocol;
    private int budget;

    public Engine(Context context)
    {
        this.protocol = new Strategy1(context);
        this.budget = context.getBudget();
    }

    public Decision takeDecision()
    {
        return protocol.takeDecision();
    }

    public void acknowledgeResults(Result result)
    {
        budget -= result.getCost();

        if (budget > MINIMAL_BUDGET)
            protocol = protocol.acknowledgeResults(result);
        else
            protocol = new StopGame();
    }

    public String deliverFinalReport()
    {
        return REPORT;
    }
}
