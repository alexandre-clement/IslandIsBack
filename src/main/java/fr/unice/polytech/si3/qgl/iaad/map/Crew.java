package fr.unice.polytech.si3.qgl.iaad.map;

import fr.unice.polytech.si3.qgl.iaad.resource.Basket;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
public class Crew extends Workforce
{
    private final Basket basket;

    Crew(Vector location)
    {
        super(location);
        this.basket = new Basket();
    }

    public void moveTo(Direction direction)
    {
        move(direction.getUnitaryVector());
    }

    public Basket getBasket()
    {
        return basket;
    }
}
