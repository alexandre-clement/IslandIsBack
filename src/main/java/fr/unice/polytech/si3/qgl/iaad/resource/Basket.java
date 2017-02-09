package fr.unice.polytech.si3.qgl.iaad.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
public class Basket extends ArrayList<Resource>
{
    public Basket()
    {
        super();
    }

    private Basket(Collection<Resource> resources)
    {
        super(resources);
    }

    public void add(Resource resource, double number)
    {
        add(resource, (int) Math.ceil(number));
    }

    public void add(Resource resource, int number)
    {
        IntStream.range(0, number).forEach(i -> this.add(resource));
    }

    public void remove(Basket basket)
    {
        Basket temp = new Basket(basket);

        for (Resource resource : temp)
        {
            remove(resource);
        }
    }

    public boolean contains(Basket basket)
    {
        Basket temp = new Basket(this);
        for (Resource resource : basket)
        {
            if (temp.contains(resource))
                temp.remove(resource);
            else
                return false;
        }
        return true;
    }
}