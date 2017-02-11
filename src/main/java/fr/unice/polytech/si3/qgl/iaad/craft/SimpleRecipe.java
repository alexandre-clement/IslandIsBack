package fr.unice.polytech.si3.qgl.iaad.craft;

import fr.unice.polytech.si3.qgl.iaad.resource.Basket;
import fr.unice.polytech.si3.qgl.iaad.resource.Resource;
import fr.unice.polytech.si3.qgl.iaad.resource.SimpleBasket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Alexandre Clement
 * @since 11/02/2017.
 */
public class SimpleRecipe implements Recipe
{
    private Craft craft;
    private Map<Resource, Integer> map;

    public SimpleRecipe(Craft craft)
    {
        this.craft = craft;
        map = craft.getProduct().stream().collect(Collectors.toMap(Product::getKey, Product::getValue));
    }

    @Override
    public Basket getRequiredResourcesFor(Resource resource, int amount)
    {
        Basket basket = new SimpleBasket();

        for (Reagent reagent : craft.getReagent())
        {
            basket.add(reagent.getKey(), (int) Math.ceil(reagent.getValue() * amount / (double) map.get(resource)));
        }
        return basket;
    }

    @Override
    public Craft getCraftFor(Resource resource, int amount)
    {
        List<Reagent> reagents = new ArrayList<>();
        for (Reagent reagent : craft.getReagent())
        {
            reagents.add(new SimpleReagent(reagent.getKey(), (int) Math.ceil(reagent.getValue() * amount / (double) map.get(resource))));
        }
        List<Product> products = new ArrayList<>();
        products.add(new SimpleProduct(resource, amount));
        return new SimpleCraft(reagents.stream().toArray(Reagent[]::new), products.stream().toArray(Product[]::new));
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SimpleRecipe that = (SimpleRecipe) o;

        return craft.equals(that.craft) && map.equals(that.map);
    }

    @Override
    public int hashCode()
    {
        int result = craft.hashCode();
        result = 31 * result + map.hashCode();
        return result;
    }
}
