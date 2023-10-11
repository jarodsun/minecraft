package com.jarod.awsomeworld.dimension;

import com.jarod.awsomeworld.AwsomeWorld;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions {
    public static RegistryKey<World> CoalDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(AwsomeWorld.MOD_ID, "coaldim"));
}
