package fr.unice.polytech.si3.qgl.iaad.contract;

import fr.unice.polytech.si3.qgl.iaad.craft.Craft;
import fr.unice.polytech.si3.qgl.iaad.craft.Recipe;
import fr.unice.polytech.si3.qgl.iaad.resource.Basket;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
public interface Contract
{
    boolean isComplete();

    Basket getReagentResources();

    Basket getProductsResources();

    void collected(int production);

    default boolean isACraft()
    {
        return getRecipe() != null;
    }

    Recipe getRecipe();

    Craft getCraft();
}
