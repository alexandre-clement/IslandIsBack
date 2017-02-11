package fr.unice.polytech.si3.qgl.iaad.decisions;

import org.json.JSONObject;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public abstract class Decision
{
    private final Actions actions;

    Decision(Actions actions)
    {
        this.actions = actions;
    }

    public Actions getActions()
    {
        return actions;
    }

    public abstract JSONObject toJson();

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Decision decision = (Decision) o;

        return actions == decision.actions;
    }

    @Override
    public int hashCode()
    {
        return actions.hashCode();
    }
}
