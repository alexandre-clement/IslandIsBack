package fr.unice.polytech.si3.qgl.iaad.resource;

import java.util.Map;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
@FunctionalInterface
public interface Collectible
{
    Map<Resource, Integer> collect();
}
