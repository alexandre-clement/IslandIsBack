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
                .exploring(new File("map/map1553.json"))
                .withSeed(0L)
                .startingAt(1, 1, "EAST")
                .backBefore(30000)
                .withCrew(15)
                .collecting(1000, "FISH")
                .collecting(20, "FLOWER")
                .collecting(5, "FRUITS")
                .collecting(500, "FUR")
                .collecting(100, "ORE")
                .collecting(200, "QUARTZ")
                .collecting(50, "SUGAR_CANE")
                .collecting(2000, "WOOD")
                .collecting(10, "GLASS")
                .collecting(15, "INGOT")
                .collecting(5, "LEATHER")
                .collecting(1000, "PLANK")
                .collecting(2, "RUM")
                .storingInto("./outputs")
                .showReport()
                .fire();
    }
}

