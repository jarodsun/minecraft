package com.jarod.awsomeworld.item;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup AWSOME_WORLD = new ItemGroup("awsomeworld") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Blocks.CHEST);
        }
    };
}
