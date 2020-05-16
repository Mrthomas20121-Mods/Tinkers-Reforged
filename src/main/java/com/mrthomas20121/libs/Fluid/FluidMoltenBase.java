package com.mrthomas20121.libs.Fluid;

import com.mrthomas20121.tinkers_reforged.TinkersReforged;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;

public class FluidMoltenBase extends FluidBase {

    public static ResourceLocation MetalStill = new ResourceLocation(TinkersReforged.MODID, "blocks/fluids/molten_metal");
    public static ResourceLocation MetalFlowing = new ResourceLocation(TinkersReforged.MODID, "blocks/fluids/molten_metal_flow");

    public FluidMoltenBase(String name, int color) {
        super(name, color, MetalStill, MetalFlowing);

        this.setDensity(2000);
        this.setViscosity(9000);
        this.setTemperature(500);
        this.setLuminosity(10);
        setRarity(EnumRarity.UNCOMMON);
    }
}