package fr.unice.polytech.si3.qgl.iaad.results;

import fr.unice.polytech.si3.qgl.iaad.format.Result;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
public class TransformResult
{
    private final int production;

    public TransformResult(Result result)
    {
        production = result.getProduction();
    }

    public int getProduction()
    {
        return production;
    }
}
