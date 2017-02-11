package fr.unice.polytech.si3.qgl.iaad.contract;

import fr.unice.polytech.si3.qgl.iaad.craft.Craft;
import fr.unice.polytech.si3.qgl.iaad.craft.CraftEnum;
import fr.unice.polytech.si3.qgl.iaad.craft.Recipe;
import fr.unice.polytech.si3.qgl.iaad.craft.SimpleRecipe;
import fr.unice.polytech.si3.qgl.iaad.resource.Basket;
import fr.unice.polytech.si3.qgl.iaad.resource.Resource;
import fr.unice.polytech.si3.qgl.iaad.resource.SimpleBasket;

import java.util.Optional;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
public class SimpleContract implements Contract
{
    private final Resource resource;
    private final int amount;
    private final Basket reagentBasket;
    private final Basket productsBasket;
    private Recipe recipe;

    public SimpleContract(Resource resource, int amount)
    {
        this.resource = resource;
        this.amount = amount;
        reagentBasket = new SimpleBasket();
        productsBasket = new SimpleBasket();
        productsBasket.add(resource, amount);

        Optional<Craft> craftOptional = CraftEnum.getCraft(resource);
        if (craftOptional.isPresent())
        {
            recipe = new SimpleRecipe(craftOptional.get());
            reagentBasket.add(recipe.getRequiredResourcesFor(resource, amount));
        }
        else
            reagentBasket.add(resource, amount);
    }

    @Override
    public boolean isComplete()
    {
        return productsBasket.isEmpty();
    }

    @Override
    public Basket getReagentResources()
    {
        return new SimpleBasket(reagentBasket);
    }

    @Override
    public Basket getProductsResources()
    {
        return new SimpleBasket(productsBasket);
    }

    @Override
    public void collected(int production)
    {
        if (!isACraft())
        {
            reagentBasket.remove(resource, production);
            productsBasket.remove(resource, production);
        }
        else
        {
            productsBasket.remove(resource, production);
            reagentBasket.remove(recipe.getRequiredResourcesFor(resource, production));
        }
    }

    @Override
    public Recipe getRecipe()
    {
        return recipe;
    }

    @Override
    public Craft getCraft()
    {
        return recipe.getCraftFor(resource, productsBasket.count(resource));
    }

    @Override
    public String toString()
    {
        return String.format("Contract{%s : %s : %s : %s}", resource, amount, reagentBasket.size(), productsBasket.size());
    }
}
