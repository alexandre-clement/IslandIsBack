package fr.unice.polytech.si3.qgl.iaad.format;

import fr.unice.polytech.si3.qgl.iaad.contract.Contract;
import fr.unice.polytech.si3.qgl.iaad.map.Board;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;

import java.util.List;

/**
 * @author Alexandre Clement
 * @since 05/02/2017.
 */
public interface Context
{
    Direction getHeading();

    int getBudget();

    Board getBoard();

    int getMen();

    List<Contract> getContracts();
}
