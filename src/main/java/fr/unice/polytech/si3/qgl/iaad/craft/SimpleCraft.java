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

    private final Set<Product> products;
    private final Set<Reagent> reagents;

    SimpleCraft(Reagent[] reagents, Product... products)
    {
        this.products = new HashSet<>(Arrays.asList(products));
        this.reagents = new HashSet<>(Arrays.asList(reagents));
    }

    @Override
    public Set<Product> getProduct()
    {
        return products;
    }

    @Override
    public Set<Reagent> getReagent()
    {
        return reagents;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SimpleCraft that = (SimpleCraft) o;

        return products.equals(that.products) && reagents.equals(that.reagents);
    }

    @Override
    public int hashCode()
    {
        int result = products.hashCode();
        result = 31 * result + reagents.hashCode();
        return result;
    }
}
