package com.jarod.awsomeworld.item.custom;

import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class RingFlight extends Item {
    public RingFlight(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected){
        if(world.isRemote) return;
        PlayerEntity player = (PlayerEntity) entity;
        player.abilities.allowFlying = true;
        player.sendPlayerAbilities();
        player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 300));

    }
}
