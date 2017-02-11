package fr.unice.polytech.si3.qgl.iaad.vector;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
public class SimpleVector implements Vector
{
    private int x;
    private int y;

    public SimpleVector()
    {
        x = 0;
        y = 0;
    }

    public SimpleVector(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public SimpleVector(Vector vector)
    {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    @Override
    public Vector add(Vector vector)
    {
        x += vector.getX();
        y += vector.getY();
        return new SimpleVector(x, y);
    }

    @Override
    public Vector sub(Vector vector)
    {
        x -= vector.getX();
        y -= vector.getY();
        return new SimpleVector(x, y);
    }

    @Override
    public Vector mul(Vector vector)
    {
        x *= vector.getX();
        y *= vector.getY();
        return new SimpleVector(x, y);
    }

    @Override
    public void setVector(Vector vector)
    {
        x = vector.getX();
        y = vector.getY();
    }

    @Override
    public int squared()
    {
        return x * x + y * y;
    }

    @Override
    public double magnitude()
    {
        return Math.sqrt(squared());
    }

    @Override
    public double distance(Vector vector)
    {
        Vector distance = new SimpleVector(vector).sub(this);
        return distance.magnitude();
    }

    @Override
    public int dotProduct(Vector vector)
    {
        Vector distance = new SimpleVector(vector).sub(this);
        return squared() + vector.squared() - distance.squared();
    }

    @Override
    public int getX()
    {
        return x;
    }

    @Override
    public int getY()
    {
        return y;
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s)", x, y);
    }
}
