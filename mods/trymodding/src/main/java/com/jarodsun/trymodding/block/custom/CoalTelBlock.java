package com.jarodsun.trymodding.block.custom;

import com.jarodsun.trymodding.dimension.CoalTeleporter;
import com.jarodsun.trymodding.dimension.ModDimensions;
import net.minecraft.block.BlockState;
import net.minecraft.block.LecternBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class CoalTelBlock extends LecternBlock {
    public CoalTelBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit){
        if (!worldIn.isRemote()){
            if (!player.isCrouching()){
                MinecraftServer server = worldIn.getServer();

                if (server != null){
                    if (worldIn.getDimensionKey() == ModDimensions.CoalDim){
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        if (overWorld != null){
                            player.changeDimension(overWorld, new CoalTeleporter(pos, false));
                        }
                    } else {
                        ServerWorld telDim = server.getWorld(ModDimensions.CoalDim);
                        if (telDim != null){
                            player.changeDimension(telDim, new CoalTeleporter(pos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }

            }

        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
