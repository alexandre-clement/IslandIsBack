package fr.unice.polytech.si3.qgl.iaad.craft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
public class SimpleCraft implements Craft
{
    private final Product[] products;
    private final Reagent[] reagents;

    SimpleCraft(Reagent[] reagents, Product... products)
    {
        this.products = products;
        this.reagents = reagents;
    }

    @Override
    public Set<Product> getProduct()
    {
        return new HashSet<>(Arrays.asList(products));
    }

    @Override
    public Set<Reagent> getReagent()
    {
        return new HashSet<>(Arrays.asList(reagents));
    }
}
