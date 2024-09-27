package net.apixelite.subterra.item;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import net.apixelite.subterra.Subterra;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> ENDERITE_ARMOR_MATERIAL = registerArmorMaterial("enderite",
        () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                    map.put(ArmorItem.Type.BOOTS, 7);
                    map.put(ArmorItem.Type.LEGGINGS, 10);
                    map.put(ArmorItem.Type.CHESTPLATE, 13);
                    map.put(ArmorItem.Type.HELMET, 7);
                    map.put(ArmorItem.Type.BODY, 12);
                }), 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.ENDERITE_INGOT),
                List.of(new ArmorMaterial.Layer(Identifier.of(Subterra.MOD_ID, "enderite"))), 8, 0.3f));
                
    public static final RegistryEntry<ArmorMaterial> ARAGONITE_ARMOR_MATERIAL = registerArmorMaterial("aragonite",
        () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                    map.put(ArmorItem.Type.BOOTS, 13);
                    map.put(ArmorItem.Type.LEGGINGS, 20);
                    map.put(ArmorItem.Type.CHESTPLATE, 26);
                    map.put(ArmorItem.Type.HELMET, 13);
                    map.put(ArmorItem.Type.BODY, 24);
                }), 35, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.ARAGONITE_INGOT),
                List.of(new ArmorMaterial.Layer(Identifier.of(Subterra.MOD_ID, "aragonite"))), 15, 0.7f));

    public static final RegistryEntry<ArmorMaterial> INFERNITE_ARMOR_MATERIAL = registerArmorMaterial("infernite",
        () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                    map.put(ArmorItem.Type.BOOTS, 21);
                    map.put(ArmorItem.Type.LEGGINGS, 30);
                    map.put(ArmorItem.Type.CHESTPLATE, 39);
                    map.put(ArmorItem.Type.HELMET, 23);
                    map.put(ArmorItem.Type.BODY, 36);
                }), 52, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.INFERNITE_INGOT),
                List.of(new ArmorMaterial.Layer(Identifier.of(Subterra.MOD_ID, "infernite"))), 22, 1.0f));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Subterra.MOD_ID, name), material.get());
    }
}