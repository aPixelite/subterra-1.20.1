package net.apixelite.subterra.item.custom;

import java.util.*;

import net.apixelite.subterra.components.custom.*;
import net.apixelite.subterra.util.ModTags;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.components.ModDataComponentTypes;
import net.apixelite.subterra.util.CustomRarity;
import net.apixelite.subterra.util.tooltip.DrillItemTooltip;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class DrillItem extends PickaxeItem {


    private final float attackDamage;
    private final float attackSpeed;
    private final float baseMiningSpeed;
    public final CustomRarity rarity;

    private boolean abilityActive;

    public static final String upgrade = "";

    private int stopperInt = 0;
    private int i = 0; 
    private int j = 0;

    private static int engineTier = 0;
    private static int tankTier = 0;
    private static int upgradeTier = 0;
    private static int fuel = 3000;
    private static int maxFuel = 3000;
    private static int miningSpeed = 0;

    Timer timer = new Timer();

    private static EngineData engineData = new EngineData(false, engineTier);
    private static TankData tankData = new TankData(false, tankTier);
    private static UpgradeData upgradeData = new UpgradeData(false, upgradeTier);
    private static FuelData fuelData = new FuelData(fuel, maxFuel);
    private static MiningSpeedData miningSpeedData = new MiningSpeedData(miningSpeed);

    private static final UnbreakableComponent unbreakableComponent = new UnbreakableComponent(true).withShowInTooltip(false);


    public DrillItem(ToolMaterial material, float miningSpeed, int attackDamage, float attackSpeed, CustomRarity rarity, Settings settings) {
        super(material, attackDamage, attackSpeed, settings
                .component(ModDataComponentTypes.ENGINE, engineData)
                .component(ModDataComponentTypes.TANK, tankData)
                .component(ModDataComponentTypes.UPGRADE, upgradeData)
                .component(ModDataComponentTypes.FUEL, fuelData)
                .component(ModDataComponentTypes.MINING_SPEED, miningSpeedData)
                .component(DataComponentTypes.UNBREAKABLE, unbreakableComponent));
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.baseMiningSpeed = miningSpeed;
        this.rarity = rarity;
    }


// DATA COMPONENTS
    // Edits the Data Components of the drill
    public static void editDrillDataComponents(ItemStack item, int level, @NotNull String module) {
        switch (module) {
            case "fuel":
                maxFuel = level;
                fuel = level;
                fuelData = new FuelData(fuel, maxFuel);
                item.set(ModDataComponentTypes.FUEL, fuelData);
                break;
            case "change_fuel":
                fuel = level;
                fuelData = new FuelData(fuel, maxFuel);
                item.set(ModDataComponentTypes.FUEL, fuelData);
                break;
            case "speed":
                miningSpeed = level;
                item.set(ModDataComponentTypes.MINING_SPEED, miningSpeedData);
                miningSpeedData = new MiningSpeedData(miningSpeed);
                break;
            default:
                break;
        }
    }

    public static void editDrillDataComponents(ItemStack item, boolean value, int level,  @NotNull String module) {
        switch (module) {
            case "engine":
                engineTier = level;
                miningSpeed = getMiningSpeedAddition(level);
                engineData = new EngineData(value, engineTier);
                item.set(ModDataComponentTypes.ENGINE, engineData);
                break;
            case "tank":
                tankTier = level;
                maxFuel = getTankFuel(level);
                fuel = maxFuel;
                tankData = new TankData(value, tankTier);
                fuelData = new FuelData(fuel, maxFuel);
                item.set(ModDataComponentTypes.TANK, tankData);
                item.set(ModDataComponentTypes.FUEL, fuelData);
                break;
            case "upgrade":
                upgradeTier = level;
                upgradeData = new UpgradeData(value, upgradeTier);
                item.set(ModDataComponentTypes.UPGRADE, upgradeData);
                break;
            default:
                break;
        }
    }

// ABILITY FUNCTIONS
    // the Pickaxe Ability
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        if (stopperInt == 0) {
            stopperInt++;
            abilityActive = true;
            player.getItemCooldownManager().set(this.getDefaultStack(), 2400);
            player.sendMessage(Text.literal("§7§lAbility Activated!"), false);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    abilityActive = false;
                    player.sendMessage(Text.literal("§cAbility Deactivated!"), false);
                    stopperInt--;
                }
            }, 20000);
        }
        return super.use(world, player, hand);
    }

 

