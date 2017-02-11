package fr.unice.polytech.si3.qgl.iaad.craft;

import fr.unice.polytech.si3.qgl.iaad.resource.Resource;

import java.util.AbstractMap;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
class SimpleProduct extends AbstractMap.SimpleImmutableEntry<Resource, Integer> implements Product
{
    SimpleProduct(Resource resource, int amount)
    {
        super(resource, amount);
    }
}
