package fr.unice.polytech.si3.qgl.iaad.format;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public interface Format
{
    void setContext(String s);

    Context getContext();

    Result stringToResult(String s);

    String decisionToString(Decision decision);
}
