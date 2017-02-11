package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.map.Direction;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public class Echo extends Directed
{
    public Echo(Direction direction)
    {
        super(Actions.ECHO, direction);
    }
}
