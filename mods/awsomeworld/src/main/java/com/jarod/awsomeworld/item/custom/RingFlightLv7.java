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

public class RingFlightLv7 extends Item {
    public RingFlightLv7(Properties properties) {
        super(properties.maxStackSize(1));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected){
        if(world.isRemote) return;
        PlayerEntity player = (PlayerEntity) entity;
        player.abilities.allowFlying = true;
        player.sendPlayerAbilities();
        player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 300, 0, true, false));
        player.addPotionEffect(new EffectInstance(Effects.HASTE, 300, 9, true, false));
        player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 300, 9, true, false));
        player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 300, 9, true, false));
        player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 300, 9, true, false));
        player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 300, 9, true, false));
    }
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        tooltip.add(new TranslationTextComponent("tooltip.awsomeworld.ring_flight_lv7_line1"));
        tooltip.add(new TranslationTextComponent("tooltip.awsomeworld.ring_flight_lv7_line2"));
        tooltip.add(new TranslationTextComponent("tooltip.awsomeworld.ring_flight_lv7_line3"));
        tooltip.add(new TranslationTextComponent("tooltip.awsomeworld.ring_flight_lv7_line4"));
        tooltip.add(new TranslationTextComponent("tooltip.awsomeworld.ring_flight_lv7_line5"));
        tooltip.add(new TranslationTextComponent("tooltip.awsomeworld.ring_flight_lv7_line6"));
        tooltip.add(new TranslationTextComponent("tooltip.awsomeworld.ring_flight_lv7_line7"));

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}