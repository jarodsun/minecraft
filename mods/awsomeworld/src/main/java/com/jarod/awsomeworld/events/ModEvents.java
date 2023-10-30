package com.jarod.awsomeworld.events;

import com.jarod.awsomeworld.AwsomeWorld;
import com.jarod.awsomeworld.commands.HomeCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = AwsomeWorld.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event){
        new HomeCommand.SetHomeCommand(event.getDispatcher());
        new HomeCommand.ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event){
        if (!event.getOriginal().getEntityWorld().isRemote()){
            event.getPlayer().getPersistentData().putIntArray(AwsomeWorld.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(AwsomeWorld.MOD_ID + "homepos"));
        }
    }
}
