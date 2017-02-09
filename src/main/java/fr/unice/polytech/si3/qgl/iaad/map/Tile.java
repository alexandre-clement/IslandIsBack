package fr.unice.polytech.si3.qgl.iaad.map;

import fr.unice.polytech.si3.qgl.iaad.format.Biomes;
import fr.unice.polytech.si3.qgl.iaad.format.Creek;
import fr.unice.polytech.si3.qgl.iaad.format.Site;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
public class Tile
{
    private final List<Biomes> biomes;
    private final List<Creek> creeks;
    private final List<Site> sites;
    private int visited;

    Tile()
    {
        this.biomes = new ArrayList<>();
        this.creeks = new ArrayList<>();
        this.sites = new ArrayList<>();
        visited = 0;
    }

    void visit()
    {
        visited += 1;
    }

    private int getVisited()
    {
        return visited;
    }

    public boolean isAlreadyVisited()
    {
        return getVisited() != 0;
    }

    void addBiomes(List<Biomes> biomes)
    {
        this.biomes.addAll(biomes);
    }

    void addCreeks(List<Creek> creeks)
    {
        this.creeks.addAll(creeks);
    }

    void addSites(List<Site> sites)
    {
        this.sites.addAll(sites);
    }

    List<Biomes> getBiomes()
    {
        return biomes;
    }

    List<Creek> getCreeks()
    {
        return creeks;
    }

    List<Site> getSites()
    {
        return sites;
    }

    @Override
    public String toString()
    {
        return String.format("{%s, %s, %s}", biomes, creeks, sites);
    }
}
