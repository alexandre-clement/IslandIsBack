package fr.unice.polytech.si3.qgl.iaad.vector;

import fr.unice.polytech.si3.qgl.iaad.map.Direction;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Alexandre Clement
 * @since 11/02/2017.
 */
public class SimpleRectangle implements Rectangle
{
    private final Map<Direction, Integer> map;

    public SimpleRectangle()
    {
        map = new EnumMap<>(Direction.class);
        map.put(Direction.WEST, 0);
        map.put(Direction.NORTH, 0);
        map.put(Direction.EAST, 0);
        map.put(Direction.SOUTH, 0);
    }

    public SimpleRectangle(int west, int north, int east, int south)
    {
        this();
        map.put(Direction.WEST, west);
        map.put(Direction.NORTH, north);
        map.put(Direction.EAST, east);
        map.put(Direction.SOUTH, south);
    }

    @Override
    public void increase(Direction direction)
    {
        map.put(direction, map.get(direction) + 1);
    }

    @Override
    public int get(Direction direction)
    {
        return map.get(direction);
    }

    @Override
    public void setRectangle(Rectangle rectangle)
    {
        for (Direction direction : Direction.values())
        {
            map.put(direction, rectangle.get(direction));
        }
    }

    @Override
    public Rectangle mul(Rectangle rectangle)
    {
        for (Direction direction : Direction.values())
        {
            map.put(direction, get(direction) * rectangle.get(direction));
        }
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SimpleRectangle that = (SimpleRectangle) o;

        return map != null ? map.equals(that.map) : that.map == null;
    }

    @Override
    public int hashCode()
    {
        return map != null ? map.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return map.toString();
    }
}
