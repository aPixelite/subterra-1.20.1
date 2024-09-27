package net.apixelite.subterra.item.custom;

import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import net.apixelite.subterra.util.romannumeralconverter.RomanNumeralConverter;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.components.ModDataComponentTypes;
import net.apixelite.subterra.components.custom.EngineData;
import net.apixelite.subterra.components.custom.FuelData;
import net.apixelite.subterra.components.custom.MiningSpeedData;
import net.apixelite.subterra.components.custom.TankData;
import net.apixelite.subterra.util.CustomRarity;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class DrillItem extends PickaxeItem {

    private final float attackDamage;
    private final float attackSpeed;
    private final float baseMiningSpeed;
    private final CustomRarity rarity;

    private boolean abilityActive;

    private static final String upgrade = "";

    private static final boolean hasUpgrade = false;

    private static int engineTier = 0;
    private static int tankTier = 0;
    // private static int drillHasUpgrade = 0;

    private int stopperInt = 0;
    private int i = 0; 
    private int j = 0;

    
    private static boolean hasEngine = false;
    private static boolean hasTank = false;
    // private boolean hasNbtUpgrade = false;
    private static int fuel = 3000;
    private static int maxFuel = 3000;
    private static int miningSpeed = 0;

    Timer timer = new Timer();

    public DrillItem(ToolMaterial material, float miningSpeed, int attackDamage, float attackSpeed, CustomRarity rarity, Settings settings) {
        super(material, settings);
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.baseMiningSpeed = miningSpeed;
        this.rarity = rarity;
    }


// DATA COMPONENTS
    // Edits the Data Components of the drill
    public static void editDrillDataComponents(ItemStack item, boolean value, int level, @NotNull String module) {
        switch (module) {
            case "engine":
                hasEngine = value;
                engineTier = level;
                miningSpeed = getMiningSpeedAddition(level);
                break;
            case "tank":
                hasTank = value;
                tankTier = level;
                maxFuel = getTankFuel(level);
                fuel = maxFuel;
                break;
            case "fuel":
                maxFuel = level;
                fuel = level;
                break;
            case "decrease_fuel":
                fuel = level;
                break;
            case "speed":
                miningSpeed = level;
                break;
            default:
                break;
        }

        EngineData engineData = new EngineData(hasEngine, engineTier);
        TankData tankData = new TankData(hasTank, tankTier);
        FuelData fuelData = new FuelData(fuel, maxFuel);
        MiningSpeedData miningSpeedData = new MiningSpeedData(miningSpeed);

        item.set(ModDataComponentTypes.ENGINE, engineData);
        item.set(ModDataComponentTypes.TANK, tankData);
        item.set(ModDataComponentTypes.FUEL, fuelData);
        item.set(ModDataComponentTypes.MINING_SPEED, miningSpeedData);
    }


// ABILITY FUNCTIONS
    // the Pickaxe Ability
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (stopperInt == 0) {
            stopperInt++;
            abilityActive = true;
            player.getItemCooldownManager().set(this, 2400);
            player.sendMessage(Text.translatable("§7§lAbility Activated!"));
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    abilityActive = false;
                    player.sendMessage(Text.translatable("§cAbility Deactivated!"));
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

        // Stats of the item
        tooltip.add(Text.empty().append(this.getName()).formatted(this.rarity.formatting));
        tooltip.add(Text.literal("§8Mining level 8"));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal("§7Damage: §c" + ((int) this.attackDamage)));
        tooltip.add(Text.literal("§7Mining speed: §a" + ((int) getMiningSpeed(stack, null))));
        // TO DO: tooltip.add(Text.literal("§7Mining fortune: §a"));

        // The enchantments
        if(stack.hasEnchantments()) {
            tooltip.add(Text.literal(""));
         
            tooltip.add(Text.literal("§6Enchantments:"));
            tooltip.add((Text) stack.get(DataComponentTypes.ENCHANTMENTS));
        }

        tooltip.add(Text.literal(""));

        // Drill parts
        // Fuel tank
        if (stack.get(ModDataComponentTypes.TANK).getHasTank()) {
            tooltip.add(Text.literal("§a" + getTankTier(stack)));
            tooltip.add(Text.literal("§7Increase your fuel capacity"));
            tooltip.add(Text.literal("§7to: §2" + getMaxFuel(stack)));
        } else {
            tooltip.add(Text.literal("§7Fuel Tank: §cNot Installed"));
            tooltip.add(Text.literal("§7Increase your fuel capacity"));
            tooltip.add(Text.literal("§7with tank installed"));
        }
        tooltip.add(Text.literal(""));

        // Drill Engine
        if (stack.get(ModDataComponentTypes.ENGINE).getHasEngine()) {
            tooltip.add(Text.literal("§a" + getEngineTier(stack)));
            tooltip.add(Text.literal("§7Grants an extra "));
            tooltip.add(Text.literal("§6" + getMiningSpeed(stack) + " Mining Speed"));
        } else {
            tooltip.add(Text.literal("§7Drill Engine: §cNot Installed"));
            tooltip.add(Text.literal("§7Increase your mining speed"));
            tooltip.add(Text.literal("§7with engine installed."));
        }
        tooltip.add(Text.literal(""));
        
        // Upgrade Module
        if (hasUpgrade) {
            tooltip.add(Text.literal("§a" + upgrade));
        } else {
            tooltip.add(Text.literal("§7Upgrade Module: §cNot Installed"));
            tooltip.add(Text.literal("§7Increase a certain stat with"));
            tooltip.add(Text.literal("§7module installed"));
        }
        tooltip.add(Text.literal(""));


        // Tool ability
        tooltip.add(Text.literal("§6Item Ability: Mining Speed Boost"));
        tooltip.add(Text.literal("§7Usage: §e§lRIGHT CLICK"));
        tooltip.add(Text.literal("§7Grants §a300% §6Mining Speed"));
        tooltip.add(Text.literal("§8Duration: §a20s"));
        tooltip.add(Text.literal("§8Cooldown: §a120s"));

        tooltip.add(Text.literal(""));

        // Fuel
        if(getFuel(stack) > 0) {
            if (getFuel(stack) > 10000) {
                tooltip.add(Text.literal("§7Fuel: " + "§2" + (getFuel(stack) / 1000) + "k§8/" + (getMaxFuel(stack) / 1000) + "k"));
            } else {
                tooltip.add(Text.literal("§7Fuel: " + "§2" + getFuel(stack) + "§8/" + (getMaxFuel(stack) / 1000) + "k"));
            }
        } else {
            tooltip.add(Text.literal("§7Fuel: §4Empty"));
        }

        tooltip.add(Text.literal(""));

        // Item Rarity
        tooltip.add(Text.literal("§l" + this.rarity + " DRILL").formatted(this.rarity.formatting));
        

        super.appendTooltip(stack, context, tooltip, type);
    }



