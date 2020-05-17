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
}