package fr.unice.polytech.si3.qgl.iaad.strategy.naive;

import fr.unice.polytech.si3.qgl.iaad.common.Turn;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Echo;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Board;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.results.EchoResult;
import fr.unice.polytech.si3.qgl.iaad.utils.Drone;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
class EchoToFindLimit implements Protocol
{
    private final Context context;
    private final Board board;
    private final Drone drone;
    private final Direction direction;

    EchoToFindLimit(Context context, Board board, Drone drone, Direction direction)
    {
        this.context = context;
        this.board = board;
        this.drone = drone;
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
        Direction heading = drone.getHeading();

        board.increase(direction, echoResult.getRange());

        if (heading.getRight() == direction)
            return new EchoToFindLimit(context, board, drone, direction.getBack());

        boolean keepDirection = board.getRange(direction, drone.getLocation()) > board.getRange(direction.getBack(), drone.getLocation());
        Direction newHeading = keepDirection ? direction : direction.getBack();
        return new Turn(new ScanMap(context, board, drone, heading), board, drone, newHeading);
    }
}
