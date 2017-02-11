package fr.unice.polytech.si3.qgl.iaad.craft;

import java.util.Set;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
public interface Craft
{
    Set<Product> getProduct();

    Set<Reagent> getReagent();
}
