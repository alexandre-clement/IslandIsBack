package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.common.FlyOnMap;
import fr.unice.polytech.si3.qgl.iaad.common.LandOnIsland;
import fr.unice.polytech.si3.qgl.iaad.common.Turn;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Scan;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Board;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.map.SimpleBoard;
import fr.unice.polytech.si3.qgl.iaad.map.Tile;
import fr.unice.polytech.si3.qgl.iaad.results.ScanResult;
import fr.unice.polytech.si3.qgl.iaad.utils.Crew;
import fr.unice.polytech.si3.qgl.iaad.utils.Drone;
import fr.unice.polytech.si3.qgl.iaad.vector.Rectangle;
import fr.unice.polytech.si3.qgl.iaad.vector.SimpleRectangle;
import fr.unice.polytech.si3.qgl.iaad.vector.SimpleVector;
import fr.unice.polytech.si3.qgl.iaad.vector.Vector;

/**
 * @author Alexandre Clement
 * @since 07/02/2017.
 */
class ScanMap implements Protocol
{
    private static final int CREW = 1;
    private static final Rectangle boxesInTile = new SimpleRectangle(3, 3, 3, 3);
    private static final Vector ratio = new SimpleVector(3, 3);
    private final Context context;
    private final Board board;
    private final Drone drone;
    private final Direction direction;

    ScanMap(Context context, Board board, Drone drone, Direction direction)
    {
        this.context = context;
        this.board = board;
        this.drone = drone;
        this.direction = direction;
    }

    @Override
    public Decision takeDecision()
    {
        return new Scan();
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        ScanResult scanResult = new ScanResult(result);
        Direction heading = drone.getHeading();

        Tile tile = board.getTile(drone.getLocation());
        tile.visit();
        tile.addBiomes(scanResult.getBiomes());
        tile.addCreeks(scanResult.getCreeks());
        tile.addSites(scanResult.getSites());


        if (!tile.getCreeks().isEmpty())
        {
            Board groundBoard = new SimpleBoard(board.getDimensions().mul(boxesInTile));
            Protocol exit = new MoveOnMap(context, groundBoard, new Crew(drone.getLocation().mul(ratio), CREW), direction);
            return new LandOnIsland(exit, tile.getCreeks().get(0), CREW);
        }

        if (board.getRange(heading, drone.getLocation()) > 1)
            return new FlyOnMap(this, board, drone);

        if (board.getRange(direction, drone.getLocation()) > 1)
            return new Turn(new Turn(this, board, drone, heading.getBack()), board, drone, direction);

        Protocol exit = new ScanMap(context, board, drone, direction.getBack());
        exit = new Turn(exit, board, drone, heading.getBack());
        exit = new FlyOnMap(exit, board, drone);
        return new Turn(exit, board, drone, direction.getBack());
    }
}
