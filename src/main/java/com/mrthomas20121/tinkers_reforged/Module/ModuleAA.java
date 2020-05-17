package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.OredictHelper;
import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;

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

        enori.registerMaterialTrait(Traits.starshaped, MaterialTypes.HEAD);
        enori.registerMaterialTrait(TinkerTraits.stiff);
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
        diamantine.registerHeadStats(604, 6.9f, 6.1f, HarvestLevels.OBSIDIAN);
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
            enori.preInit(FluidRegistry.getFluid("enori"));
        }
    }
    public void init(FMLInitializationEvent e) {
        OredictHelper.RegisterCrystalItem("Redstonia",new ItemStack(InitItems.itemCrystal, 1, 0));
        OredictHelper.RegisterCrystalItem("Palis",new ItemStack(InitItems.itemCrystal, 1, 1));
        OredictHelper.RegisterCrystalItem("Diamantine",new ItemStack(InitItems.itemCrystal, 1, 2));
        OredictHelper.RegisterCrystalItem("Void",new ItemStack(InitItems.itemCrystal, 1, 3));
        OredictHelper.RegisterCrystalItem("Emeradic",new ItemStack(InitItems.itemCrystal, 1, 4));
        OredictHelper.RegisterCrystalItem("Enori",new ItemStack(InitItems.itemCrystal, 1, 5));
        blackquartz.setRepresentativeItem("gemQuartzBlack");
        enori.setRepresentativeItem("crystalEnori");
        voidCrystal.setRepresentativeItem("crystalVoid");
        emeradic.setRepresentativeItem("crystalEmeradic");
        redstonia.setRepresentativeItem("crystalRedstonia");
        diamantine.setRepresentativeItem("crystalDiamantine");
        palis.setRepresentativeItem("crystalPalis");
    }
    public void postInit(FMLPostInitializationEvent e) {

    }

}