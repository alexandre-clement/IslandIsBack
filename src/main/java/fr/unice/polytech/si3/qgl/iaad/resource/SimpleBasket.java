package fr.unice.polytech.si3.qgl.iaad.resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
public class SimpleBasket implements Basket
{
    private List<Resource> resources;

    public SimpleBasket()
    {
        this.resources = new ArrayList<>();
    }

    public SimpleBasket(Basket basket)
    {
        this();
        add(basket);
    }

    @Override
    public int size()
    {
        return resources.size();
    }

    @Override
    public void add(Resource resource, int amount)
    {
        for (int i = 0; i < amount; i++)
        {
            resources.add(resource);
        }
    }

    @Override
    public void remove(Resource resource, int amount)
    {
        for (int i = 0; i < amount; i++)
        {
            resources.remove(resource);
        }
    }

    @Override
    public boolean contains(Resource resource)
    {
        return resources.contains(resource);
    }

    @Override
    public boolean contains(Basket basket)
    {
        Basket temp = new SimpleBasket(this);
        for (Resource resource : basket)
        {
            if (temp.contains(resource))
                temp.remove(resource, 1);
            else
                return false;
        }
        return true;
    }

    @Override
    public int count(Resource resource)
    {
        return Math.toIntExact(resources.stream().filter(resource::equals).count());
    }

    @Override
    public Iterator<Resource> iterator()
    {
        return resources.iterator();
    }

    @Override
    public void clear()
    {
        resources.clear();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SimpleBasket resources1 = (SimpleBasket) o;

        return resources.equals(resources1.resources);
    }

    @Override
    public int hashCode()
    {
        return resources.hashCode();
    }

    @Override
    public String toString()
    {
        return resources.toString();
    }
}
