package fr.unice.polytech.si3.qgl.iaad.resource;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
public class Contract
{
    private final Resource resource;
    private int amount;

    public Contract(Resource resource, int amount)
    {
        this.resource = resource;
        this.amount = amount;
    }

    public Resource getResource()
    {
        return resource;
    }

    public int getAmount()
    {
        return amount;
    }

    public boolean complete()
    {
        return amount <= 0;
    }

    public void retrieves(int amount)
    {
        this.amount -= amount;
    }
}
