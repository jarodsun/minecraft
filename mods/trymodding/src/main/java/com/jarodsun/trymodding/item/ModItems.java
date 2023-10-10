package com.jarodsun.trymodding.item;

import com.jarodsun.trymodding.TryModding;
import net.minecraft.item.Item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


import java.rmi.registry.Registry;

public class ModItems  {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TryModding.MOD_ID);
    public static final RegistryObject<Item> testitem = ITEMS.register("testitem",
            () -> new Item(new Item.Properties().group(ModItemGroup.TEST_GROUP)));

    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);
    }


}
