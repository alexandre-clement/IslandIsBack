package fr.unice.polytech.si3.qgl.iaad.format;

import fr.unice.polytech.si3.qgl.iaad.map.Biomes;
import fr.unice.polytech.si3.qgl.iaad.map.Creek;
import fr.unice.polytech.si3.qgl.iaad.map.Found;
import fr.unice.polytech.si3.qgl.iaad.map.Site;

import java.util.List;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public interface Result
{
    Integer getCost();

    Integer getRange();

    Found getFound();

    List<Biomes> getBiomes();

    List<Creek> getCreeks();

    List<Site> getSites();
}
