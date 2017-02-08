package fr.unice.polytech.si3.qgl.iaad.map;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
class Tile
{
    private final List<Biomes> biomes;
    private final List<Creek> creeks;
    private final List<Site> sites;

    Tile()
    {
        this.biomes = new ArrayList<>();
        this.creeks = new ArrayList<>();
        this.sites = new ArrayList<>();
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

    public List<Biomes> getBiomes()
    {
        return biomes;
    }

    public List<Creek> getCreeks()
    {
        return creeks;
    }

    public List<Site> getSites()
    {
        return sites;
    }

    @Override
    public String toString()
    {
        return String.format("{%s, %s, %s}", biomes, creeks, sites);
    }
}
