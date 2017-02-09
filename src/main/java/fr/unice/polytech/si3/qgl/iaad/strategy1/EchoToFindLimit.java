package fr.unice.polytech.si3.qgl.iaad.strategy1;

import fr.unice.polytech.si3.qgl.iaad.decisions.Decision;
import fr.unice.polytech.si3.qgl.iaad.decisions.Echo;
import fr.unice.polytech.si3.qgl.iaad.engine.Protocol;
import fr.unice.polytech.si3.qgl.iaad.format.Context;
import fr.unice.polytech.si3.qgl.iaad.format.Result;
import fr.unice.polytech.si3.qgl.iaad.map.Direction;
import fr.unice.polytech.si3.qgl.iaad.map.AerialMap;
import fr.unice.polytech.si3.qgl.iaad.results.EchoResult;

/**
 * @author Alexandre Clement
 * @since 06/02/2017.
 */
class EchoToFindLimit implements Protocol
{
    private final Context context;
    private final AerialMap map;
    private final Direction direction;

    EchoToFindLimit(Context context, AerialMap map, Direction direction)
    {
        this.context = context;
        this.map = map;
        this.direction = direction;
    }

    @Override
    public Decision takeDecision()
    {
        return new Echo(direction);
    }

    @Override
    public Protocol acknowledgeResults(Result result)
    {
        EchoResult echoResult = new EchoResult(result);
        Direction heading = map.getDrone().getHeading();

        map.increase(direction, echoResult.getRange());

        if (heading.getRight() == direction)
            return new EchoToFindLimit(context, map, direction.getBack());

        boolean keepDirection = map.getRange(direction) > map.getRange(direction.getBack());
        Direction newHeading = keepDirection ? direction : direction.getBack();
        return new Turn(new ScanMap(context, map, heading), map, newHeading);
    }
}
