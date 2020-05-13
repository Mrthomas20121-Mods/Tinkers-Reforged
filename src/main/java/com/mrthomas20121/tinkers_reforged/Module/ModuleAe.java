package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAe extends ModuleBase {

    public RegistryLib certus_quartz = new RegistryLib(Materials.certus_quartz);
    public RegistryLib fluix_crystal = new RegistryLib(Materials.fluix_crystal);

    public ModuleAe() {
        certus_quartz.setCraftable(true).setCastable(false);
        certus_quartz.registerMaterialTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
        certus_quartz.registerMaterialTrait(TinkerTraits.fractured);
        certus_quartz.registerHeadStats(230, 4.2f, 3f, HarvestLevels.IRON);
        certus_quartz.registerHandleStats(0.8f, 90);
        certus_quartz.registerExtraStats(70);

        fluix_crystal.setCraftable(true).setCastable(false);
        fluix_crystal.registerMaterialTrait(Traits.flux, MaterialTypes.HEAD);
        fluix_crystal.registerMaterialTrait(Traits.signal);
        fluix_crystal.registerHeadStats(230, 4.2f, 3f, HarvestLevels.IRON);
        fluix_crystal.registerHandleStats(0.8f, 90);
        fluix_crystal.registerExtraStats(70);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {

        if(Config.certus_quartz) {
            certus_quartz.addGemItem("crystalCertusQuartz");
            certus_quartz.addGemItem("crystalPureCertusQuartz");
            certus_quartz.registerPreInit("crystalCertusQuartz");
            Materials.mats.add(certus_quartz.getMat());
        }
        if(Config.fluix_crystal) {
            fluix_crystal.addGemItem("crystalFluix");
            fluix_crystal.addGemItem("crystalPureFluix");
            fluix_crystal.registerPreInit("crystalFluix");
            Materials.mats.add(fluix_crystal.getMat());
        }

    }
    @Override
    public void init(FMLInitializationEvent e) {

    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
