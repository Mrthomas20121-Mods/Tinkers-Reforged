package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.fluid.FluidMolten;

public class ModuleFluids {
    public static FluidMolten blutonium = new FluidMolten("blutonium", Materials.blutonium.materialTextColor);
    public static FluidMolten infused_iron = new FluidMolten("infused_iron", Materials.infused_iron.materialTextColor);
    public static FluidMolten ludicrite = new FluidMolten("ludicrite", Materials.ludicrite.materialTextColor);
    public static FluidMolten lavium = new FluidMolten("lavium", Materials.lavium.materialTextColor);
    public static FluidMolten qivium = new FluidMolten("qivium", Materials.qivium.materialTextColor);
}
