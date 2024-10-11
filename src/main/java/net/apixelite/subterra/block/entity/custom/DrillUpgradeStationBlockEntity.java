package net.apixelite.subterra.block.entity.custom;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.block.entity.ImplementedInventory;
import net.apixelite.subterra.block.entity.ModBlockEntities;
import net.apixelite.subterra.components.ModDataComponentTypes;
import net.apixelite.subterra.item.ModItems;
import net.apixelite.subterra.item.custom.DrillItem;
import net.apixelite.subterra.screen.custom.DrillUpgradeScreenHandler;
import net.apixelite.subterra.util.ModTags;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

@SuppressWarnings("rawtypes")
public class DrillUpgradeStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(6, ItemStack.EMPTY);

    private static final int DRILL_SLOT = 0;
    private static final int TANK_SLOT = 1;
    private static final int ENGINE_SLOT = 2;
    private static final int UPGRADE_SLOT = 3;
    private static final int FUEL_SLOT = 4;
    private static final int BARREL_SLOT = 5;

    protected final PropertyDelegate propertyDelegate;
    private int hasEngine = 0;
    private int hasTank = 0;
    private int hasUpgrade = 0;
    private int hasFuel = 0;
    private int hasBarrel = 0;

    private boolean drillRemoved = true;
    private boolean engineRemoved = true;
    private boolean tankRemoved = true;
   // private boolean upgradeRemoved = true;



    // Saves the data of the block entity
    public DrillUpgradeStationBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DRILL_UPGRADE_STATION_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch(index) {
                    case 0 -> DrillUpgradeStationBlockEntity.this.hasEngine;
                    case 1 -> DrillUpgradeStationBlockEntity.this.hasTank;
                    case 2 -> DrillUpgradeStationBlockEntity.this.hasUpgrade;
                    case 3 -> DrillUpgradeStationBlockEntity.this.hasFuel;
                    case 4 -> DrillUpgradeStationBlockEntity.this.hasBarrel;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> DrillUpgradeStationBlockEntity.this.hasEngine = value;
                    case 1 -> DrillUpgradeStationBlockEntity.this.hasTank = value;
                    case 2 -> DrillUpgradeStationBlockEntity.this.hasUpgrade = value;
                    case 3 -> DrillUpgradeStationBlockEntity.this.hasFuel = value;
                    case 4 -> DrillUpgradeStationBlockEntity.this.hasBarrel = value;
                }
                
            }

            @Override
            public int size() {
                return 5;
            }
        };
    }

    

    // ???

    // Returns the name of the block entity
    @Override
    public Text getDisplayName() {
        return Text.translatable("drill_upgrade_station");
    }
    
    // Gets the items of the inventory
    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
    
    // Saves the nbt
    @Override
    protected void writeNbt(NbtCompound nbt, WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("drill_upgrade_station.hasEngine", hasEngine);
        nbt.putInt("drill_upgrade_station.hasTank", hasTank);
        nbt.putInt("drill_upgrade_station.hasUpgrade", hasUpgrade);
        nbt.putInt("drill_upgrade_station.hasFuel", hasFuel);
        nbt.putInt("drill_upgrade_station.hasBarrel", hasBarrel);
    }

    // Loads the nbt
    @Override
    public void readNbt(NbtCompound nbt, WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        hasEngine = nbt.getInt("drill_upgrade_station.hasEngine");
        hasTank = nbt.getInt("drill_upgrade_station.hasTank");
        hasUpgrade = nbt.getInt("drill_upgrade_station.hasUpgrade");
        hasFuel = nbt.getInt("drill_upgrade_station.hasFuel");
        hasBarrel = nbt.getInt("drill_upgrade_station.hasBarrel");
    }

    // Creates the gui
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new DrillUpgradeScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    // Gets called every tick
    public void tick(World world, BlockPos pos, BlockState state) {
        // Checks if the world is client
        if (world.isClient()) {
            return;
        }

        ItemStack drill = getStack(DRILL_SLOT);
        ItemStack engine = getStack(ENGINE_SLOT);
        ItemStack tank = getStack(TANK_SLOT);
        ItemStack fuel = getStack(FUEL_SLOT);
        ItemStack barrel = getStack(BARREL_SLOT);

        // Checks if the item in the slot is a drill
        if (drill.isIn(ModTags.Items.DRILL)) {
            moduleRemoved("drill", false);


            // ENGINE
            // Checks if the item has an engine
            if (!hasDrillGotModule("engine", drill)) {
                // Adds the engine if there is one
                if (engine.isIn(ModTags.Items.DRILL_ENGINE)) {
                    setModuleOnDrill("engine", ENGINE_SLOT);
                    markDirty(world, pos, state);
                }
            } 
            // Removes the engine if there is one
            else if (hasDrillGotModule("engine", drill) && !engine.isIn(ModTags.Items.DRILL_ENGINE) && !engineRemoved) {
                removeModuleOffDrill("engine");
                markDirty(world, pos, state);
            }
    

            // FUEL TANK
            // Checks if the item has a fuel tank
            if (!hasDrillGotModule("tank", drill)) {
                // Adds the fuel tank if there is one
                if (tank.isIn(ModTags.Items.FUEL_TANK)) {
                    setModuleOnDrill("tank", TANK_SLOT);
                    Subterra.LOGGER.info("{}", drill.get(ModDataComponentTypes.FUEL).getFuel());
                    markDirty(world, pos, state);
                }
            } 
            // Removes the fuel tank if there is one
            else if (hasDrillGotModule("tank", drill) && !tank.isIn(ModTags.Items.FUEL_TANK) && !tankRemoved) {
                removeModuleOffDrill("tank");
                markDirty(world, pos, state);
            }

            //FUEL
            if (fuel.isOf(ModItems.OIL_BARREL) && barrel.getCount() < ModItems.EMPTY_BARREL.getMaxCount()) {
                if (drill.get(ModDataComponentTypes.FUEL).getFuel() < drill.get(ModDataComponentTypes.FUEL).getMaxFuel()) {
                    addFuelToDrill(drill);
                    putBarrelInSlot();
                    markDirty(world, pos, state);
                }
            }

        } else {
            markDirty(world, pos, state);
        }

        /* Checks if the item is a Drill
         * Check if the item has an engine or fuel tank
         * Adds the engine or fuel tank to the slot
        */
        if (drill.isIn(ModTags.Items.DRILL)) {
            moduleRemoved("drill", false);
            if (hasDrillGotModule("engine", drill)) {
                putModuleInSlot("engine");
                markDirty(world, pos, state);
            }
            if (hasDrillGotModule("tank", drill)) {
                putModuleInSlot("tank");
                markDirty(world, pos, state);
            }
            markDirty(world, pos, state);
        }

        // Makes all slots empty if drill is removed
        if (drill.isEmpty() && !drillRemoved) {
            TagKey[] tagList = {ModTags.Items.DRILL_ENGINE, ModTags.Items.FUEL_TANK};

            for (int i = 1; i <= 2; i++) {
                if (this.getStack(i).isIn(tagList[i - 1])) {
                    this.removeStack(i, 1);
                }
            }
            moduleRemoved("all", true);
        }


    }

    // Puts an empty barrel in the slot
    private void putBarrelInSlot() {
        this.setStack(BARREL_SLOT, new ItemStack(ModItems.EMPTY_BARREL));
        this.removeStack(FUEL_SLOT, 1);
    }

    // Adds the fuel to the drill
    private void addFuelToDrill(ItemStack drill) {
        int maxFuel = drill.get(ModDataComponentTypes.FUEL).getMaxFuel();
        int fuel = drill.get(ModDataComponentTypes.FUEL).getFuel();
        int fuelAddition = 10000;

        if (!(fuel + fuelAddition >= maxFuel)) {
            fuel += fuelAddition;
            DrillItem.editDrillDataComponents(drill, true, fuel, "change_fuel");
        } else {
            fuel = maxFuel;
        }
        DrillItem.editDrillDataComponents(drill, true, fuel, "change_fuel");
    }

    // Sets the module on the drill
    private void setModuleOnDrill(String module, int slot) {
        String name = getStack(slot).getName().getString();
        int level = DrillItem.getModule(name);
        DrillItem.editDrillDataComponents(getStack(DRILL_SLOT), true, level, module);
        DrillItem.addModuleToDrill(module, name);
        moduleRemoved(name, false);
    }

    // Removes the module off the drill
    private void removeModuleOffDrill(String name) {
        DrillItem.editDrillDataComponents(getStack(DRILL_SLOT), false, 0, name);
        if (Objects.equals(name, "tank")) {
            DrillItem.resetFuelCapacity(getStack(DRILL_SLOT));
        }
        moduleRemoved(name, true);
    }

    private void moduleRemoved(String name, boolean value) {
        if (Objects.equals(name, "drill")) {
            drillRemoved = value;
        }
        else if (Objects.equals(name, "engine")) {
            engineRemoved = value;
        } else if (Objects.equals(name, "tank")) {
            tankRemoved = value;
        } else if (Objects.equals(name, "all")) {
            drillRemoved = value;
            engineRemoved = value;
            tankRemoved = value;
            // upgradeRemoved = value;
        }
    }


    // Checks if the drill got a module
    private boolean hasDrillGotModule(String module, ItemStack stack) {
        return DrillItem.hasModule(module, stack);
    }

    // Puts the module in the slot
    private void putModuleInSlot(String module) {

        // Puts engine in the slot
        if (Objects.equals(module, "engine")) {
            moduleRemoved("engine", false);
            int tier = DrillItem.getModule("has_engine");
            switch (tier) {
                case 1 -> this.setStack(ENGINE_SLOT, new ItemStack(ModItems.DRILL_ENGINE_TIER_I));
                case 2 -> this.setStack(ENGINE_SLOT, new ItemStack(ModItems.DRILL_ENGINE_TIER_II));
                case 3 -> this.setStack(ENGINE_SLOT, new ItemStack(ModItems.DRILL_ENGINE_TIER_III));
                case 4 -> this.setStack(ENGINE_SLOT, new ItemStack(ModItems.DRILL_ENGINE_TIER_IV));
                case 5 -> this.setStack(ENGINE_SLOT, new ItemStack(ModItems.DRILL_ENGINE_TIER_V));
                default -> Subterra.LOGGER.info("Failed to change Engine ");
            }
        } 
        // puts the fuel tank in the slot
        else if (Objects.equals(module, "tank")) {
            moduleRemoved("tank", false);
            int tier = DrillItem.getModule("has_tank");
            switch (tier) {
                case 1 -> this.setStack(TANK_SLOT, new ItemStack(ModItems.FUEL_TANK_TIER_I));
                case 2 -> this.setStack(TANK_SLOT, new ItemStack(ModItems.FUEL_TANK_TIER_II));
                case 3 -> this.setStack(TANK_SLOT, new ItemStack(ModItems.FUEL_TANK_TIER_III));
                case 4 -> this.setStack(TANK_SLOT, new ItemStack(ModItems.FUEL_TANK_TIER_IV));
                default -> Subterra.LOGGER.info("Failed to change Tank ");
            }
        }
    }



    @Override
    public Object getScreenOpeningData(ServerPlayerEntity player) {
        return this.pos;
    }
}
