package net.apixelite.subterra.util;

import net.apixelite.subterra.components.ModDataComponentTypes;
import net.apixelite.subterra.item.custom.DrillItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HammerUsageEvent implements PlayerBlockBreakEvents.Before {
    // Done with the help of https://github.com/CoFH/CoFHCore/blob/c23d117dcd3b3b3408a138716b15507f709494cd/src/main/java/cofh/core/event/AreaEffectEvents.java
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {
        ItemStack mainHandItem = player.getMainHandStack();

        if (mainHandItem.getItem() instanceof DrillItem drill && player instanceof ServerPlayerEntity serverPlayer) {
            if (Objects.requireNonNull(mainHandItem.get(ModDataComponentTypes.UPGRADE)).getHasUpgrade()) {
                if (HARVESTED_BLOCKS.contains(pos)) {
                    return true;
                }

                for (BlockPos position : DrillItem.getBlocksToBeDestroyed(mainHandItem.get(ModDataComponentTypes.UPGRADE).getLevel(), pos, serverPlayer)) {
                    if (pos == position || !drill.isCorrectForDrops(mainHandItem, world.getBlockState(position))) {
                        continue;
                    }

                    HARVESTED_BLOCKS.add(position);
                    serverPlayer.interactionManager.tryBreakBlock(position);
                    HARVESTED_BLOCKS.remove(position);
                }
            }
        } else {
            return true;
        }
        return true;
    }
}
