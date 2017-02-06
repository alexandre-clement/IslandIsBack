package fr.unice.polytech.si3.qgl.iaad.decisions;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public enum Actions
{
    FLY("fly"),
    HEADING("heading"),
    ECHO("echo"),
    SCAN("scan"),
    STOP("stop"),
    LAND("land"),
    MOVE_TO("move_to"),
    SCOUT("scout"),
    GLIMPSE("glimpse"),
    EXPLORE("explore"),
    EXPLOIT("exploit"),
    TRANSFORM("transform");

    private String name;

    Actions(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
