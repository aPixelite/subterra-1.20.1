package net.apixelite.subterra.block.entity;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.item.ModItems;
import net.apixelite.subterra.item.custom.DrillItem;
import net.apixelite.subterra.screen.DrillUpgradeScreenHandler;
import net.apixelite.subterra.util.ModTags;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DrillUpgradeStationBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    private static final int DRILL_SLOT = 0;
    private static final int ENGINE_SLOT = 1;
    private static final int UPGRADE_SLOT = 2;
    private static final int TANK_SLOT = 3;

    protected final PropertyDelegate propertyDelegate;
    private int hasEngine = 0;
    private int hasTank = 0;
    private int hasUpgrade = 0;

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
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> DrillUpgradeStationBlockEntity.this.hasEngine = value;
                    case 1 -> DrillUpgradeStationBlockEntity.this.hasTank = value;
                    case 2 -> DrillUpgradeStationBlockEntity.this.hasUpgrade = value;
                }
                
            }

            @Override
            public int size() {
                return 3;
            }
        };
    }
    
    // ???
    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

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
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("drill_upgrade_station.hasEnigne", hasEngine);
        nbt.putInt("drill_upgrade_station.hasTank", hasTank);
        nbt.putInt("drill_upgrade_station.hasUpgrade", hasUpgrade);
    }

    // Loads the nbt
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        hasEngine = nbt.getInt("drill_upgrade_station.hasEngine");
        hasTank = nbt.getInt("drill_upgrade_station.hasTank");
        hasUpgrade = nbt.getInt("drill_upgrade_station.hasUpgrade");
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

        // Checks if the item in the slot is a drill
        if (drill.isIn(ModTags.Items.DRILL)) {
            moduleRemoved("drill", false);

            // Checks if the item has a engine
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
    
    
            // Checks if the item has a fuel tank
            if (!hasDrillGotModule("tank", drill)) {
                // Adds the fuel tank if there is one
                if (tank.isIn(ModTags.Items.FUEL_TANK)) {
                    setModuleOnDrill("tank", TANK_SLOT);
                    Subterra.LOGGER.info("" + drill.getNbt().getInt("subterra.fuel"));
                    markDirty(world, pos, state);
                }
            } 
            // Removes the fuel tank if there is one
            else if (hasDrillGotModule("tank", drill) && !tank.isIn(ModTags.Items.FUEL_TANK) && !tankRemoved) {
                removeModuleOffDrill("tank");
                markDirty(world, pos, state);
            }
        } else {
            markDirty(world, pos, state);
        }

        /* Checks if the item is a Drill
         * Check if the item has a engine or fuel tank
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
            this.removeStack(ENGINE_SLOT, 1);
            this.removeStack(TANK_SLOT, 1);
            this.removeStack(UPGRADE_SLOT, 1);
            moduleRemoved("all", true);
        }


    }

    // Sets the module on the drill
    private void setModuleOnDrill(String module, int slot) {
        String name = getStack(slot).getName().getString();
        int level = DrillItem.getModule(name);
        DrillItem.editNbtData(getStack(DRILL_SLOT), true, level, module, name);
        DrillItem.addModuleToDrill(module, name, getStack(slot));
        moduleRemoved(name, false);
    }

    // Removes the module off the drill
    private void removeModuleOffDrill(String name) {
        DrillItem.editNbtData(getStack(DRILL_SLOT), false, 0, name, "");
        if (name == "tank") {
            DrillItem.resetFuelCapacity(getStack(DRILL_SLOT));
        }
        moduleRemoved(name, true);
    }

    private void moduleRemoved(String name, boolean value) {
        if (name == "drill") {
            drillRemoved = value;
        }
        else if (name == "engine") {
            engineRemoved = value;
        } else if (name == "tank") {
            tankRemoved = value;
        } else if (name == "all") {
            drillRemoved = value;
            engineRemoved = value;
            tankRemoved = value;
            // upgradeRemoved = value;
        }
    }



    // Checks if the slot is empty
    public boolean slotEmpty(int slot) {
        return this.getStack(slot).isEmpty();
    }

    // Checks if the drill got a module
    private boolean hasDrillGotModule(String module, ItemStack stack) {
        return DrillItem.hasModule(module, stack);
    }

    // Puts the module in the slot
    private void putModuleInSlot(String module) {

        // Puts engine in the slot
        if (module == "engine") {
            moduleRemoved("engine", false);
            int item = DrillItem.getModule("has_engine");
            switch (item) {
                case 1 -> this.setStack(ENGINE_SLOT, new ItemStack(ModItems.DRILL_ENGINE_TIER_I));
                case 2 -> this.setStack(ENGINE_SLOT, new ItemStack(ModItems.DRILL_ENGINE_TIER_II));
                case 3 -> this.setStack(ENGINE_SLOT, new ItemStack(ModItems.DRILL_ENGINE_TIER_III));
                case 4 -> this.setStack(ENGINE_SLOT, new ItemStack(ModItems.DRILL_ENGINE_TIER_IV));
                case 5 -> this.setStack(ENGINE_SLOT, new ItemStack(ModItems.DRILL_ENGINE_TIER_V));
                default -> Subterra.LOGGER.info("Failed to change Engine ");
            }
        } 
        // puts the fuel tank in the slot
        else if (module == "tank") {
            moduleRemoved("tank", false);
            int item = DrillItem.getModule("has_tank");
            switch (item) {
                case 1 -> this.setStack(TANK_SLOT, new ItemStack(ModItems.FUEL_TANK_TIER_I));
                case 2 -> this.setStack(TANK_SLOT, new ItemStack(ModItems.FUEL_TANK_TIER_II));
                case 3 -> this.setStack(TANK_SLOT, new ItemStack(ModItems.FUEL_TANK_TIER_III));
                case 4 -> this.setStack(TANK_SLOT, new ItemStack(ModItems.FUEL_TANK_TIER_IV));
                default -> Subterra.LOGGER.info("Failed to change Tank ");
            }
        }
    }

}
