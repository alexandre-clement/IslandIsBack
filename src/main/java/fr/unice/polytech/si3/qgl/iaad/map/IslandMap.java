package fr.unice.polytech.si3.qgl.iaad.map;

import fr.unice.polytech.si3.qgl.iaad.resource.Biomes;
import fr.unice.polytech.si3.qgl.iaad.resource.Creek;
import fr.unice.polytech.si3.qgl.iaad.resource.Site;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
public abstract class IslandMap
{
    private final Workforce workforce;
    private final List<Tile> map;
    private final Vector dimensions;

    IslandMap(Workforce workforce)
    {
        this.workforce = workforce;
        map = new ArrayList<>();
        dimensions = new Vector();
    }

    IslandMap(Workforce workforce, Vector dimensions)
    {
        this(workforce);
        this.dimensions.setVector(dimensions);
        for (int i = 0; i < size(); i++)
            map.add(new Tile());
    }

    private int size()
    {
        return dimensions.getX() * dimensions.getY();
    }

    private boolean isInRange(Vector location)
    {
        boolean x = 0 <= location.getX() && location.getX() < dimensions.getX();
        boolean y = 0 <= location.getY() && location.getY() < dimensions.getY();
        return x && y;
    }

    private Tile getCurrentTile()
    {
        return get(workforce.getLocation());
    }

    public Optional<Tile> getNextTile(Direction direction)
    {
        Vector nextTile = workforce.getLocation().add(direction.getUnitaryVector());
        if (isInRange(nextTile))
            return Optional.of(get(nextTile));
        return Optional.empty();
    }

    private Tile get(Vector vector)
    {
        return map.get(getTilePosition(vector));
    }

    private void addBiomes(List<Biomes> biomes)
    {
        addBiomes(workforce.getLocation(), biomes);
    }

    private void addBiomes(Vector vector, List<Biomes> biomes)
    {
        get(vector).addBiomes(biomes);
    }

    public List<Biomes> getBiomes()
    {
        return getBiomes(workforce.getLocation());
    }

    private List<Biomes> getBiomes(Vector vector)
    {
        return get(vector).getBiomes();
    }

    private void addCreeks(List<Creek> creeks)
    {
        addCreeks(workforce.getLocation(), creeks);
    }

    private void addCreeks(Vector vector, List<Creek> creeks)
    {
        get(vector).addCreeks(creeks);
    }

    public List<Creek> getCreeks()
    {
        return getCreeks(workforce.getLocation());
    }

    private List<Creek> getCreeks(Vector vector)
    {
        return get(vector).getCreeks();
    }

    private void addSites(List<Site> sites)
    {
        addSites(workforce.getLocation(), sites);
    }

    private void addSites(Vector vector, List<Site> sites)
    {
        get(vector).addSites(sites);
    }

    public List<Site> getSites()
    {
        return getSites(workforce.getLocation());
    }

    private List<Site> getSites(Vector vector)
    {
        return get(vector).getSites();
    }

    public void visitCurrentTile()
    {
        getCurrentTile().visit();
    }

    public void visitCurrentTile(List<Biomes> biomes, List<Creek> creeks, List<Site> sites)
    {
        visitCurrentTile();
        addBiomes(biomes);
        addCreeks(creeks);
        addSites(sites);
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
        return getRange(direction, workforce.getLocation());
    }

    private int getRange(Direction direction, Vector vector)
    {
        Vector unitary = direction.getUnitaryVector();
        int argument = unitary.dotProduct(Vector.unitary);
        if (argument > 0)
            return dimensions.dotProduct(unitary) - vector.dotProduct(unitary);
        return -vector.dotProduct(unitary);
    }

    Workforce getWorkforce()
    {
        return workforce;
    }

    Vector getDimensions()
    {
        return new Vector(dimensions);
    }

    List<Tile> getMap()
    {
        return map;
    }

    private void addNorth(int size)
    {
        for (int i = 0; i < size; i++)
            addNorth();
    }

    private void addNorth()
    {
        dimensions.sub(Direction.NORTH.getUnitaryVector());
        workforce.move(Direction.NORTH.getBack().getUnitaryVector());
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
        for (int i = dimensions.getX() - 1; i < size(); i += dimensions.getX())
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
        workforce.move(Direction.WEST.getBack().getUnitaryVector());
        for (int i = 0; i < size(); i += dimensions.getX())
            map.add(i, new Tile());
    }

    public void land(Creek creek)
    {
        Optional<Tile> optional = map.stream().filter(tile -> tile.getCreeks().contains(creek)).findFirst();
        optional.ifPresent(tile -> getWorkforce().setLocation(getContainerLocation(tile)));
    }

    private Vector getContainerLocation(Tile tile)
    {
        int position = getMap().indexOf(tile);
        return getVectorFromPosition(position);
    }

    private int getTilePosition(Vector vector)
    {
        return vector.getY() * dimensions.getX() + vector.getX();
    }

    private Vector getVectorFromPosition(int position)
    {
        return new Vector(position % dimensions.getX(), position / dimensions.getX());
    }

    @Override
    public String toString()
    {
        return map.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
}
