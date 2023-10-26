package com.jarod.awsomeworld.item;

import com.jarod.awsomeworld.AwsomeWorld;
import com.jarod.awsomeworld.item.custom.*;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AwsomeWorld.MOD_ID);

    public static final RegistryObject<Item> RINGFLIGHTLV1 = ITEMS.register("ring_flight_lv1",
            () -> new RingFlightLv1(new Item.Properties().group(ModItemGroup.AWSOME_WORLD)));
    public static final RegistryObject<Item> RINGFLIGHTLV2 = ITEMS.register("ring_flight_lv2",
            () -> new RingFlightLv2(new Item.Properties().group(ModItemGroup.AWSOME_WORLD)));
    public static final RegistryObject<Item> RINGFLIGHTLV3 = ITEMS.register("ring_flight_lv3",
            () -> new RingFlightLv3(new Item.Properties().group(ModItemGroup.AWSOME_WORLD)));
    public static final RegistryObject<Item> RINGFLIGHTLV4 = ITEMS.register("ring_flight_lv4",
            () -> new RingFlightLv4(new Item.Properties().group(ModItemGroup.AWSOME_WORLD)));
    public static final RegistryObject<Item> RINGFLIGHTLV5 = ITEMS.register("ring_flight_lv5",
            () -> new RingFlightLv5(new Item.Properties().group(ModItemGroup.AWSOME_WORLD)));
    public static final RegistryObject<Item> RINGFLIGHTLV6 = ITEMS.register("ring_flight_lv6",
            () -> new RingFlightLv6(new Item.Properties().group(ModItemGroup.AWSOME_WORLD)));
    public static final RegistryObject<Item> RINGFLIGHTLV7 = ITEMS.register("ring_flight_lv7",
            () -> new RingFlightLv7(new Item.Properties().group(ModItemGroup.AWSOME_WORLD)));
    public static final RegistryObject<Item> RINGFLIGHTLV8 = ITEMS.register("ring_flight_lv8",
            () -> new RingFlightLv8(new Item.Properties().group(ModItemGroup.AWSOME_WORLD)));
    public static final RegistryObject<Item> RINGFLIGHTLV9 = ITEMS.register("ring_flight_lv9",
            () -> new RingFlightLv9(new Item.Properties().group(ModItemGroup.AWSOME_WORLD)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
