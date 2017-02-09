package fr.unice.polytech.si3.qgl.iaad.map;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
public class GroundMap extends IslandMap
{
    private static final Vector TILE_SIZE = new Vector(3, 3);

    public GroundMap(AerialMap map)
    {
        super(new Crew(map.getDrone().getLocation().mul(TILE_SIZE)), map.getDimensions().mul(TILE_SIZE));
    }

    public Crew getCrew()
    {
        return (Crew) getWorkforce();
    }
}
