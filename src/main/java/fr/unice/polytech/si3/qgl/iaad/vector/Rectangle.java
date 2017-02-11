package fr.unice.polytech.si3.qgl.iaad.vector;

import fr.unice.polytech.si3.qgl.iaad.map.Direction;

/**
 * @author Alexandre Clement
 * @since 11/02/2017.
 */
public interface Rectangle
{
    void increase(Direction direction);

    int get(Direction direction);

    void setRectangle(Rectangle rectangle);

    Rectangle mul(Rectangle rectangle);

    default int getEast()
    {
        return get(Direction.EAST);
    }

    default int getWest()
    {
        return get(Direction.WEST);
    }

    default int getNorth()
    {
        return get(Direction.NORTH);
    }

    default int getSouth()
    {
        return get(Direction.SOUTH);
    }

    default int getX()
    {
        return getWest() + getEast() + 1;
    }

    default int getY()
    {
        return getNorth() + getSouth() + 1;
    }

    default int size()
    {
        return getX() * getY();
    }
}
