package fr.unice.polytech.si3.qgl.iaad.format.json;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public enum JsonArguments
{
    HEADING("heading"),
    MEN("men"),
    BUDGET("budget"),
    AMOUNT("amount"),
    RESOURCE("resource"),
    CONTRACTS("contracts"),
    COST("cost"),
    EXTRAS("extras"),
    STATUS("status"),
    PARAMETERS("parameters"),
    RANGE("range"),
    FOUND("found"),
    BIOMES("biomes"),
    CREEKS("creeks"),
    SITES("sites"),
    ACTION("action"),
    DIRECTION("direction");

    private String name;

    JsonArguments(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public static JsonArguments argumentsOf(String name)
    {
        for (JsonArguments arguments : values())
            if (arguments.toString().equals(name))
                return arguments;
        return null;
    }
}
