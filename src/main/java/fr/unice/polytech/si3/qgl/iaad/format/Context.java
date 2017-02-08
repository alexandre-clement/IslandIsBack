package fr.unice.polytech.si3.qgl.iaad.format;

import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.map.IslandMap;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public interface Context
{
    Direction getHeading();

    int getBudget();

    IslandMap getIslandMap();

    int getMen();
}
