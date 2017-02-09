package fr.unice.polytech.si3.qgl.iaad.common;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Land;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.resource.Creek;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.IslandMap;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class LandOnIsland implements Protocol
{
    private final Protocol exit;
    private final IslandMap map;
    private final Creek creek;
    private final int people;

    public LandOnIsland(Protocol exit, IslandMap map, Creek creek, int people)
    {
        this.exit = exit;
        this.map = map;
        this.creek = creek;
        this.people = people;
    }

    @Override
    public Decision takeDecision()
    {
        map.land(creek);
        return new Land(creek, people);
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        return exit;
    }
}
