package fr.unice.polytech.si3.qgl.iaad.map;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Site
{
    private String id;

    public Site(String site)
    {
        this.id = site;
    }

    @Override
    public String toString()
    {
        return id;
    }
}
