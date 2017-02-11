package fr.unice.polytech.si3.qgl.iaad.craft;

import fr.unice.polytech.si3.qgl.iaad.resource.Basket;
import fr.unice.polytech.si3.qgl.iaad.resource.Resource;

/**
 * @author Alexandre Clement
 * @since 11/02/2017.
 */
public interface Recipe
{
    Craft getCraftFor(Resource resource, int amount);

    Basket getRequiredResourcesFor(Resource resource, int amount);
}
