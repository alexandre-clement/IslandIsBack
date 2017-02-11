package fr.unice.polytech.si3.qgl.iaad.map;

import fr.unice.polytech.si3.qgl.iaad.vector.Rectangle;
import fr.unice.polytech.si3.qgl.iaad.vector.Vector;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
public interface Board
{
    boolean isOnBoard(Vector location);

    Tile getTile(Vector location);

    void increase(Direction direction, int size);

    int getRange(Direction direction, Vector location);

    Rectangle getDimensions();
}
