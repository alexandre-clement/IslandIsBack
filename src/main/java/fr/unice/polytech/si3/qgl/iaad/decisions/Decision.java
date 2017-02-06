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

    Actions getActions()
    {
        return actions;
    }

    public abstract JSONObject toJson();
}
