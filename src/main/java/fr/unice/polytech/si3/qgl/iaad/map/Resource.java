package fr.unice.polytech.si3.qgl.iaad.map;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public enum Resource
{
    FISH("FISH"),
    FLOWER("FLOWER"),
    FRUITS("FRUITS"),
    FUR("FUR"),
    ORE("ORE"),
    QUARTZ("QUARTZ"),
    SUGAR_CANE("SUGAR_CANE"),
    WOOD("WOOD"),
    GLASS("GLASS"),
    INGOT("INGOT"),
    LEATHER("LEATHER"),
    PLANK("PLANK"),
    RUM("RUM");

    private String name;

    Resource(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
