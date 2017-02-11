package fr.unice.polytech.si3.qgl.iaad.utils;

import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.vector.SimpleVector;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Drone extends Workforce
{
    private Direction heading;

    public Drone(Direction heading)
    {
        super(new SimpleVector(0, 0));
        this.heading = heading;
    }

    public void fly()
    {
        move(heading.getUnitaryVector());
    }

    public void heading(Direction direction)
    {
        fly();
        heading = direction;
        fly();
    }

    public Direction getHeading()
    {
        return heading;
    }

    @Override
    public String toString()
    {
        return String.format("Drone[%s, %s]", heading, getLocation());
    }
}
