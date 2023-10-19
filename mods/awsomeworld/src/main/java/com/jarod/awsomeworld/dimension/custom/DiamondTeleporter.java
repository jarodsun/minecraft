package com.jarod.awsomeworld.dimension.custom;

import com.jarod.awsomeworld.block.ModBlocks;
import com.jarod.awsomeworld.block.custom.DiamondTelBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class DiamondTeleporter implements ITeleporter {
    public static BlockPos thisPos = BlockPos.ZERO;

    public static boolean insideDimension = true;

    public DiamondTeleporter(BlockPos pos, boolean insideDim){
        thisPos = pos;
        insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destiantionWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity){
        entity = repositionEntity.apply(false);
        double y = 62;

        if (!insideDimension){
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        int tries = 0;
        while ((destiantionWorld.getBlockState(destinationPos).getMaterial() != Material.AIR) &&
                !destiantionWorld.getBlockState(destinationPos).isReplaceable(Fluids.WATER) &&
                destiantionWorld.getBlockState(destinationPos.up()).getMaterial() != Material.AIR &&
                !destiantionWorld.getBlockState(destinationPos.up()).isReplaceable(Fluids.WATER) && tries < 25){
            destinationPos = destinationPos.up(2);
            tries++;
        }

        entity.setPositionAndUpdate(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if (insideDimension){
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.getAllInBoxMutable(destinationPos.down(10).west(10), destinationPos.up(10).east(10))){
                if (destiantionWorld.getBlockState(checkPos).getBlock() instanceof DiamondTelBlock){
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock){
                destiantionWorld.setBlockState(destinationPos, ModBlocks.DIAMOND_TEL.get().getDefaultState());
            }
        }
        return entity;
    }
}
