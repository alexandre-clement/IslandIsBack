package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.common.LandOnIsland;
import fr.unice.polytech.si3.qgl.iaad.common.StopGame;
import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Scan;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.map.IslandMap;
import fr.unice.polytech.si3.qgl.iaad.results.ScanResult;

/**
 * @author Alexandre Clement
 * @since 07/02/2017.
 */
class ScanMap implements Protocol
{
    private final IslandMap map;
    private final Direction direction;

    ScanMap(IslandMap map, Direction direction)
    {
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
        map.addBiomes(scanResult.getBiomes());
        map.addCreeks(scanResult.getCreeks());
        map.addSites(scanResult.getSites());

        if (!map.getCreeks().isEmpty())
            return new LandOnIsland(new StopGame(), map.getCreeks().get(0), 1);

        if (map.getRange(heading) > 1)
            return new FlyOnMap(this, map);

        if (map.getRange(direction) > 1)
            return new Turn(new Turn(this, map, heading.getBack()), map, direction);

        Protocol exit = new ScanMap(map, direction.getBack());
        exit = new Turn(exit, map, heading.getBack());
        exit = new FlyOnMap(exit, map);
        return new Turn(exit, map, direction.getBack());


    }
}
