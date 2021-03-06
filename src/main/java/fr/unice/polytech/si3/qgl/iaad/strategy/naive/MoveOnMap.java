package fr.unice.polytech.si3.qgl.iaad.strategy.naive;

import fr.unice.polytech.si3.qgl.iaad.common.StopGame;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.MoveTo;
import fr.unice.polytech.si3.qgl.iaad.decisions.Stop;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Board;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.utils.Crew;
import fr.unice.polytech.si3.qgl.iaad.vector.Vector;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
class MoveOnMap implements Protocol
{
    private final Context context;
    private final Board board;
    private final Crew crew;
    private final Direction direction;
    private final Direction sense;

    MoveOnMap(Context context, Board board, Crew crew, Direction direction)
    {
        this(context, board, crew, direction, direction.getLeft());
    }

    private MoveOnMap(Context context, Board board, Crew crew, Direction direction, Direction sense)
    {
        this.context = context;
        this.board = board;
        this.crew = crew;
        this.direction = direction;
        this.sense = sense;
    }

    @Override
    public Decision takeDecision()
    {
        crew.moveTo(direction);
        if (board.isOnBoard(crew.getLocation()))
            return new MoveTo(direction);
        return new Stop();
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        board.getTile(crew.getLocation()).visit();
        Protocol exit;

        if (canMoveInDirection(sense))
            exit = new MoveOnMap(context, board, crew, sense, direction.getBack());
        else if (canMoveInDirection(direction))
            exit = new MoveOnMap(context, board, crew, direction, sense);
        else if (canMoveInDirection(sense.getBack()))
            exit = new MoveOnMap(context, board, crew, sense.getBack(), direction.getBack());
        else
            exit = new StopGame();

        return new ExploreTile(exit, context, board, crew);
    }

    private boolean canMoveInDirection(Direction direction)
    {
        Vector location = crew.getLocation().add(direction.getUnitaryVector());
        return board.isOnBoard(location) && !board.getTile(location).isAlreadyVisited();
    }
}