// MODULE FUNCTIONS
    // returns the module installed
    public static int getModule(String item) {
        String[] name = item.split(" ");

        if (findString(name)) {
            return RomanNumeralConverter.romanToInt(name[3]);
        } else {
            if (item.equals("has_engine")) {
                return engineTier;
            } else if (item.equals("has_tank")) {
                return tankTier;
            } else {
                Subterra.LOGGER.info("Failed at function getModule() {line 242}");
                return 0;
            }
        }
    }
    
    // checks if the item has a module installed
    public static boolean hasModule(String module, ItemStack stack) {

        // Checks engine
        if (Objects.equals(module, "engine")) {
            return getEngineTier(stack) > 0;
        } 
        // Checks fuel tank
        else if (Objects.equals(module, "tank")) {
            return getTankTier(stack) > 0;
        } else {
            return false;
        }
        
    }

    // adds a module to the item
    public static void addModuleToDrill(String module, String name) {
        String[] itemName = name.split(" ");
        int level = RomanNumeralConverter.romanToInt(itemName[3]);
        
        // Adds an engine to the item
        if (Objects.equals(module, "engine")) {
            engineTier = level;
        } 
        // Adds a tank to the item
        else if (Objects.equals(module, "tank")) {
            tankTier = level;
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
            editDrillDataComponents(stack, false, 0, "fuel");
        if (fuel >= 3000) {
            editDrillDataComponents(stack, false, fuel, "decrease_fuel");
        }
    }
    
    // sets the fuel
    private void setFuel(ItemStack stack) {
        while (i < 1) {
            editDrillDataComponents(stack, false, 3000, "fuel");
            i++;
        }
    }

    private void setMiningSpeed(ItemStack stack) {
        while(j < 1) {
            editDrillDataComponents(stack, false, 0, "speed");
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



// BASIC FUNCTIONS
    // removes fuel after player mined a block
    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Subterra.LOGGER.info("postMine: {}", getFuel(stack));

        int newFuel = getFuel(stack) - 1;
        editDrillDataComponents(stack, true, newFuel, "decrease_fuel");
        return super.postMine(stack, world, state, pos, miner);
    }
    
    // check if the player has enough fuel to mine
    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        ItemStack stack = miner.getEquippedStack(EquipmentSlot.MAINHAND);
        Subterra.LOGGER.info("canMine: {}", getFuel(stack));
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
    
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    private static boolean findString(String[] list) {
        String searchString = "Tier";

        for (String item : list) {
            if (item.equals(searchString)) {
                return true;
            }
        }
        return false;
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }
}
