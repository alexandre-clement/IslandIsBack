package fr.unice.polytech.si3.qgl.iaad.map;


/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class AerialMap extends IslandMap
{
    public AerialMap(Drone drone)
    {
        super(drone);
    }

    public Drone getDrone()
    {
        return (Drone) getWorkforce();
    }
}
