package com.jarod.awsomeworld.item;

import com.jarod.awsomeworld.AwsomeWorld;
import com.jarod.awsomeworld.item.custom.RingFlight;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AwsomeWorld.MOD_ID);

    public static final RegistryObject<Item> RINGFLIGHT = ITEMS.register("ring_flight",
            () -> new RingFlight(new Item.Properties().group(ModItemGroup.AWSOME_WORLD)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
