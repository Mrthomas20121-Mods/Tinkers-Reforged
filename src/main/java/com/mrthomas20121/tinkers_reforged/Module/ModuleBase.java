package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.mantle.typesafe.config.Optional;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;

import static slimeknights.tconstruct.smeltery.TinkerSmeltery.*;

public abstract class ModuleBase {

    public abstract void preInit(FMLPreInitializationEvent e);
    public abstract void init(FMLInitializationEvent e);
    public abstract void postInit(FMLPostInitializationEvent e);
    protected void registerDefaultMelting(String ore, Fluid fluid) {
        TinkerRegistry.registerMelting("ingot"+ore, fluid,  Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("dust"+ore, fluid,  Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("block"+ore, fluid,  Material.VALUE_Block);
        TinkerRegistry.registerMelting("ore"+ore, fluid,  Material.VALUE_Ore());
        TinkerRegistry.registerTableCasting(OreDictionary.getOres("ingot"+ore).get(0), castIngot, fluid, Material.VALUE_Ingot);
    }

    protected void registerDefaultMelting(String ore, Fluid fluid, boolean cast) {
        TinkerRegistry.registerMelting("ingot"+ore, fluid,  Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("dust"+ore, fluid,  Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("plate"+ore, fluid,  Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("gear"+ore, fluid,  Material.VALUE_Ingot*4);
        TinkerRegistry.registerMelting("block"+ore, fluid,  Material.VALUE_Block);
        if(cast) {
            TinkerRegistry.registerTableCasting(OreDictionary.getOres("ingot"+ore).get(0), castIngot, fluid, Material.VALUE_Ingot);
            TinkerRegistry.registerTableCasting(OreDictionary.getOres("plate"+ore).get(0), castPlate, fluid, Material.VALUE_Ingot);
            TinkerRegistry.registerTableCasting(OreDictionary.getOres("gear"+ore).get(0), castGear, fluid, Material.VALUE_Ingot*4);
            NonNullList<ItemStack> list = OreDictionary.getOres("block"+ore);
            if (list.size()>0)
                TinkerRegistry.registerBasinCasting(OreDictionary.getOres("block"+ore).get(0), ItemStack.EMPTY, fluid, Material.VALUE_Block);
        }
    }
}