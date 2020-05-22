package com.mrthomas20121.libs.Fluid;

import com.mrthomas20121.tinkers_reforged.TinkersReforged;

import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.fluid.FluidMolten;

public class FluidMoltenBase extends FluidMolten {

    public static ResourceLocation MetalStill = new ResourceLocation(TinkersReforged.MODID, "blocks/fluids/molten_metal");
    public static ResourceLocation MetalFlowing = new ResourceLocation(TinkersReforged.MODID, "blocks/fluids/molten_metal_flow");

    public FluidMoltenBase(String name, int color) {
        super(name, color, MetalStill, MetalFlowing);
        this.setTemperature(500);
    }
}