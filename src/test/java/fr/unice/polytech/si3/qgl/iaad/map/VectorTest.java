package fr.unice.polytech.si3.qgl.iaad.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class VectorTest
{
    private Vector vectorNull;
    private Vector vectorUnitary;
    private Vector vector;

    @Before
    public void setUp() throws Exception
    {
        vectorNull = new Vector();
        vectorUnitary = new Vector(0, 1);
        vector = new Vector(10, 4);
    }

    @Test
    public void computeScalarProduct() throws Exception
    {
        assertEquals(4, vector.scalarProduct(vectorUnitary));
    }

}