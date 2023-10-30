package com.jarod.awsomeworld.commands;

import com.jarod.awsomeworld.AwsomeWorld;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;

public class HomeCommand {
    public static class SetHomeCommand{
        public SetHomeCommand(CommandDispatcher<CommandSource> dispatcher){
            dispatcher.register(Commands.literal("home").then(Commands.literal("set")
                    .executes((command) -> {
                        return setHome(command.getSource());
                    }
                    )));
        }
        private int setHome(CommandSource source) throws CommandSyntaxException{
            ServerPlayerEntity player = source.asPlayer();
            BlockPos playerPos = player.getPosition();
            String pos = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";
            player.getPersistentData().putIntArray(AwsomeWorld.MOD_ID + "homepos",
                    new int[]{ playerPos.getX(), playerPos.getY(), playerPos.getZ() });
            source.sendFeedback(new StringTextComponent("Set Home at " + pos), true);
            return 1;

        }
    }
    public static class ReturnHomeCommand{
        public ReturnHomeCommand(CommandDispatcher<CommandSource> dispatcher){
            dispatcher.register(Commands.literal("home").then(Commands.literal("return")
                    .executes((command) -> {
                                return retuenHome(command.getSource());
                            }
                    )));
        }
        private int retuenHome(CommandSource source) throws CommandSyntaxException {
            ServerPlayerEntity player = source.asPlayer();
            boolean hasHomepos = player.getPersistentData().getIntArray(AwsomeWorld.MOD_ID + "homepos").length != 0;

            if(hasHomepos) {
                int [] playerPos = player.getPersistentData().getIntArray(AwsomeWorld.MOD_ID + "homepos");
                player.setPositionAndUpdate(playerPos[0], playerPos[1], playerPos[2]);

                source.sendFeedback(new StringTextComponent("Player returned Home!"), true);
                return 1;

            } else {
                source.sendFeedback(new StringTextComponent("No Home Position hs been set!"), true);
                return -1;
            }
        }
    }
}
