package fr.unice.polytech.si3.qgl.iaad.results;

import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.resource.Found;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class EchoResult
{
    private final Integer range;
    private final Found found;

    public EchoResult(Result result)
    {
        this.range = result.getRange();
        this.found = result.getFound();
    }

    public Found getFound()
    {
        return found;
    }

    public Integer getRange()
    {
        return range;
    }
}
