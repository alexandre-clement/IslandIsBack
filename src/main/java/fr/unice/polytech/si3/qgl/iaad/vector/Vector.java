package fr.unice.polytech.si3.qgl.iaad.vector;

/**
 * @author Alexandre Clement
 * @since 10/02/2017.
 */
public interface Vector
{
    Vector add(Vector vector);

    Vector sub(Vector vector);

    Vector mul(Vector vector);

    void setVector(Vector vector);

    int squared();

    double magnitude();

    double distance(Vector vector);

    int dotProduct(Vector vector);

    int getX();

    int getY();
}
