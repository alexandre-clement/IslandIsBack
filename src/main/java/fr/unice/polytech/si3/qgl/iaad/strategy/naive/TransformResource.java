package fr.unice.polytech.si3.qgl.iaad.strategy.naive;

import fr.unice.polytech.si3.qgl.iaad.contract.Contract;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Transform;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.results.TransformResult;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
class TransformResource implements Protocol
{
    private final Protocol exit;
    private final Contract contract;

    TransformResource(Protocol exit, Contract contract)
    {
        this.exit = exit;
        this.contract = contract;
    }

    @Override
    public Decision takeDecision()
    {
        return new Transform(contract.getCraft());
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        TransformResult transformResult = new TransformResult(result);
        contract.collected(transformResult.getProduction());
        return exit;
    }
}
