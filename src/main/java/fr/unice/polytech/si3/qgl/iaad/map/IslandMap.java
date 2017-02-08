package fr.unice.polytech.si3.qgl.iaad.map;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class IslandMap
{
    private final List<Tile> map;
    private final Drone drone;
    private Vector dimensions;

    public IslandMap(Drone drone)
    {
        this.drone = drone;
        map = new ArrayList<>();
        map.add(new Tile());
        dimensions = new Vector();
    }

    private Tile get(Vector vector)
    {
        return map.get(vector.getY() * dimensions.getX() + vector.getX());
    }

    public void addBiomes(List<Biomes> biomes)
    {
        addBiomes(drone.getVector(), biomes);
    }

    private void addBiomes(Vector vector, List<Biomes> biomes)
    {
        get(vector).addBiomes(biomes);
    }

    public List<Biomes> getBiomes()
    {
        return getBiomes(drone.getVector());
    }

    private List<Biomes> getBiomes(Vector vector)
    {
        return get(vector).getBiomes();
    }

    public void addCreeks(List<Creek> creeks)
    {
        addCreeks(drone.getVector(), creeks);
    }

    private void addCreeks(Vector vector, List<Creek> creeks)
    {
        get(vector).addCreeks(creeks);
    }

    public List<Creek> getCreeks()
    {
        return getCreeks(drone.getVector());
    }

    private List<Creek> getCreeks(Vector vector)
    {
        return get(vector).getCreeks();
    }

    public void addSites(List<Site> sites)
    {
        addSites(drone.getVector(), sites);
    }

    private void addSites(Vector vector, List<Site> sites)
    {
        get(vector).addSites(sites);
    }

    public List<Site> getSites()
    {
        return getSites(drone.getVector());
    }

    private List<Site> getSites(Vector vector)
    {
        return get(vector).getSites();
    }

    public void increase(Direction direction, int size)
    {
        int range = size - getRange(direction);
        switch (direction)
        {
            case NORTH:
                addNorth(range);
                break;
            case EAST:
                addEast(range);
                break;
            case SOUTH:
                addSouth(range);
                break;
            case WEST:
                addWest(range);
        }
    }

    public int getRange(Direction direction)
    {
        return getRange(direction, drone.getVector());
    }

    private int getRange(Direction direction, Vector vector)
    {
        Vector unitary = direction.getUnitaryVector();
        int argument = unitary.dotProduct(Vector.unitary);
        if (argument > 0)
            return dimensions.dotProduct(unitary) - vector.dotProduct(unitary);
        return -vector.dotProduct(unitary);
    }

    public Drone getDrone()
    {
        return drone;
    }

    private void addNorth(int size)
    {
        for (int i = 0; i < size; i++)
            addNorth();
    }

    private void addNorth()
    {
        dimensions.sub(Direction.NORTH.getUnitaryVector());
        drone.getVector().sub(Direction.NORTH.getUnitaryVector());
        for (int i = 0; i < dimensions.getX(); i++)
            map.add(0, new Tile());
    }

    private void addEast(int size)
    {
        for (int i = 0; i < size; i++)
            addEast();
    }

    private void addEast()
    {
        dimensions.add(Direction.EAST.getUnitaryVector());
        for (int i = dimensions.getX() - 1; i < dimensions.dotProduct(Vector.unitary); i += dimensions.getX())
            map.add(i, new Tile());
    }

    private void addSouth(int size)
    {
        for (int i = 0; i < size; i++)
            addSouth();
    }

    private void addSouth()
    {
        dimensions.add(Direction.SOUTH.getUnitaryVector());
        for (int i = 0; i < dimensions.getX(); i++)
            map.add(new Tile());
    }

    private void addWest(int size)
    {
        for (int i = 0; i < size; i++)
            addWest();
    }

    private void addWest()
    {
        dimensions.sub(Direction.WEST.getUnitaryVector());
        drone.getVector().sub(Direction.WEST.getUnitaryVector());
        for (int i = 0; i < dimensions.dotProduct(Vector.unitary); i += dimensions.getX())
            map.add(i, new Tile());
    }

    @Override
    public String toString()
    {
        return map.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
}
