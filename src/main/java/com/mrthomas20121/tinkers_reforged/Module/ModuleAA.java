package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;

import de.ellpeck.actuallyadditions.mod.items.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
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
        blackquartz.registerHeadStats(204, 6, 4, HarvestLevels.DIAMOND);
        blackquartz.registerHandleStats(0.95f, 60);
        blackquartz.registerExtraStats(50);

        enori.setCraftable(false).setCastable(true);
        enori.registerHeadStats(304, 6.5f, 6, HarvestLevels.DIAMOND);
        enori.registerHandleStats(0.95f, 60);
        enori.registerExtraStats(50);

        redstonia.setCraftable(false).setCastable(true);
        redstonia.registerHeadStats(304, 6.5f, 6, HarvestLevels.DIAMOND);
        redstonia.registerHandleStats(0.95f, 60);
        redstonia.registerExtraStats(50);

        voidCrystal.setCraftable(false).setCastable(true);
        voidCrystal.registerHeadStats(304, 6.5f, 6, HarvestLevels.DIAMOND);
        voidCrystal.registerHandleStats(0.95f, 60);
        voidCrystal.registerExtraStats(50);

        diamantine.setCraftable(false).setCastable(true);
        diamantine.registerHeadStats(304, 6.5f, 6, HarvestLevels.DIAMOND);
        diamantine.registerHandleStats(0.95f, 60);
        diamantine.registerExtraStats(50);

        emeradic.setCraftable(false).setCastable(true);

        palis.setCraftable(false).setCastable(true);
    }

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.blackquartz) {
            blackquartz.setFluid(FluidRegistry.getFluid("black_quartz"));
            blackquartz.addGemItem("QuartzBlack");
            blackquartz.preInit("QuartzBlack", "gem", FluidRegistry.getFluid("black_quartz"));
        }

        if(Config.enori) {
            enori.preInit(FluidRegistry.getFluid("black_quartz"));
        }
    }
    public void init(FMLInitializationEvent e) {
        blackquartz.setRepresentativeItem("gemQuartzBlack");
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