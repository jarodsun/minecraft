package com.jarod.awsomeworld.item.custom;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import java.util.List;

public class GodSword extends SwordItem {
    public GodSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }
    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        super.onCreated(stack, worldIn, playerIn);
//        stack.addEnchantment(Enchantments.SHARPNESS,10);
        stack.addEnchantment(Enchantments.LOOTING,10);
        stack.addEnchantment(Enchantments.BANE_OF_ARTHROPODS,10);
        stack.addEnchantment(Enchantments.KNOCKBACK,10);
        stack.addEnchantment(Enchantments.SMITE,10);
        stack.addEnchantment(Enchantments.SWEEPING,10);
    }
    @Override
    public boolean isDamageable(){ return false;}

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.awsomeworld.god_sword_line1"));
    }
}
