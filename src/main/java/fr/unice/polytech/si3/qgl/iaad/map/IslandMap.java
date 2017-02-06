package fr.unice.polytech.si3.qgl.iaad.map;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class IslandMap
{
    private final List<Tile> map;
    private final Drone drone;
    private Vector dimension;

    public IslandMap(Drone drone)
    {
        this.drone = drone;
        dimension = new Vector(1, 1);
        map = new ArrayList<>();
        map.add(new Tile());
    }

    public Tile get(Vector vector)
    {
        return map.get(vector.scalarProduct(dimension));
    }

    public Vector getDimension()
    {
        return dimension;
    }

    public void increase(Direction direction, int size)
    {
        switch (direction)
        {
            case NORTH:
                addNorth(size);
                break;
            case EAST:
                addEast(size);
                break;
            case SOUTH:
                addSouth(size);
                break;
            case WEST:
                addWest(size);
        }
    }

    public int getRange(Direction direction)
    {
        return getRange(direction, drone.getVector());
    }

    private int getRange(Direction direction, Vector vector)
    {
        Vector vectorProjection = vector.vectorProduct(direction.getUnitaryVector());
        Vector dimensionProjection = dimension.vectorProduct(direction.getUnitaryVector());
        return (dimensionProjection.abs().addingTheComponents() + dimensionProjection.distance(vectorProjection)) % dimensionProjection.addingTheComponents();
    }

    private void addNorth(int size)
    {
        for (int i = 0; i < size; i++)
            addNorth();
    }

    private void addNorth()
    {
        dimension.add(1, 1);
        drone.getVector().add(Direction.NORTH.getUnitaryVector());
        for (int i = 0; i < dimension.get(0); i++)
            map.add(0, new Tile());
    }

    private void addEast(int size)
    {
        for (int i = 0; i < size; i++)
            addEast();
    }

    private void addEast()
    {
        dimension.add(0, 1);
        for (int i = dimension.get(0); i < dimension.multiplyTheComponents(); i += dimension.get(0))
            map.add(i, new Tile());
    }

    private void addSouth(int size)
    {
        for (int i = 0; i < size; i++)
            addSouth();
    }

    private void addSouth()
    {
        dimension.add(1, 1);
        for (int i = 0; i < dimension.get(0); i++)
            map.add(new Tile());
    }

    private void addWest(int size)
    {
        for (int i = 0; i < size; i++)
            addWest();
    }

    private void addWest()
    {
        dimension.add(0, 1);
        for (int i = 0; i < dimension.multiplyTheComponents(); i += dimension.get(0))
            map.add(i, new Tile());
    }
}
