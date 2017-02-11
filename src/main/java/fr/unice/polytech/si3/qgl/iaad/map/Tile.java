package fr.unice.polytech.si3.qgl.iaad.map;

import fr.unice.polytech.si3.qgl.iaad.resource.Biomes;
import fr.unice.polytech.si3.qgl.iaad.utils.Creek;
import fr.unice.polytech.si3.qgl.iaad.utils.Site;

import java.util.List;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
public interface Tile
{
    void visit();

    boolean isAlreadyVisited();

    void addBiomes(List<Biomes> biomes);

    void addCreeks(List<Creek> creeks);

    void addSites(List<Site> sites);

    List<Biomes> getBiomes();

    List<Creek> getCreeks();

    List<Site> getSites();
}
