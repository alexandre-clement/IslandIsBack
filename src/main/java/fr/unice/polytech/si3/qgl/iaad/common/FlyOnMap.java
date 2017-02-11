package fr.unice.polytech.si3.qgl.iaad.common;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Fly;
import fr.unice.polytech.si3.qgl.iaad.decisions.Stop;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Board;
import fr.unice.polytech.si3.qgl.iaad.utils.Drone;

/**
 * @author Alexandre Clement
 * @since 07/02/2017.
 */
public class FlyOnMap implements Protocol
{
    private final Protocol exit;
    private final Board board;
    private final Drone drone;

    public FlyOnMap(Protocol exit, Board board, Drone drone)
    {
        this.exit = exit;
        this.board = board;
        this.drone = drone;
    }

    @Override
    public Decision takeDecision()
    {
        drone.fly();
        if (board.isOnBoard(drone.getLocation()))
            return new Fly();
        return new Stop();
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        return exit;
    }
}
