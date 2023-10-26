package com.jarod.awsomeworld.item.custom;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class RingFlightLv1 extends Item {
    public RingFlightLv1(Properties properties) {
        super(properties.maxStackSize(1));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected){
        if(world.isRemote) return;
        PlayerEntity player = (PlayerEntity) entity;
        player.abilities.allowFlying = true;
        player.sendPlayerAbilities();
    }
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new TranslationTextComponent("tooltip.awsomeworld.ring_flight_lv1_line1"));

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
