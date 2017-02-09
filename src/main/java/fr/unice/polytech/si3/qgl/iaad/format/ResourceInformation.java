package fr.unice.polytech.si3.qgl.iaad.format;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
public class ResourceInformation
{
    private final Resource resource;
    private final ResourceAmount resourceAmount;
    private final ResourceCondition resourceCondition;

    public ResourceInformation(Resource resource, ResourceAmount resourceAmount, ResourceCondition resourceCondition)
    {
        this.resource = resource;
        this.resourceAmount = resourceAmount;
        this.resourceCondition = resourceCondition;
    }

    public Resource getResource()
    {
        return resource;
    }

    public ResourceAmount getResourceAmount()
    {
        return resourceAmount;
    }

    public ResourceCondition getResourceCondition()
    {
        return resourceCondition;
    }

    public boolean isFair()
    {
        return resourceCondition == ResourceCondition.EASY || resourceCondition == ResourceCondition.FAIR;
    }

    public boolean isWorth()
    {
        return resourceAmount == ResourceAmount.HIGH || resourceAmount == ResourceAmount.MEDIUM;
    }
}
