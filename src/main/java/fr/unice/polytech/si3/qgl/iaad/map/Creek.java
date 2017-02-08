package fr.unice.polytech.si3.qgl.iaad.map;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Creek
{
    private String id;

    public Creek(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return id;
    }
}
