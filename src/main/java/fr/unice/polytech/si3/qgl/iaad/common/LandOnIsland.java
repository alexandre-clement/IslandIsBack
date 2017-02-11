package fr.unice.polytech.si3.qgl.iaad.common;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Land;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.utils.Creek;
import fr.unice.polytech.si3.qgl.iaad.utils.Crew;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class LandOnIsland implements Protocol
{
    private final Protocol exit;
    private final Creek creek;
    private final Crew crew;

    public LandOnIsland(Protocol exit, Creek creek, Crew crew)
    {
        this.exit = exit;
        this.creek = creek;
        this.crew = crew;
    }

    @Override
    public Decision takeDecision()
    {
        return new Land(creek, crew.getPeople());
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        return exit;
    }
}
