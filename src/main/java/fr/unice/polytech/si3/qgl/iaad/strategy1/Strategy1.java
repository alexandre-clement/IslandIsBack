package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.common.StopGame;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Echo;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Board;
import fr.unice.polytech.si3.qgl.iaad.resource.Found;
import fr.unice.polytech.si3.qgl.iaad.results.EchoResult;
import fr.unice.polytech.si3.qgl.iaad.utils.Drone;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Strategy1 implements Protocol
{
    private final Context context;
    private final Board board;
    private final Drone drone;

    public Strategy1(Context context)
    {
        this.context = context;
        board = context.getBoard();
        drone = new Drone(context.getHeading());
    }

    @Override
    public Decision takeDecision()
    {
        return new Echo(drone.getHeading());
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        EchoResult echoResult = new EchoResult(result);
        board.increase(drone.getHeading(), echoResult.getRange());

        if (echoResult.getFound() == Found.GROUND)
            return new StopGame();
        return new EchoToFindLimit(context, board, drone, drone.getHeading().getRight());
    }
}
