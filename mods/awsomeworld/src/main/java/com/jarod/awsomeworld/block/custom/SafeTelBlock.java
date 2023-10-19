package com.jarod.awsomeworld.block.custom;

import com.jarod.awsomeworld.dimension.ModDimensions;
import com.jarod.awsomeworld.dimension.custom.SafeTeleporter;
import net.minecraft.block.AbstractBlock;
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

public class SafeTelBlock extends LecternBlock {
    public SafeTelBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit){
        if (!worldIn.isRemote()){
            if (!player.isCrouching()){
                MinecraftServer server = worldIn.getServer();

                if (server != null){
                    if (worldIn.getDimensionKey() == ModDimensions.SafeDim){
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        if (overWorld != null){
                            player.changeDimension(overWorld, new SafeTeleporter(pos, false));
                        }
                    } else {
                        ServerWorld safeDim = server.getWorld(ModDimensions.SafeDim);
                        if (safeDim != null){
                            player.changeDimension(safeDim, new SafeTeleporter(pos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }

            }

        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
