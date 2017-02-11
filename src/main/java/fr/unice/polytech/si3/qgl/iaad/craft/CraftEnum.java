package fr.unice.polytech.si3.qgl.iaad.craft;

import fr.unice.polytech.si3.qgl.iaad.resource.Resource;

import java.util.Optional;

/**
 * @author Alexandre Clement
 * @since 11/02/2017.
 */
public enum CraftEnum
{
    GLASS_CRAFT(new SimpleProduct(Resource.GLASS, 1), new SimpleReagent(Resource.QUARTZ, 10), new SimpleReagent(Resource.WOOD, 5)),
    INGOT_CRAFT(new SimpleProduct(Resource.INGOT, 1), new SimpleReagent(Resource.ORE, 5), new SimpleReagent(Resource.WOOD, 5)),
    LEATHER_CRAFT(new SimpleProduct(Resource.LEATHER, 1), new SimpleReagent(Resource.FUR, 3)),
    PLANK_CRAFT(new SimpleProduct(Resource.PLANK, 4), new SimpleReagent(Resource.WOOD, 1)),
    RUM_CRAFT(new SimpleProduct(Resource.RUM, 1), new SimpleReagent(Resource.SUGAR_CANE, 10), new SimpleReagent(Resource.FRUITS, 1));

    private final Craft craft;

    CraftEnum(Product product, Reagent... reagent)
    {
        this.craft = new SimpleCraft(reagent, product);
    }

    public static Optional<Craft> getCraft(Resource resource)
    {
        for (CraftEnum craft : CraftEnum.values())
        {
            for (Product product : craft.getCraft().getProduct())
            {
                if (product.getKey() == resource)
                    return Optional.of(craft.getCraft());
            }
        }
        return Optional.empty();
    }

    public Craft getCraft()
    {
        return craft;
    }
}
