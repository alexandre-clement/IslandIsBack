package fr.unice.polytech.si3.qgl.iaad.aerial;

import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
abstract class Aerial implements Protocol
{

    private final Context context;

    Aerial(Context context)
    {
        this.context = context;
    }

    Context getContext()
    {
        return context;
    }
}
