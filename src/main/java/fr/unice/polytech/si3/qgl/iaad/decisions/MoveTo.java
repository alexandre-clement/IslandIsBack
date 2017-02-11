package fr.unice.polytech.si3.qgl.iaad.decisions;

import fr.unice.polytech.si3.qgl.iaad.map.Direction;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
public class MoveTo extends Directed
{
    public MoveTo(Direction direction)
    {
        super(Actions.MOVE_TO, direction);
    }
}
