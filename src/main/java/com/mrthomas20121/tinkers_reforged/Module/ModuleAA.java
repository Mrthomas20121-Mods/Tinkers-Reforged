package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;

import de.ellpeck.actuallyadditions.mod.items.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAA extends ModuleBase {
  
  public RegistryLib blackquartz = new RegistryLib(Materials.blackquartz);
  public RegistryLib enori = new RegistryLib(Materials.enori);
  public RegistryLib redstonia = new RegistryLib(Materials.redstonia);
  public RegistryLib voidCrystal = new RegistryLib(Materials.void_crystal);
  public RegistryLib diamantine = new RegistryLib(Materials.diamantine);
  public RegistryLib emeradic = new RegistryLib(Materials.emeradic);
  public RegistryLib palis = new RegistryLib(Materials.palis);

  public ModuleAA() {
      blackquartz.setCraftable(false).setCastable(true);
      blackquartz.registerMaterialTrait(TinkerTraits.crude2, MaterialTypes.HEAD);
      blackquartz.registerMaterialTrait(TinkerTraits.sharp);

      enori.setCraftable(false).setCastable(true);

      redstonia.setCraftable(false).setCastable(true);

      voidCrystal.setCraftable(false).setCastable(true);

      diamantine.setCraftable(false).setCastable(true);

      emeradic.setCraftable(false).setCastable(true);

      palis.setCraftable(false).setCastable(true);
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