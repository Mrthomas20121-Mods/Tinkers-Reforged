package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.OredictHelper;
import com.mrthomas20121.tinkers_reforged.TinkersReforged;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.mantle.typesafe.config.Optional;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.smeltery.ICastingRecipe;

import static slimeknights.tconstruct.smeltery.TinkerSmeltery.*;

public abstract class ModuleBase {

    public abstract void preInit(FMLPreInitializationEvent e);

    public abstract void init(FMLInitializationEvent e);

    public abstract void postInit(FMLPostInitializationEvent e);

    protected void registerDefaultMelting(String ore, Fluid fluid) {
        TinkerRegistry.registerMelting("ingot" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("dust" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("block" + ore, fluid, Material.VALUE_Block);
        TinkerRegistry.registerMelting("ore" + ore, fluid, Material.VALUE_Ore());
        TinkerRegistry.registerTableCasting(OreDictionary.getOres("ingot" + ore).get(0), castIngot, fluid,
                Material.VALUE_Ingot);
    }

    protected void registerDefaultMelting(String ore, Fluid fluid, boolean cast) {
        TinkerRegistry.registerMelting("ingot" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("dust" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("plate" + ore, fluid, Material.VALUE_Ingot);
        TinkerRegistry.registerMelting("gear" + ore, fluid, Material.VALUE_Ingot * 4);
        TinkerRegistry.registerMelting("block" + ore, fluid, Material.VALUE_Block);
        if (cast) {
            this.registerDefaultCasting(ore, fluid, false);
        }
    }

    protected void registerDefaultCasting(String oredict, Fluid fluid, boolean isgem) {

        String[] oredicts = { "block", "ingot", "plate", "gear", "nugget"};
        if(isgem) oredicts[1] = "gem";

        for(String ore: oredicts) {
            ItemStack result = OredictHelper.getOre(ore+oredict);
            if(!(result == ItemStack.EMPTY)) {
                if(ore=="ingot") {
                    TinkerRegistry.registerTableCasting(result, castIngot, fluid, Material.VALUE_Ingot);
                }
                else if(ore=="block") {
                    TinkerRegistry.registerBasinCasting(result, ItemStack.EMPTY, fluid, Material.VALUE_Block);
                }
                else if(ore=="plate") {
                    TinkerRegistry.registerTableCasting(result, castPlate, fluid, Material.VALUE_Ingot);
                }
                else if(ore=="nugget") {
                    TinkerRegistry.registerTableCasting(result, castNugget, fluid, Material.VALUE_Nugget);
                }
                else if(ore=="gear") {
                    TinkerRegistry.registerTableCasting(result, castGear, fluid, Material.VALUE_Ingot*4);
                }
                else if(ore=="gem") {
                    TinkerRegistry.registerTableCasting(result, castGem, fluid, Material.VALUE_Gem);
                }
            }
        }
    }
}