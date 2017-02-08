package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Heading;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.map.IslandMap;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
class Turn implements Protocol
{
    private final Protocol exit;
    private final IslandMap map;
    private final Direction newHeading;

    Turn(Protocol exit, IslandMap map, Direction newHeading)
    {
        this.exit = exit;
        this.map = map;
        this.newHeading = newHeading;
    }

    @Override
    public Decision takeDecision()
    {
        map.getDrone().heading(newHeading);
        return new Heading(newHeading);
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        return exit;
    }
}
