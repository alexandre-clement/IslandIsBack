package fr.unice.polytech.si3.qgl.iaad.common;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Land;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.utils.Creek;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class LandOnIsland implements Protocol
{
    private final Protocol exit;
    private final Creek creek;
    private final int people;

    public LandOnIsland(Protocol exit, Creek creek, int people)
    {
        this.exit = exit;
        this.creek = creek;
        this.people = people;
    }

    @Override
    public Decision takeDecision()
    {
        return new Land(creek, people);
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        return exit;
    }
}
