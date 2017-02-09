package fr.unice.polytech.si3.qgl.iaad.map;

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

    Vector getLocation()
    {
        return new Vector(location);
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
