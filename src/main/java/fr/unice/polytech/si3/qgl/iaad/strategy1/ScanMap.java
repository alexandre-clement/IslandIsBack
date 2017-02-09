package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.common.LandOnIsland;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Scan;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.map.AerialMap;
import fr.unice.polytech.si3.qgl.iaad.map.GroundMap;
import fr.unice.polytech.si3.qgl.iaad.results.ScanResult;

/**
 * @author Alexandre Clement
 * @since 07/02/2017.
 */
class ScanMap implements Protocol
{
    private final Context context;
    private final AerialMap map;
    private final Direction direction;

    ScanMap(Context context, AerialMap map, Direction direction)
    {
        this.context = context;
        this.map = map;
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
        Direction heading = map.getDrone().getHeading();
        map.visitCurrentTile(scanResult.getBiomes(), scanResult.getCreeks(), scanResult.getSites());

        if (!map.getCreeks().isEmpty())
            return new LandOnIsland(new MoveOnMap(context, new GroundMap(map), direction), map, map.getCreeks().get(0), 1);

        if (map.getRange(heading) > 1)
            return new FlyOnMap(this, map);

        if (map.getRange(direction) > 1)
            return new Turn(new Turn(this, map, heading.getBack()), map, direction);

        Protocol exit = new ScanMap(context, map, direction.getBack());
        exit = new Turn(exit, map, heading.getBack());
        exit = new FlyOnMap(exit, map);
        return new Turn(exit, map, direction.getBack());
    }
}
