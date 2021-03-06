package fr.unice.polytech.si3.qgl.iaad;

import java.io.File;

import static eu.ace_design.island.runner.Runner.run;

public class Main
{
    private Main()
    {
    }

    public static void main(String[] args) throws Exception
    {

        run(Explorer.class)
                .exploring(new File("map/map05.json"))
                .withSeed(0L)
                .startingAt(159, 159, "WEST")
                .backBefore(30000)
                .withCrew(15)
                .collecting(2, "RUM")
                .collecting(2000, "WOOD")
                .collecting(400,  "QUARTZ")
                .collecting(100,   "FUR")
                .storingInto("./outputs")
                .showReport()
                .fire();
    }
}

