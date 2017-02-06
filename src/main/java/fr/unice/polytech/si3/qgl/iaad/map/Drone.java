package fr.unice.polytech.si3.qgl.iaad.map;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Drone
{
    private final Direction heading;
    private Vector vector;

    public Drone(Direction heading)
    {
        this.heading = heading;
        vector = new Vector(0, 0);
    }

    Vector getVector()
    {
        return vector;
    }

    public Direction getHeading()
    {
        return heading;
    }
}
