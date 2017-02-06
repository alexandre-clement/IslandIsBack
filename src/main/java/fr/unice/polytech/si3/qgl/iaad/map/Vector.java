package fr.unice.polytech.si3.qgl.iaad.map;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
public class Vector
{
    private static final String DIMENSION_DISAGREE = "dimensions disagree";
    private final int[] coordinates;

    Vector(int... coordinates)
    {
        this.coordinates = coordinates;
    }

    void add(Vector vector)
    {
        if (coordinates.length != vector.coordinates.length)
            throw new IllegalArgumentException();

        for (int i = 0; i < coordinates.length; i++)
            coordinates[i] += vector.coordinates[i];
    }

    void set(int coordinate, int value)
    {
        coordinates[coordinate] = value;
    }

    int get(int coordinate)
    {
        return coordinates[coordinate];
    }

    void add(int coordinate, int value)
    {
        set(coordinate, get(coordinate) + value);
    }

    int scalarProduct(Vector vector)
    {
        if (coordinates.length != vector.coordinates.length)
            throw new IllegalArgumentException(DIMENSION_DISAGREE);

        int scalar = 0;
        for (int i = 0; i < coordinates.length; i++)
        {
            scalar += coordinates[i] * vector.coordinates[i];
        }
        return scalar;
    }

    Vector vectorProduct(Vector vector)
    {
        if (coordinates.length != vector.coordinates.length)
            throw new IllegalArgumentException(DIMENSION_DISAGREE);

        int[] product = new int[coordinates.length];
        for (int i = 0; i < coordinates.length; i++)
        {
            product[i] = coordinates[i] * vector.coordinates[i];
        }
        return new Vector(product);
    }

    Vector abs()
    {
        int[] abs = new int[coordinates.length];
        for (int i = 0; i < coordinates.length; i++)
        {
            abs[i] = Math.abs(coordinates[i]);
        }
        return new Vector(abs);
    }

    int addingTheComponents()
    {
        int reduced = 0;
        for (int coordinate : coordinates)
        {
            reduced += coordinate;
        }
        return reduced;
    }

    int multiplyTheComponents()
    {
        int reduced = 1;
        for (int coordinate : coordinates)
        {
            reduced *= coordinate;
        }
        return reduced;
    }

    int distance(Vector vector)
    {
        if (coordinates.length != vector.coordinates.length)
            throw new IllegalArgumentException(DIMENSION_DISAGREE);

        int distance = 0;
        for (int i = 0; i < coordinates.length; i++)
        {
            distance += coordinates[i] - vector.coordinates[i];
        }
        return distance;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder("(");
        for (int coordinate : coordinates)
        {
            stringBuilder.append(coordinate).append(", ");
        }
        return stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), ")").toString();
    }
}
