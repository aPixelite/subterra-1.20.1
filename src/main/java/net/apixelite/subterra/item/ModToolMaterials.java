package net.apixelite.subterra.item;

import net.apixelite.subterra.util.ModTags;
import net.minecraft.item.ToolMaterial;

public class ModToolMaterials {
    public static final ToolMaterial ENDERITE = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_ENDERITE_TOOL, // Incorrect for these blocks
            4062,   // Durability
            12.0f,  // Mining Speed
            5,      // Bonus Attack Damage
            25,     // Enchantability
            ModTags.Items.ENDERITE_REPAIR); // Repair Ingredient

    public static final ToolMaterial ARAGONITE = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_ARAGONITE_TOOL, 6093, 15.0f, 6, 35, ModTags.Items.ARAGONITE_REPAIR);

    public static final ToolMaterial INFERNITE = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_INFERNITE_TOOL, 10155, 22.0f, 7, 52, ModTags.Items.INFERNITE_REPAIR);

    public static final ToolMaterial DRILL_MATERIAL = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_DRILL_TOOL, 0, 12.5f, 6.5f, 25, ModTags.Items.DRILL_REPAIR);

}
