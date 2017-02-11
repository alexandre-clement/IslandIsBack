package fr.unice.polytech.si3.qgl.iaad.resource;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public enum Biomes
{
    OCEAN(Resource.FISH),
    LAKE(Resource.FISH),
    BEACH(Resource.QUARTZ),
    GRASSLAND(Resource.FUR),
    MANGROVE(Resource.FLOWER, Resource.WOOD),
    TROPICAL_RAIN_FOREST(Resource.FRUITS, Resource.SUGAR_CANE),
    TROPICAL_SEASONAL_FOREST(Resource.FRUITS, Resource.SUGAR_CANE),
    TEMPERATE_DECIDUOUS_FOREST(Resource.WOOD),
    TEMPERATE_RAIN_FOREST(Resource.WOOD),
    TEMPERATE_DESERT(Resource.ORE, Resource.QUARTZ),
    TAIGA(),
    SNOW(Resource.ORE),
    ALPINE(Resource.FLOWER, Resource.ORE),
    GLACIER(Resource.FLOWER),
    SHRUBLAND(Resource.FUR),
    SUB_TROPICAL_DESERT(Resource.ORE, Resource.QUARTZ);

    private Resource[] resources;

    Biomes(Resource... resources)
    {
        this.resources = resources;
    }

    public Resource[] getResources()
    {
        return resources;
    }
}
