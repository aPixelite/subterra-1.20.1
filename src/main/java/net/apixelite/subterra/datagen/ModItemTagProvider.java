package net.apixelite.subterra.datagen;

import java.util.concurrent.CompletableFuture;

import net.apixelite.subterra.item.ModItems;
import net.apixelite.subterra.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.ItemTags;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider{

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.ENDERITE_SHOVEL)
                .add(ModItems.ENDERITE_PICKAXE)
                .add(ModItems.ENDERITE_AXE)
                .add(ModItems.ENDERITE_HOE)
                .add(ModItems.ARAGONITE_SHOVEL)
                .add(ModItems.ARAGONITE_PICKAXE)
                .add(ModItems.ARAGONITE_AXE)
                .add(ModItems.ARAGONITE_HOE)
                .add(ModItems.INFERNITE_SHOVEL)
                .add(ModItems.INFERNITE_PICKAXE)
                .add(ModItems.INFERNITE_AXE)
                .add(ModItems.INFERNITE_HOE)
                .add(ModItems.DIAMOND_DRILL)
                .add(ModItems.NETHERITE_DRILL)
                .add(ModItems.ENDERITE_DRILL)
                .add(ModItems.ARAGONITE_DRILL)
                .add(ModItems.INFERNITE_DRILL);

        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.ENDERITE_SHOVEL)
                .add(ModItems.ENDERITE_PICKAXE)
                .add(ModItems.ENDERITE_AXE)
                .add(ModItems.ENDERITE_HOE)
                .add(ModItems.ARAGONITE_SHOVEL)
                .add(ModItems.ARAGONITE_PICKAXE)
                .add(ModItems.ARAGONITE_AXE)
                .add(ModItems.ARAGONITE_HOE)
                .add(ModItems.INFERNITE_SHOVEL)
                .add(ModItems.INFERNITE_PICKAXE)
                .add(ModItems.INFERNITE_AXE)
                .add(ModItems.INFERNITE_HOE)
                .add(ModItems.DIAMOND_DRILL)
                .add(ModItems.NETHERITE_DRILL)
                .add(ModItems.ENDERITE_DRILL)
                .add(ModItems.ARAGONITE_DRILL)
                .add(ModItems.INFERNITE_DRILL);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.ENDERITE_SHOVEL)
                .add(ModItems.ENDERITE_PICKAXE)
                .add(ModItems.ENDERITE_AXE)
                .add(ModItems.ENDERITE_HOE)
                .add(ModItems.ARAGONITE_SHOVEL)
                .add(ModItems.ARAGONITE_PICKAXE)
                .add(ModItems.ARAGONITE_AXE)
                .add(ModItems.ARAGONITE_HOE)
                .add(ModItems.INFERNITE_SHOVEL)
                .add(ModItems.INFERNITE_PICKAXE)
                .add(ModItems.INFERNITE_AXE)
                .add(ModItems.INFERNITE_HOE);


        getOrCreateTagBuilder(ModTags.Items.ENDERITE_REPAIR)
            .add(ModItems.ENDERITE_INGOT);

        getOrCreateTagBuilder(ModTags.Items.ARAGONITE_REPAIR)
            .add(ModItems.ARAGONITE_INGOT);

        getOrCreateTagBuilder(ModTags.Items.INFERNITE_REPAIR)
            .add(ModItems.INFERNITE_INGOT);

        getOrCreateTagBuilder(ModTags.Items.DRILL_REPAIR)
            .add(Items.PRISMARINE_CRYSTALS);

        getOrCreateTagBuilder(ModTags.Items.DRILL)
            .add(ModItems.DIAMOND_DRILL)
            .add(ModItems.NETHERITE_DRILL)
            .add(ModItems.ENDERITE_DRILL)
            .add(ModItems.ARAGONITE_DRILL)
            .add(ModItems.INFERNITE_DRILL);

        getOrCreateTagBuilder(ModTags.Items.DRILL_ENGINE)
            .add(ModItems.DRILL_ENGINE_TIER_I)
            .add(ModItems.DRILL_ENGINE_TIER_II)
            .add(ModItems.DRILL_ENGINE_TIER_III)
            .add(ModItems.DRILL_ENGINE_TIER_IV)
            .add(ModItems.DRILL_ENGINE_TIER_V);

        getOrCreateTagBuilder(ModTags.Items.FUEL_TANK)
            .add(ModItems.FUEL_TANK_TIER_I)
            .add(ModItems.FUEL_TANK_TIER_II)
            .add(ModItems.FUEL_TANK_TIER_III)
            .add(ModItems.FUEL_TANK_TIER_IV);

        getOrCreateTagBuilder(ModTags.Items.MULTI_MINE)
            .add(ModItems.MULTI_MINE_TIER_I)
            .add(ModItems.MULTI_MINE_TIER_II)
            .add(ModItems.MULTI_MINE_TIER_III);

        getOrCreateTagBuilder(ModTags.Items.UPGRADE)
            .addTag(ModTags.Items.MULTI_MINE);
    }

}
