package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.materials.Material;

public class ModuleBase {
	
    public void preInit(FMLPreInitializationEvent e) { }
    public void init(FMLInitializationEvent e) { }
    public void postInit(FMLPostInitializationEvent e) { }
    public void clientPostInit() {
        for (Material mat : Materials.mats) {
            mat.setRenderInfo(mat.materialTextColor);
        }
    }
}