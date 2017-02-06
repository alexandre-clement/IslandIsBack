package fr.unice.polytech.si3.qgl.iaad.format;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public interface Format
{
    Context getContext();

    void setContext(String s);

    Result stringToResult(String s);

    String decisionToString(Decision decision);
}
