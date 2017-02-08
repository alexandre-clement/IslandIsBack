package fr.unice.polytech.si3.qgl.iaad.map;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
class Vector
{
    static final Vector unitary = new Vector(1, 1);
    private int x;
    private int y;

    Vector()
    {
        this(0, 0);
    }

    Vector(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    Vector(Vector vector)
    {
        this(vector.getX(), vector.getY());
    }

    double distance(Vector vector)
    {
        return new Vector(x - vector.getX(), y - vector.getY()).magnitude();
    }

    Vector add(Vector vector)
    {
        x += vector.getX();
        y += vector.getY();
        return this;
    }

    Vector sub(Vector vector)
    {
        return add(vector.getOpposite());
    }

    private Vector getOpposite()
    {
        return new Vector(-x, -y);
    }

    private int squared()
    {
        return x * x + y * y;
    }

    int dotProduct(Vector vector)
    {
        return (squared() + vector.squared() - new Vector(vector).sub(this).squared()) / 2;
    }

    double magnitude()
    {
        return Math.sqrt(squared());
    }

    int getX()
    {
        return x;
    }

    int getY()
    {
        return y;
    }

    @Override
    public String toString()
    {
        return String.format("(%s, %s)", x, y);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Vector vector = (Vector) o;

        return x == vector.getX() && y == vector.getY();
    }

    @Override
    public int hashCode()
    {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
