package fr.unice.polytech.si3.qgl.iaad.common;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Heading;
import fr.unice.polytech.si3.qgl.iaad.decisions.Stop;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Board;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.utils.Drone;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Turn implements Protocol
{
    private final Protocol exit;
    private final Board board;
    private final Drone drone;
    private final Direction newHeading;

    public Turn(Protocol exit, Board board, Drone drone, Direction newHeading)
    {
        this.exit = exit;
        this.board = board;
        this.drone = drone;
        this.newHeading = newHeading;
    }

    @Override
    public Decision takeDecision()
    {
        drone.heading(newHeading);
        if (board.isOnBoard(drone.getLocation()))
            return new Heading(newHeading);
        return new Stop();
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        return exit;
    }
}