// SET TOOLTIP FUNCTION
    // changes the tooltip of the item
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.clear();
        setFuel(stack);
        setMiningSpeed(stack);

        DrillItemTooltip.setTooltip(this, stack, tooltip);

        super.appendTooltip(stack, context, tooltip, type);
    }



// MODULE FUNCTIONS
    // returns the module installed
    public static int getModule(ItemStack stack, String mod) {

        if (stack.isIn(ModTags.Items.DRILL_ENGINE) || Objects.equals(mod, "engine")) {
            return engineTier;
        } else if (stack.isIn(ModTags.Items.FUEL_TANK) || Objects.equals(mod, "tank")) {
            return tankTier;
        } else if (stack.isIn(ModTags.Items.UPGRADE) || Objects.equals(mod, "upgrade")) {
            return upgradeTier;
        } else {
            Subterra.LOGGER.info("Failed at function getModule() {line 184}");
            return 0;
        }
    }
    
    // checks if the item has a module installed
    public static boolean hasModule(String module, ItemStack stack) {

        return switch (module) {
            // Checks engine
            case "engine" -> getEngineTier(stack) > 0;

            // Checks fuel tank
            case "tank" -> getTankTier(stack) > 0;

            // Checks upgrade module
            case "upgrade" -> getUpgradeTier(stack) > 0;

            // Default Case
            case null, default -> false;
        };
        
    }

    // adds a module to the item
    public static void addModuleToDrill(String module, String name) {
        String[] itemName = name.split(" ");
        int level = Integer.parseInt(itemName[3]);
        
        // Adds an engine to the item
        if (Objects.equals(module, "engine")) {
            engineTier = level;
        } 
        // Adds a tank to the item
        else if (Objects.equals(module, "tank")) {
            tankTier = level;
        }
        // Adds an upgrade to the item
        else if (Objects.equals(module, "upgrade")) {
            upgradeTier = level;
        }
    }



// MINING SPEED FUNCTIONS
    public static int getMiningSpeedAddition(int level) {
        return DrillEngine.getMiningSpeed(level);
    }



// FUEL FUNCTIONS   
    // sets the fuel to the new max fuel
    public static int getTankFuel(int level) {
        return FuelTank.getFuel(level);
    }
    
    // resets the fuel to the base value
    public static void resetFuelCapacity(ItemStack stack) {
        int fuel = getFuel(stack);
        editDrillDataComponents(stack, 3000, "fuel");
        if (fuel >= 3000) {
            editDrillDataComponents(stack, fuel, "change_fuel");
        }
    }
    
    // sets the fuel
    private void setFuel(ItemStack stack) {
        while (i < 1) {
            editDrillDataComponents(stack, 3000, "fuel");
            i++;
        }
    }

    private void setMiningSpeed(ItemStack stack) {
        while(j < 1) {
            editDrillDataComponents(stack, 0, "speed");
            j++;
        }
    }

    public static int getFuel(ItemStack stack) {
        return stack.get(ModDataComponentTypes.FUEL).getFuel();
    }

    public static int getMaxFuel(ItemStack stack) {
        return stack.get(ModDataComponentTypes.FUEL).getMaxFuel();
    }

    public static int getTankTier(ItemStack stack) {
        return stack.get(ModDataComponentTypes.TANK).getTankTier();
    }

    public static int getEngineTier(ItemStack stack) {
        return stack.get(ModDataComponentTypes.ENGINE).getEngineTier();
    }

    public static int getMiningSpeed(ItemStack stack) {
        return stack.get(ModDataComponentTypes.MINING_SPEED).getMiningSpeed();
    }

    public static int getUpgradeTier(ItemStack stack) {
        return stack.get(ModDataComponentTypes.UPGRADE).getLevel();
    }



// BASIC FUNCTIONS
    // removes fuel after player mined a block
    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        int newFuel = getFuel(stack) - 1;
        editDrillDataComponents(stack, newFuel, "change_fuel");
        return super.postMine(stack, world, state, pos, miner);
    }
    
    // check if the player has enough fuel to mine
    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        ItemStack stack = miner.getEquippedStack(EquipmentSlot.MAINHAND);
        return getFuel(stack) > 0;
    }

    // required functions
    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        float miningSpeed = this.baseMiningSpeed + getMiningSpeed(stack);
        if (abilityActive) {
            return miningSpeed * 3;
        } else {
            return miningSpeed;
        }
    }
    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);
        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            if(blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y));
                    }
                }
            }

            if(blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ()));
                    }
                }
            }

            if(blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                    }
                }
            }
        }

        return positions;
    }
}
