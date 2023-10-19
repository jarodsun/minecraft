package com.jarod.awsomeworld.dimension;

import com.jarod.awsomeworld.AwsomeWorld;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions {
    public static RegistryKey<World> IronDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(AwsomeWorld.MOD_ID, "irondim"));
    public static RegistryKey<World> CoalDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(AwsomeWorld.MOD_ID, "coaldim"));
    public static RegistryKey<World> GoldDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(AwsomeWorld.MOD_ID, "golddim"));
    public static RegistryKey<World> DiamondDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(AwsomeWorld.MOD_ID, "diamonddim"));
    public static RegistryKey<World> AncientDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(AwsomeWorld.MOD_ID, "ancientdim"));
    public static RegistryKey<World> EmeraldDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(AwsomeWorld.MOD_ID, "emeralddim"));
    public static RegistryKey<World> LapisDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(AwsomeWorld.MOD_ID, "lapisdim"));
    public static RegistryKey<World> RedstoneDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(AwsomeWorld.MOD_ID, "redstonedim"));
    public static RegistryKey<World> QuartzDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(AwsomeWorld.MOD_ID, "quartzdim"));
    public static RegistryKey<World> SafeDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(AwsomeWorld.MOD_ID, "safedim"));
}
