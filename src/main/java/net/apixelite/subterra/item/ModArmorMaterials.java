package net.apixelite.subterra.item;

import java.util.EnumMap;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModArmorMaterials {

    public static final ArmorMaterial ENDERITE_ARMOR_MATERIAL = new ArmorMaterial(25, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                    map.put(EquipmentType.BOOTS, 7);
                    map.put(EquipmentType.LEGGINGS, 10);
                    map.put(EquipmentType.CHESTPLATE, 13);
                    map.put(EquipmentType.HELMET, 7);
                    map.put(EquipmentType.BODY, 12);
                }), 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 8, 0.3f, ModTags.Items.ENDERITE_REPAIR,
                Identifier.of(Subterra.MOD_ID, "enderite"));

    public static final ArmorMaterial ARAGONITE_ARMOR_MATERIAL = new ArmorMaterial(35, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                    map.put(EquipmentType.BOOTS, 13);
                    map.put(EquipmentType.LEGGINGS, 20);
                    map.put(EquipmentType.CHESTPLATE, 26);
                    map.put(EquipmentType.HELMET, 13);
                    map.put(EquipmentType.BODY, 24);
                }), 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 15, 0.7f, ModTags.Items.ARAGONITE_REPAIR,
                Identifier.of(Subterra.MOD_ID, "aragonite"));

    public static final ArmorMaterial INFERNITE_ARMOR_MATERIAL = new ArmorMaterial(52, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                    map.put(EquipmentType.BOOTS, 21);
                    map.put(EquipmentType.LEGGINGS, 30);
                    map.put(EquipmentType.CHESTPLATE, 39);
                    map.put(EquipmentType.HELMET, 23);
                    map.put(EquipmentType.BODY, 36);
                }), 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 22, 1.0f, ModTags.Items.INFERNITE_REPAIR,
                Identifier.of(Subterra.MOD_ID, "infernite"));
}