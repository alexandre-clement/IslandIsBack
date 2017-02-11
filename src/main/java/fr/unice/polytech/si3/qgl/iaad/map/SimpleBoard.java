package fr.unice.polytech.si3.qgl.iaad.map;

import fr.unice.polytech.si3.qgl.iaad.vector.Rectangle;
import fr.unice.polytech.si3.qgl.iaad.vector.SimpleRectangle;
import fr.unice.polytech.si3.qgl.iaad.vector.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
public class SimpleBoard implements Board
{
    private List<List<Tile>> map;
    private Rectangle rectangle;

    public SimpleBoard()
    {
        map = new ArrayList<>();
        map.add(new ArrayList<>());
        map.get(0).add(new SimpleTile());
        rectangle = new SimpleRectangle();
    }

    public SimpleBoard(Rectangle rectangle)
    {
        this.rectangle = rectangle;
        map = new ArrayList<>();
        for (int i = 0; i < rectangle.getY(); i++)
        {
            map.add(new ArrayList<>());
            for (int j = 0; j < rectangle.getX(); j++)
            {
                map.get(i).add(new SimpleTile());
            }
        }

    }

    @Override
    public boolean isOnBoard(Vector location)
    {
        boolean x = -rectangle.getNorth() <= location.getY() && rectangle.getSouth() >= location.getY();
        boolean y = -rectangle.getWest() <= location.getX() && rectangle.getEast() >= location.getX();
        return x && y;
    }

    @Override
    public Tile getTile(Vector location)
    {
        return map.get(location.getY() + rectangle.getNorth()).get(location.getX() + rectangle.getWest());
    }

    @Override
    public void increase(Direction direction, int size)
    {
        for (int i = 0; i < size; i++)
        {
            increase(direction);
        }
    }

    private void increase(Direction direction)
    {
        List<Tile> increase;
        if (direction == Direction.SOUTH)
        {
            increase = new ArrayList<>();
            for (int i = 0; i < rectangle.getX(); i++)
            {
                increase.add(new SimpleTile());
            }
            map.add(increase);
        }
        else if (direction == Direction.NORTH)
        {
            increase = new ArrayList<>();
            for (int i = 0; i < rectangle.getX(); i++)
            {
                increase.add(new SimpleTile());
            }
            map.add(0, increase);

        }
        else if (direction == Direction.EAST)
        {
            for (List<Tile> tiles : map)
            {
                tiles.add(new SimpleTile());
            }
        }
        else if (direction == Direction.WEST)
        {
            for (List<Tile> tiles : map)
            {
                tiles.add(0, new SimpleTile());
            }
        }
        rectangle.increase(direction);
    }

    @Override
    public int getRange(Direction direction, Vector location)
    {
        return (int) Math.abs(rectangle.get(direction) - direction.getUnitaryVector().mul(location).magnitude());
    }

    @Override
    public Rectangle getDimensions()
    {
        return rectangle;
    }

    public List<List<Tile>> getMap()
    {
        return map;
    }

    @Override
    public String toString()
    {
        return map.toString();
    }
}
