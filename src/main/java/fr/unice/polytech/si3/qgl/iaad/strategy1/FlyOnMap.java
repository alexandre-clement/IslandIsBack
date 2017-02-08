package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Fly;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.IslandMap;

/**
 * @author Alexandre Clement
 * @since 07/02/2017.
 */
class FlyOnMap implements Protocol
{
    private final Protocol exit;
    private final IslandMap map;

    FlyOnMap(Protocol exit, IslandMap map)
    {
        this.exit = exit;
        this.map = map;
    }

    @Override
    public Decision takeDecision()
    {
        map.getDrone().fly();
        return new Fly();
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        return exit;
    }
}
