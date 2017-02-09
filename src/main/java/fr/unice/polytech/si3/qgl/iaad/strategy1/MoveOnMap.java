package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.common.StopGame;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.MoveTo;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.map.GroundMap;
import fr.unice.polytech.si3.qgl.iaad.map.Tile;

import java.util.Optional;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
class MoveOnMap implements Protocol
{
    private final Context context;
    private final GroundMap map;
    private final Direction direction;

    MoveOnMap(Context context, GroundMap map, Direction direction)
    {
        this.context = context;
        this.map = map;
        this.direction = direction;
    }

    @Override
    public Decision takeDecision()
    {
        map.getCrew().moveTo(direction);
        return new MoveTo(direction);
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        map.visitCurrentTile();
        Protocol exit;
        Optional<Tile> left = map.getNextTile(direction.getLeft());
        if (left.isPresent() && !left.get().isAlreadyVisited())
            exit = new MoveOnMap(context, map, direction.getLeft());
        else
            exit = map.getNextTile(direction).map(tile -> (Protocol) this).orElseGet(StopGame::new);

        return new ExploreTile(exit, context, map);
    }
}
