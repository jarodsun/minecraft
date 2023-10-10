package com.jarodsun.trymodding.commands;

import com.jarodsun.trymodding.TryModding;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class ReturnHomeCommand {
    public ReturnHomeCommand(CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(Commands.literal("home").then(Commands.literal("return")
                .executes((command) -> {
                    return retuenHome(command.getSource());
                }
        )));
    }

    private int retuenHome(CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.asPlayer();
        boolean hasHomepos = player.getPersistentData().getIntArray(TryModding.MOD_ID + "homepos").length != 0;

        if(hasHomepos) {
            int [] playerPos = player.getPersistentData().getIntArray(TryModding.MOD_ID + "homepos");
            player.setPositionAndUpdate(playerPos[0], playerPos[1], playerPos[2]);

            source.sendFeedback(new StringTextComponent("Player returned Home!"), true);
            return 1;

        } else {
            source.sendFeedback(new StringTextComponent("No Home Position hs been set!"), true);
            return -1;
        }
    }
}
