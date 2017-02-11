package fr.unice.polytech.si3.qgl.iaad.craft;

import fr.unice.polytech.si3.qgl.iaad.resource.Resource;

import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
class SimpleReagent extends SimpleImmutableEntry<Resource, Integer> implements Reagent
{
    SimpleReagent(Resource resource, int amount)
    {
        super(resource, amount);
    }
}
