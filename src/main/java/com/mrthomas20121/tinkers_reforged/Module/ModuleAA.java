package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;

import de.ellpeck.actuallyadditions.mod.items.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.Material;

public class ModuleAA extends ModuleBase {
  
  public RegistryLib enori = null;
  public RegistryLib redstonia = null;
  public RegistryLib voidCrystal = null;
  public RegistryLib diamantine = null;
  public RegistryLib emeradic = null;
  public RegistryLib palis = null;

  public ModuleAA() {

  }

  public void preInit(FMLPreInitializationEvent e) {

  }
  public void init(FMLInitializationEvent e) {
    voidCrystal.setRepresentativeItem(new ItemStack(InitItems.itemCrystal, 1, 3));
    enori.setRepresentativeItem(new ItemStack(InitItems.itemCrystal, 1, 5));
    palis.setRepresentativeItem(new ItemStack(InitItems.itemCrystal, 1, 1));
    emeradic.setRepresentativeItem(new ItemStack(InitItems.itemCrystal, 1, 4));
    diamantine.setRepresentativeItem(new ItemStack(InitItems.itemCrystal, 1, 2));
    redstonia.addIngotItem(new ItemStack(InitItems.itemCrystal, 1));
    redstonia.setRepresentativeItem(new ItemStack(InitItems.itemCrystal, 1));
  }
  public void postInit(FMLPostInitializationEvent e) {

  }

}