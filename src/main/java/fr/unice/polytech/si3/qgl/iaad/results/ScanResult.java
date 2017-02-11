package fr.unice.polytech.si3.qgl.iaad.results;

import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.resource.Biomes;
import fr.unice.polytech.si3.qgl.iaad.utils.Creek;
import fr.unice.polytech.si3.qgl.iaad.utils.Site;

import java.util.List;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class ScanResult
{
    private final List<Biomes> biomes;
    private final List<Creek> creeks;
    private final List<Site> sites;

    public ScanResult(Result result)
    {
        this.biomes = result.getBiomes();
        this.creeks = result.getCreeks();
        this.sites = result.getSites();
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
}
