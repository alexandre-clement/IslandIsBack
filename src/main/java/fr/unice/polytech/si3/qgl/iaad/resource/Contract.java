package fr.unice.polytech.si3.qgl.iaad.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
public class Contract
{
    private final Basket basket;
    private final Resource resource;
    private final double amount;
    private final List<Contract> underContract;

    public Contract(Resource resource, double amount)
    {
        this.resource = resource;
        this.amount = amount;

        underContract = new ArrayList<>();
        basket = new Basket();

        if (!resource.isCraft())
            basket.add(resource, amount);
        else
            for (Contract contract : resource.getContracts())
                underContract.add(new Contract(contract.getResource(), contract.getAmount() * amount));
        underContract.stream().map(Contract::getBasket).forEach(basket::addAll);
    }

    public List<Contract> getUnderContract()
    {
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

    public boolean complete()
    {
        return basket.isEmpty();
    }
}
