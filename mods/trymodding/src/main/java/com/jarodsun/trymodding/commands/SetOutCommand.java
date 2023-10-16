package com.jarodsun.trymodding.commands;

import com.jarodsun.trymodding.TryModding;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;

public class SetOutCommand {

    public SetOutCommand(CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(Commands.literal("out").then(Commands.literal("set")
                .executes((command) -> {
                            return setOut(command.getSource());
                        }
                )));
    }
    private int setOut(CommandSource source) throws CommandSyntaxException{
        ServerPlayerEntity player = source.asPlayer();
        BlockPos playerPos = player.getPosition();
        String pos = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ")";

        player.getPersistentData().putIntArray(TryModding.MOD_ID + "outpos",
                new int[]{ playerPos.getX(), playerPos.getY(), playerPos.getZ() });


        source.sendFeedback(new StringTextComponent("Set Out at " + pos), true);
        return 1;
    }
}
