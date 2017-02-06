package fr.unice.polytech.si3.qgl.iaad.results;

import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Found;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class EchoResult
{
    private final Integer cost;
    private final Integer range;
    private final Found found;
    
    public EchoResult(Result result)
    {
        this.cost = result.getCost();
        this.range = result.getRange();
        this.found = result.getFound();
    }

    public int getCost()
    {
        return cost;
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
