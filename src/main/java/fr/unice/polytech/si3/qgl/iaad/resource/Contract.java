package fr.unice.polytech.si3.qgl.iaad.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
public class Contract
{
    private final Basket basket;
    private final Resource resource;
    private final double amount;

    public Contract(Resource resource, double amount)
    {
        this.resource = resource;
        this.amount = amount;

        basket = new Basket();

        if (!resource.isCraft())
            basket.add(resource, amount);
        else
            for (Contract contract : resource.getContracts())
                basket.add(contract.getResource(), contract.amount * amount);

    }

    public List<Contract> getUnderContract()
    {
        List<Contract> underContract = new ArrayList<>();
        for (Map.Entry<Resource, Integer> entry : basket.getMap().entrySet())
        {
            underContract.add(new Contract(entry.getKey(), entry.getValue()));
        }
        return underContract;
    }

    public Resource getResource()
    {
        return resource;
    }

    public int getAmount()
    {
        return (int) Math.ceil(amount);
    }

    public Basket getBasket()
    {
        return basket;
    }

    public void collect(int collected)
    {
        if (!resource.isCraft())
            basket.remove(resource, collected);
        else
            for (Contract contract : resource.getContracts())
                basket.remove(contract.getResource(), contract.getAmount() * collected);
    }

    public boolean complete()
    {
        return basket.isEmpty();
    }
}
