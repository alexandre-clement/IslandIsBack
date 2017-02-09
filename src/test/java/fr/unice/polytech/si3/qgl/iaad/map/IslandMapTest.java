package fr.unice.polytech.si3.qgl.iaad.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
public class IslandMapTest
{
    private AerialMap islandMap;

    @Before
    public void setUp() throws Exception
    {
        islandMap = new AerialMap(new Drone(Direction.EAST));
    }

    @Test
    public void getRange() throws Exception
    {
        islandMap.increase(Direction.EAST, 10);
        assertEquals(10, islandMap.getRange(Direction.EAST));
        assertEquals(0, islandMap.getRange(Direction.WEST));

        islandMap.getDrone().fly();
        assertEquals(9, islandMap.getRange(Direction.EAST));
        assertEquals(1, islandMap.getRange(Direction.WEST));

        islandMap.increase(Direction.SOUTH, 20);
        islandMap.getDrone().heading(Direction.SOUTH);
        assertEquals(8, islandMap.getRange(Direction.EAST));
        assertEquals(2, islandMap.getRange(Direction.WEST));
        assertEquals(1, islandMap.getRange(Direction.NORTH));
        assertEquals(19, islandMap.getRange(Direction.SOUTH));

        islandMap.getDrone().fly();
        assertEquals(8, islandMap.getRange(Direction.EAST));
        assertEquals(2, islandMap.getRange(Direction.WEST));
        assertEquals(2, islandMap.getRange(Direction.NORTH));
        assertEquals(18, islandMap.getRange(Direction.SOUTH));

        islandMap.getDrone().heading(Direction.WEST);
        assertEquals(9, islandMap.getRange(Direction.EAST));
        assertEquals(1, islandMap.getRange(Direction.WEST));
        assertEquals(3, islandMap.getRange(Direction.NORTH));
        assertEquals(17, islandMap.getRange(Direction.SOUTH));
    }
}