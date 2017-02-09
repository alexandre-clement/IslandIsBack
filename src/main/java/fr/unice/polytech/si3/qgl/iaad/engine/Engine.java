package fr.unice.polytech.si3.qgl.iaad.engine;

import fr.unice.polytech.si3.qgl.iaad.common.StopGame;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.resource.Contract;
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
    private final Context context;

    public Engine(Context context)
    {
        this.protocol = new Strategy1(context);
        this.budget = context.getBudget();
        this.context = context;
    }

    public Decision takeDecision()
    {
        checkIfContractIsCompleted();
        return protocol.takeDecision();
    }

    private void checkIfContractIsCompleted()
    {
        if (context.getContracts().stream().allMatch(Contract::complete))
            protocol = new StopGame();
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
