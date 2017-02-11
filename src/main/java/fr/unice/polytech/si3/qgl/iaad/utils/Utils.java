package fr.unice.polytech.si3.qgl.iaad.utils;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
public class Utils
{
    private final String id;

    Utils(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Utils utils = (Utils) o;

        return id.equals(utils.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return id;
    }
}
