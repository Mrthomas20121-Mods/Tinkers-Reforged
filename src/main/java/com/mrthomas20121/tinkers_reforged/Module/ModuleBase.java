package com.mrthomas20121.tinkers_reforged.Module;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;

import static slimeknights.tconstruct.smeltery.TinkerSmeltery.*;

public abstract class ModuleBase {

    public abstract void preInit(FMLPreInitializationEvent e);

    public abstract void init(FMLInitializationEvent e);

    public abstract void postInit(FMLPostInitializationEvent e);
}