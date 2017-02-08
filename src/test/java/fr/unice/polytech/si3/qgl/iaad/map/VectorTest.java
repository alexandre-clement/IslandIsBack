package fr.unice.polytech.si3.qgl.iaad.map;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * @author Alexandre Clement
 * @since 08/02/2017.
 */
public class VectorTest
{
    private Vector vector1;
    private Vector vector2;

    @Before
    public void setUp() throws Exception
    {
        vector1 = new Vector(3, 4);
        vector2 = new Vector(-6, 8);
    }

    @Test
    public void distance() throws Exception
    {
        double distance = new Point(vector1.getX(), vector1.getY()).distance(new Point(vector2.getX(), vector2.getY()));
        assertEquals(distance, vector1.distance(vector2), 0.0001);
    }

    @Test
    public void add() throws Exception
    {

    }

    @Test
    public void sub() throws Exception
    {

    }

    @Test
    public void getOpposite() throws Exception
    {

    }

    @Test
    public void mul() throws Exception
    {

    }

    @Test
    public void scalarProduct() throws Exception
    {
        assertEquals(0, vector1.dotProduct(new Vector()), 0.0001);
        assertEquals(14, vector2.dotProduct(vector1), 0.0001);
    }

    @Test
    public void magnitude() throws Exception
    {
        assertEquals(5, vector1.magnitude(), 0.0001);
        assertEquals(10, vector2.magnitude(), 0.0001);
    }

    @Test
    public void abs() throws Exception
    {

    }

}