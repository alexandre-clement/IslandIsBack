package fr.unice.polytech.si3.qgl.iaad.utils;

import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.resource.Basket;
import fr.unice.polytech.si3.qgl.iaad.resource.SimpleBasket;
import fr.unice.polytech.si3.qgl.iaad.vector.SimpleVector;
import fr.unice.polytech.si3.qgl.iaad.vector.Vector;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
public class Crew extends Workforce
{
    private final Basket basket;
    private final int people;

    private Crew(int people)
    {
        super(new SimpleVector());
        this.people = people;
        this.basket = new SimpleBasket();
    }

    public Crew(Vector location, int people)
    {
        this(people);
        setLocation(location);
    }

    public void moveTo(Direction direction)
    {
        move(direction.getUnitaryVector());
    }

    public Basket getBasket()
    {
        return basket;
    }

    public int getPeople()
    {
        return people;
    }
}
