package com.jarodsun.trymodding.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup TEST_GROUP = new ItemGroup("TestModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.testitem.get());
        }
    };
}
