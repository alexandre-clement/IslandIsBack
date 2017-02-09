package fr.unice.polytech.si3.qgl.iaad.resource;

import java.util.*;
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

    void remove(Resource resource, int number)
    {
        IntStream.range(0, number).forEach(i -> this.remove(resource));
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

    private int countResource(Resource resource)
    {
        return (int) super.stream().filter(i -> i.equals(resource)).count();
    }

    Map<Resource, Integer> getMap()
    {
        Map<Resource, Integer> map = new EnumMap<>(Resource.class);
        for (Resource resource : new HashSet<>(this))
            map.put(resource, countResource(resource));
        return map;
    }
}