package fr.unice.polytech.si3.qgl.iaad.resource;

import fr.unice.polytech.si3.qgl.iaad.contract.Contract;
import fr.unice.polytech.si3.qgl.iaad.contract.SimpleContract;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexandre Clement
 * @since 11/02/2017.
 */
public class SimpleBasketTest

{

    @Test
    public void contains() throws Exception
    {
        Basket basket = new SimpleBasket();
        basket.add(Resource.SUGAR_CANE, 20);
        basket.add(Resource.FRUITS, 5);

        Contract contract = new SimpleContract(Resource.RUM, 1);

        assertTrue(basket.contains(contract.getReagentResources()));
    }
}