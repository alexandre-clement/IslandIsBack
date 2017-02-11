package fr.unice.polytech.si3.qgl.iaad.results;

import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.resource.ResourceInformation;

import java.util.List;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
public class ExploreResult
{
    private final List<ResourceInformation> resourceInformation;

    public ExploreResult(Result result)
    {
        resourceInformation = result.getResources();
    }

    public List<ResourceInformation> getResourceInformation()
    {
        return resourceInformation;
    }
}
