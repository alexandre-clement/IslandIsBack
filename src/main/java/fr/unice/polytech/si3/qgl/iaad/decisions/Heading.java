package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.map.Direction;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Heading extends Directed
{
    public Heading(Direction newHeading)
    {
        super(Actions.HEADING, newHeading);
    }
}
