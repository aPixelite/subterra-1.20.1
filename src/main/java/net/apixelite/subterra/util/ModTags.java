package net.apixelite.subterra.util;

import net.apixelite.subterra.Subterra;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ENDERITE_TOOL = createTag("needs_enderite_tool");
        public static final TagKey<Block> NEEDS_ARAGONITE_TOOL = createTag("needs_aragonite_tool");
        public static final TagKey<Block> NEEDS_INFERNITE_TOOL = createTag("needs_infernite_tool");
        public static final TagKey<Block> NEEDS_DRILL_TOOL = createTag("needs_drill_tool");
        public static final TagKey<Block> INCORRECT_FOR_ENDERITE_TOOL = createTag("incorrect_for_enderite_tool");
        public static final TagKey<Block> INCORRECT_FOR_ARAGONITE_TOOL = createTag("incorrect_for_aragonite_tool");
        public static final TagKey<Block> INCORRECT_FOR_INFERNITE_TOOL = createTag("incorrect_for_infernite_tool");
        public static final TagKey<Block> INCORRECT_FOR_DRILL_TOOL = createTag("incorrect_for_drill_tool");

        
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Subterra.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DRILL = createTag("drill");
        public static final TagKey<Item> DRILL_ENGINE = createTag("drill_engine");
        public static final TagKey<Item> FUEL_TANK = createTag("fuel_tank");

        public static final TagKey<Item> HAS_ENGINE = createTag("has_engine");
        public static final TagKey<Item> HAS_UPGRADE = createTag("has_upgrade");
        public static final TagKey<Item> HAS_TANK = createTag("has_tank");
        
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, name));
        }
    }

}
