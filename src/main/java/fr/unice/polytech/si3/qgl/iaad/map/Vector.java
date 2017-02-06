package fr.unice.polytech.si3.qgl.iaad.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
class Vector
{
    private final List<Integer> coordinates;

    Vector(Integer... coordinates)
    {
        this.coordinates = new ArrayList<>(Arrays.asList(coordinates));
    }

}
