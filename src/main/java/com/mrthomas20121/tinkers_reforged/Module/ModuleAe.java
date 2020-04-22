package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAe extends ModuleBase {
    public ModuleAe() {
        Materials.mats.add(Materials.certus_quartz);
        Materials.mats.add(Materials.fluix_crystal);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        // certus quartz crystal
        if(Config.certus_quartz) {
            TinkerRegistry.addMaterialStats(Materials.certus_quartz,
                    new HeadMaterialStats(230, 4.2f, 3f, HarvestLevels.IRON),
                    new HandleMaterialStats(0.8f, 90),
                    new ExtraMaterialStats(70),
                    new BowMaterialStats(1.0f, 1.7f, 2.1f));
            Materials.certus_quartz.addItem("crystalCertusQuartz", 1, Material.VALUE_Gem);
            Materials.certus_quartz.addItem("crystalPureCertusQuartz", 1, Material.VALUE_Gem);
            Materials.certus_quartz.setCraftable(true).setCastable(false);
            Materials.certus_quartz.addTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
            Materials.certus_quartz.addTrait(TinkerTraits.fractured);
            MaterialIntegration certus_quartzmi = new MaterialIntegration(Materials.certus_quartz).setRepresentativeItem("crystalCertusQuartz");
            TinkerRegistry.integrate(certus_quartzmi).preInit();
        }

        // fluix crystal
        if(Config.fluix_crystal) {
            TinkerRegistry.addMaterialStats(Materials.fluix_crystal,
                    new HeadMaterialStats(230, 4.4f, 3.1f, HarvestLevels.IRON),
                    new HandleMaterialStats(0.9f, 100),
                    new ExtraMaterialStats(90),
                    new BowMaterialStats(1.0f, 1.7f, 2.1f));
            Materials.fluix_crystal.setCraftable(true).setCastable(false);
            Materials.fluix_crystal.addItem("crystalFluix", 1, Material.VALUE_Gem);
            Materials.fluix_crystal.addItem("crystalPureFluix", 1, Material.VALUE_Gem);
            Materials.fluix_crystal.addTrait(TinkerTraits.unnatural, MaterialTypes.HEAD);
            Materials.fluix_crystal.addTrait(Traits.signal);
            MaterialIntegration fluixmi = new MaterialIntegration(Materials.fluix_crystal).setRepresentativeItem("crystalFluix");
            TinkerRegistry.integrate(fluixmi).preInit();
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {

    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
