package net.apixelite.subterra.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModGeodeGeneration.generateGeodes();

        ModOreGeneration.generateOres();
    }

}
