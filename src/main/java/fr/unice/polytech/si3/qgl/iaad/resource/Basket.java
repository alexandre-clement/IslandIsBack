package fr.unice.polytech.si3.qgl.iaad.resource;

import java.util.Collection;

/**
 * @author Alexandre Clement
 * @since 09/02/2017.
 */
public interface Basket extends Iterable<Resource>
{
    int size();

    default boolean isEmpty()
    {
        return size() == 0;
    }

    void add(Resource resource, int amount);

    default void add(Basket basket)
    {
        for (Resource resource : basket)
        {
            add(resource, 1);
        }
    }

    default void addAll(Collection<Basket> baskets)
    {
        for (Basket basket : baskets)
        {
            add(basket);
        }
    }

    void remove(Resource resource, int amount);

    default void remove(Basket basket)
    {
        for (Resource resource : basket)
        {
            remove(resource, 1);
        }
    }

    boolean contains(Resource resource);

    boolean contains(Basket basket);

    int count(Resource resource);

    void clear();
}