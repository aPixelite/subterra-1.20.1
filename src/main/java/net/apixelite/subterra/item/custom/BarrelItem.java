package net.apixelite.subterra.item.custom;

import net.apixelite.subterra.fluid.ModFluids;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.block.FluidFillable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class BarrelItem extends BucketItem {
    private final Fluid fluid;

    public BarrelItem(Fluid fluid, Settings settings) {
        super(fluid, settings);
        this.fluid = fluid;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(
                world, user, this.fluid == Fluids.EMPTY ? RaycastContext.FluidHandling.SOURCE_ONLY : RaycastContext.FluidHandling.NONE
        );
        if (blockHitResult.getType() == HitResult.Type.MISS) {
            return ActionResult.PASS;
        } else if (blockHitResult.getType() != HitResult.Type.BLOCK) {
            return ActionResult.PASS;
        } else {
            BlockPos blockPos = blockHitResult.getBlockPos();
            Direction direction = blockHitResult.getSide();
            BlockPos blockPos2 = blockPos.offset(direction);
            if (!world.canEntityModifyAt(user, blockPos) || !user.canPlaceOn(blockPos2, direction, itemStack)) {
                return ActionResult.FAIL;
            } else if (this.fluid == Fluids.EMPTY) {
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.getBlock() instanceof FluidDrainable fluidDrainable) {
                    ItemStack itemStack2 = fluidDrainable.tryDrainFluid(user, world, blockPos, blockState);
                    if (!itemStack2.isEmpty()) {
                        user.incrementStat(Stats.USED.getOrCreateStat(this));
                        fluidDrainable.getBucketFillSound().ifPresent(sound -> user.playSound(sound, 1.0F, 1.0F));
                        world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
                        ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, user, itemStack2);
                        if (!world.isClient) {
                            Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)user, itemStack2);
                        }

                        return ActionResult.SUCCESS.withNewHandStack(itemStack3);
                    }
                }

                return ActionResult.FAIL;
            } else {
                BlockState blockState = world.getBlockState(blockPos);
                BlockPos blockPos3 = blockState.getBlock() instanceof FluidFillable && this.fluid == Fluids.WATER ? blockPos : blockPos2;
                if (this.placeFluid(user, world, blockPos3, blockHitResult)) {
                    this.onEmptied(user, world, itemStack, blockPos3);
                    if (user instanceof ServerPlayerEntity) {
                        Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)user, blockPos3, itemStack);
                    }

                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                    ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, user, getEmptiedStack(itemStack, user));
                    return ActionResult.SUCCESS.withNewHandStack(itemStack2);
                } else {
                    return ActionResult.FAIL;
                }
            }
        }
    }

    public static ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player) {
        return !player.isInCreativeMode() ? new ItemStack(ModFluids.EMPTY_BARREL) : stack;
    }

    protected void playEmptyingSound(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos) {
        SoundEvent soundEvent = SoundEvents.ITEM_BUCKET_EMPTY;
        world.playSound(player, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
        world.emitGameEvent(player, GameEvent.FLUID_PLACE, pos);
    }
}
