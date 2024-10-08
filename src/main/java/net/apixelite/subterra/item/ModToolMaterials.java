package net.apixelite.subterra.item;

import com.google.common.base.Suppliers;
import net.apixelite.subterra.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial{

    ENDERITE(4062, 12.0f, 5, 25, ModTags.Blocks.INCORRECT_FOR_ENDERITE_TOOL, () -> Ingredient.ofItems(ModItems.ENDERITE_INGOT)),
    ARAGONITE(6093, 15.0f, 6, 35, ModTags.Blocks.INCORRECT_FOR_ARAGONITE_TOOL, () -> Ingredient.ofItems(ModItems.ARAGONITE_INGOT)),
    INFERNITE(10155, 22.0f, 7, 52, ModTags.Blocks.INCORRECT_FOR_INFERNITE_TOOL, () -> Ingredient.ofItems(ModItems.INFERNITE_INGOT)),
    DRILL_MATERIAL(0, 12.5f, 6.5f, 25, ModTags.Blocks.INCORRECT_FOR_DRILL_TOOL, () -> Ingredient.ofItems(Items.PRISMARINE_CRYSTALS));

    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final TagKey<Block> inverseTag;
    private final Supplier<Ingredient> repairIngredient;

    private ModToolMaterials(int itemDurability, float miningSpeed, float attackDamage,
            int enchantability, TagKey<Block> inverseTag, Supplier<Ingredient> repairIngredient) {
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.inverseTag = inverseTag;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

}
