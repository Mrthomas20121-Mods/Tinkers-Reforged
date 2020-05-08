package com.mrthomas20121.tinkers_reforged.Module;

import c4.conarm.lib.materials.*;
import com.mrthomas20121.libs.ArmorRegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Config.ConfigModules;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;

import c4.conarm.common.armor.traits.ArmorTraits;

public class ModuleConArm extends ModuleBase {

    public static boolean conarm = Loader.isModLoaded("conarm");

    public ModuleConArm() {

    }

    public void preInit(FMLPreInitializationEvent e) {
        if(Loader.isModLoaded("thermal") && ConfigModules.thermal) {
            if(Config.enderium) {
                ArmorRegistryLib enderium = new ArmorRegistryLib(Materials.enderium);
                enderium.setCoreStats(19.5f, 25.6f);
                enderium.setPlatesStats(0.9f, 8, 0.5f);
                enderium.setTrimStats(30);
                enderium.registerArmor();
                ArmorMaterials.addArmorTrait(Materials.enderium, Traits.ender);
            }
            if(Config.lumium) {
                ArmorMaterials.addArmorTrait(Materials.lumium, Traits.light);
                TinkerRegistry.addMaterialStats(Materials.lumium,
                        new CoreMaterialStats(250, 29),
                        new PlatesMaterialStats(1.1f, 70, 2f),
                        new TrimMaterialStats(50f));
            }
            if(Config.signalum) {

                ArmorMaterials.addArmorTrait(Materials.signalum, Traits.signal);
                TinkerRegistry.addMaterialStats(Materials.signalum,
                        new CoreMaterialStats(250, 29),
                        new PlatesMaterialStats(1.1f, 70, 2f),
                        new TrimMaterialStats(55f));
            }
        }
        if(Loader.isModLoaded("appliedenergistics2") && ConfigModules.ae2) {
            if(Config.certus_quartz) {
                ArmorRegistryLib certus_quartz = new ArmorRegistryLib(Materials.certus_quartz);
                certus_quartz.registerMaterialTrait(ArmorTraits.skeletal);
                certus_quartz.registerMaterialTrait(ArmorTraits.calcic, ArmorMaterialType.CORE);
                certus_quartz.setCoreStats(12, 15);
                certus_quartz.setPlatesStats(0.85f, 5, 0f);
                certus_quartz.setTrimStats(3.5f);
                certus_quartz.registerArmor();
            }
            if(Config.fluix_crystal) {
                ArmorRegistryLib fluix = new ArmorRegistryLib(Materials.fluix_crystal);
                fluix.registerMaterialTrait(ArmorTraits.skeletal);
                fluix.setCoreStats(12, 15);
                fluix.setPlatesStats(0.85f, 5, 0f);
                fluix.setTrimStats(3.5f);
                fluix.registerArmor();
            }
        }

        if(Loader.isModLoaded("naturesaura") && ConfigModules.naturesaura) {
            if(Config.infused_iron) {
                ArmorRegistryLib infused_iron = new ArmorRegistryLib(Materials.infused_iron);
                infused_iron.registerMaterialTrait(Traits.AURA_INFUSION);
                infused_iron.registerMaterialTrait(ArmorTraits.magnetic2, ArmorMaterialType.CORE);
                infused_iron.setCoreStats(12, 15);
                infused_iron.setPlatesStats(0.85f, 5, 0f);
                infused_iron.setTrimStats(3.5f);
                infused_iron.registerArmor();
            }
            if(Config.ancient_wood) {
                ArmorRegistryLib ancient_wood = new ArmorRegistryLib(Materials.ancient_wood);
                ancient_wood.registerMaterialTrait(Traits.AURA_INFUSION);
                ancient_wood.setCoreStats(50, 3);
                ancient_wood.setPlatesStats(1f, 4, 0f);
                ancient_wood.setTrimStats(0.5f);
                ancient_wood.registerArmor();
            }
        }
        if(Loader.isModLoaded("atum") && ConfigModules.atum) {
            if(Config.limestone) {
                ArmorRegistryLib limestone = new ArmorRegistryLib(Materials.limestone);
                limestone.registerMaterialTrait(ArmorTraits.cheap);
                limestone.registerMaterialTrait(ArmorTraits.cheapskate);
                limestone.setCoreStats(9f, 5);
                limestone.setPlatesStats(1f, 20, 0.5f);
                limestone.setTrimStats(1f);
                limestone.registerArmor();
            }
            if(Config.khnumite) {
                ArmorRegistryLib khnumite = new ArmorRegistryLib(Materials.khnumite);
                khnumite.registerMaterialTrait(ArmorTraits.cheap);
                khnumite.registerMaterialTrait(ArmorTraits.cheapskate, ArmorMaterialType.PLATES);
                khnumite.setCoreStats(5.3f, 3);
                khnumite.setPlatesStats(0.75f, -1.5f, 0f);
                khnumite.setTrimStats(1.75f);
                khnumite.registerArmor();
            }
        }
        if((Loader.isModLoaded("astralsorcery") && ConfigModules.astral)) {

            ArmorRegistryLib starmetal = new ArmorRegistryLib(Materials.starmetal);
            starmetal.registerMaterialTrait(Traits.astral);
            starmetal.registerMaterialTrait(ArmorTraits.alien, ArmorMaterialType.PLATES);
            starmetal.setCoreStats(12, 15);
            starmetal.setTrimStats(3.5f);
            starmetal.setPlatesStats(0.85f, 5, 0f);
            starmetal.registerArmor();
        }

        if(Loader.isModLoaded("mysticalworld") && ConfigModules.mysticalworld) {
            if(Config.amethyst) {
                ArmorRegistryLib amethyst = new ArmorRegistryLib(Materials.amethyst);
                amethyst.registerMaterialTrait(ArmorTraits.calcic);
                amethyst.setCoreStats(95, 23);
                amethyst.setPlatesStats(0.9f, 85, 1f);
                amethyst.setTrimStats(45);
                amethyst.registerArmor();
            }
        }

        if(Loader.isModLoaded("roots") && ConfigModules.roots) {
            if(Config.runestone) {
                ArmorRegistryLib runestone = new ArmorRegistryLib(Materials.runestone);
                runestone.registerMaterialTrait(ArmorTraits.cheap);
                runestone.setCoreStats(80, 15);
                runestone.setPlatesStats(1, 80, 0f);
                runestone.setTrimStats(45);
                runestone.registerArmor();
            }
        }
        if(Loader.isModLoaded("bigreactors") && ConfigModules.extreme) {
            if(Config.yellorium) {
                ArmorRegistryLib yellorium = new ArmorRegistryLib(Materials.yellorium);
                yellorium.registerMaterialTrait(Traits.radioactive);
                yellorium.setCoreStats(95, 20);
                yellorium.setPlatesStats(1, 85, 1f);
                yellorium.setTrimStats(45);
                yellorium.registerArmor();
            }

            if(Config.blutonium) {
                ArmorRegistryLib blutonium = new ArmorRegistryLib(Materials.blutonium);
                blutonium.registerMaterialTrait(Traits.nuclearwaste);
                blutonium.setCoreStats(95, 20);
                blutonium.setPlatesStats(1, 85, 1f);
                blutonium.setTrimStats(45);
                blutonium.registerArmor();
            }
        }
    }
    public void init(FMLInitializationEvent e) {

    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
