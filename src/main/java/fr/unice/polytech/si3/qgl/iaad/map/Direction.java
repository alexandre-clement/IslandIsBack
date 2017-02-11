package fr.unice.polytech.si3.qgl.iaad.map;


import fr.unice.polytech.si3.qgl.iaad.vector.SimpleVector;
import fr.unice.polytech.si3.qgl.iaad.vector.Vector;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public enum Direction
{
    NORTH("N", new SimpleVector(0, -1)),
    EAST("E", new SimpleVector(1, 0)),
    SOUTH("S", new SimpleVector(0, 1)),
    WEST("W", new SimpleVector(-1, 0));

    private String name;
    private Vector unitaryVector;

    Direction(String name, SimpleVector unitaryVector)
    {
        this.name = name;
        this.unitaryVector = unitaryVector;
    }

    public static Direction directionOf(String name)
    {
        for (Direction direction : values())
            if (direction.toString().equals(name))
                return direction;
        return null;
    }

    public Vector getUnitaryVector()
    {
        return new SimpleVector(unitaryVector);
    }

    public Direction getRight()
    {
        return Direction.values()[(this.ordinal() + 1) % 4];
    }

    public Direction getLeft()
    {
        return Direction.values()[(this.ordinal() + 3) % 4];
    }

    public Direction getBack()
    {
        return Direction.values()[(this.ordinal() + 2) % 4];
    }

    @Override
    public String toString()
    {
        return name;
    }
}
