package net.apixelite.subterra.util;

import net.apixelite.subterra.Subterra;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public interface ModEquipmentKeys {
    RegistryKey<EquipmentAsset> ENDERITE = register("enderite");
    RegistryKey<EquipmentAsset> ARAGONITE = register("aragonite");
    RegistryKey<EquipmentAsset> INFERNITE = register("infernite");

    private static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Subterra.MOD_ID, name));
    }
}
