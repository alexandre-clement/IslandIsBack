package fr.unice.polytech.si3.qgl.iaad.utils;

import fr.unice.polytech.si3.qgl.iaad.vector.SimpleVector;
import fr.unice.polytech.si3.qgl.iaad.vector.Vector;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
class Workforce
{
    private final Vector location;

    Workforce(Vector location)
    {
        this.location = location;
    }

    public Vector getLocation()
    {
        return new SimpleVector(location);
    }

    void setLocation(Vector location)
    {
        this.location.setVector(location);
    }

    void move(Vector vector)
    {
        location.add(vector);
    }
}
