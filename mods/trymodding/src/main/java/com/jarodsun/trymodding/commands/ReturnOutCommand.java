package com.jarodsun.trymodding.commands;

import com.jarodsun.trymodding.TryModding;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class ReturnOutCommand {
    public ReturnOutCommand(CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(Commands.literal("out").then(Commands.literal("return")
                .executes((command) -> {
                            return retuenOut(command.getSource());
                        }
                )));
    }

    private int retuenOut(CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.asPlayer();
        boolean hasOutpos = player.getPersistentData().getIntArray(TryModding.MOD_ID + "outpos").length != 0;

        if(hasOutpos) {
            int [] playerPos = player.getPersistentData().getIntArray(TryModding.MOD_ID + "outpos");
            player.setPositionAndUpdate(playerPos[0], playerPos[1], playerPos[2]);

            source.sendFeedback(new StringTextComponent("Player returned Out!"), true);
            return 1;

        } else {
            source.sendFeedback(new StringTextComponent("No Out Position hs been set!"), true);
            return -1;
        }
    }
}
