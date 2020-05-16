package com.mrthomas20121.libs.Fluid;

import com.mrthomas20121.tinkers_reforged.TinkersReforged;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidBase extends Fluid {

  public static ResourceLocation liquid_still = new ResourceLocation(TinkersReforged.MODID, "blocks/fluids/liquid");
  public static ResourceLocation liquid_flow = new ResourceLocation(TinkersReforged.MODID, "blocks/fluids/liquid_flow");
  public final int color;

  public FluidBase(String name, int color, ResourceLocation still, ResourceLocation flow) {
    super(name, still, flow);

    // make opaque if no alpha is set
    if(((color >> 24) & 0xFF) == 0) {
      color |= 0xFF << 24;
    }
    this.color = color;
  }
  public FluidBase(String name, int color) {
    this(name, color, liquid_still, liquid_flow);
  }

  @Override
  public int getColor() {
    return color;
  }
}