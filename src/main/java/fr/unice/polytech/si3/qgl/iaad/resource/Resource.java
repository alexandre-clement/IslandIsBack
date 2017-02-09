package fr.unice.polytech.si3.qgl.iaad.resource;

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
    GLASS("GLASS", new Contract(QUARTZ, 10), new Contract(WOOD, 5)),
    INGOT("INGOT", new Contract(ORE, 5), new Contract(WOOD, 5)),
    LEATHER("LEATHER", new Contract(FUR, 3)),
    PLANK("PLANK", new Contract(WOOD, 0.25)),
    RUM("RUM", new Contract(SUGAR_CANE, 10), new Contract(FRUITS, 1));

    private final String name;
    private final Contract[] contracts;

    Resource(String name, Contract... contracts)
    {
        this.name = name;
        this.contracts = contracts;
    }

    public Contract[] getContracts()
    {
        return contracts;
    }

    public boolean isCraft()
    {
        return contracts.length > 0;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
