package fr.unice.polytech.si3.qgl.iaad.format;

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

    List<ResourceInformation> getResources();

    int getAmount();
}
