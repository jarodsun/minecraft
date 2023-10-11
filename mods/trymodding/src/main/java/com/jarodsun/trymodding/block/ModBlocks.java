package com.jarodsun.trymodding.block;

import com.jarodsun.trymodding.TryModding;
import com.jarodsun.trymodding.block.custom.CoalTelBlock;
import com.jarodsun.trymodding.item.ModItemGroup;
import com.jarodsun.trymodding.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, TryModding.MOD_ID);

    public  static final RegistryObject<Block> TEST_ORE = registerBlock("test_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).
                    harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> COAL_TEL = registerBlock("coal_tel",
            () -> new CoalTelBlock(AbstractBlock.Properties.create(Material.IRON).notSolid()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.TEST_GROUP)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
