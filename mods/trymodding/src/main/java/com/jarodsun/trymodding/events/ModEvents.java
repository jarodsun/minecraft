package com.jarodsun.trymodding.events;

import com.jarodsun.trymodding.TryModding;
import com.jarodsun.trymodding.commands.ReturnHomeCommand;
import com.jarodsun.trymodding.commands.ReturnOutCommand;
import com.jarodsun.trymodding.commands.SetHomeCommand;
import com.jarodsun.trymodding.commands.SetOutCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = TryModding.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());
        new SetOutCommand(event.getDispatcher());
        new ReturnOutCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlyaerCloneEvent(PlayerEvent.Clone event) {
        if (!event.getOriginal().getEntityWorld().isRemote()) {
            event.getPlayer().getPersistentData().putIntArray(TryModding.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(TryModding.MOD_ID + "homepos"));
            event.getPlayer().getPersistentData().putIntArray(TryModding.MOD_ID + "outpos",
                    event.getOriginal().getPersistentData().getIntArray(TryModding.MOD_ID + "outpos"));
        }
    }
}
