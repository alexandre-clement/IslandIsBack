package fr.unice.polytech.si3.qgl.iaad.map;

import fr.unice.polytech.si3.qgl.iaad.resource.Biomes;
import fr.unice.polytech.si3.qgl.iaad.utils.Creek;
import fr.unice.polytech.si3.qgl.iaad.utils.Site;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
public class SimpleTile implements Tile
{
    private final List<Biomes> biomes;
    private final List<Creek> creeks;
    private final List<Site> sites;
    private int visited;

    SimpleTile()
    {
        biomes = new ArrayList<>();
        creeks = new ArrayList<>();
        sites = new ArrayList<>();
        visited = 0;
    }

    @Override
    public void visit()
    {
        visited += 1;
    }

    @Override
    public boolean isAlreadyVisited()
    {
        return visited > 0;
    }

    @Override
    public void addBiomes(List<Biomes> biomes)
    {
        this.biomes.addAll(biomes);
    }

    @Override
    public void addCreeks(List<Creek> creeks)
    {
        this.creeks.addAll(creeks);
    }

    @Override
    public void addSites(List<Site> sites)
    {
        this.sites.addAll(sites);
    }

    @Override
    public List<Biomes> getBiomes()
    {
        return biomes;
    }

    @Override
    public List<Creek> getCreeks()
    {
        return creeks;
    }

    @Override
    public List<Site> getSites()
    {
        return sites;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SimpleTile that = (SimpleTile) o;

        return visited == that.visited && biomes.equals(that.biomes) && creeks.equals(that.creeks) && sites.equals(that.sites);
    }

    @Override
    public int hashCode()
    {
        int result = biomes.hashCode();
        result = 31 * result + creeks.hashCode();
        result = 31 * result + sites.hashCode();
        result = 31 * result + visited;
        return result;
    }

    @Override
    public String toString()
    {
        return String.format("{%s, %s, %s}", biomes, creeks, sites);
    }
}
