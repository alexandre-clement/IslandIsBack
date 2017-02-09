package fr.unice.polytech.si3.qgl.iaad.map;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
public class Crew extends Workforce
{
    Crew(Vector location)
    {
        super(location);
    }

    public void moveTo(Direction direction)
    {
        move(direction.getUnitaryVector());
    }
}
