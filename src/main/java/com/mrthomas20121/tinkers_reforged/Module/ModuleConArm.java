package com.mrthomas20121.tinkers_reforged.Module;

import c4.conarm.lib.materials.*;
import com.mrthomas20121.libs.ArmorRegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;

import c4.conarm.common.armor.traits.ArmorTraits;

public class ModuleConArm extends ModuleBase {

    public static boolean conarm = Loader.isModLoaded("conarm");

    public ModuleConArm() { }

    public void preInit(FMLPreInitializationEvent e) {
        if(Loader.isModLoaded("thermal") && Config.thermal) {
            if(Config.enderium) {
                ArmorMaterials.addArmorTrait(Materials.enderium, Traits.ender);
                TinkerRegistry.addMaterialStats(Materials.enderium,
                        new CoreMaterialStats(300, 30),
                        new PlatesMaterialStats(1, 90, 2f),
                        new TrimMaterialStats(50.5f));
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
        if(Loader.isModLoaded("appliedenergistics2") && Config.ae2) {
            if(Config.certus_quartz) {
                ArmorMaterials.addArmorTrait(Materials.certus_quartz, ArmorTraits.skeletal);
                ArmorMaterials.addArmorTrait(Materials.certus_quartz, ArmorTraits.calcic, ArmorMaterialType.CORE);
                TinkerRegistry.addMaterialStats(Materials.certus_quartz,
                        new CoreMaterialStats(12, 15),
                        new PlatesMaterialStats(0.85f, 5, 0f),
                        new TrimMaterialStats(3.5f));
            }
            if(Config.fluix_crystal) {
                ArmorMaterials.addArmorTrait(Materials.fluix_crystal, Traits.signal);
                ArmorMaterials.addArmorTrait(Materials.fluix_crystal, ArmorTraits.skeletal, ArmorMaterialType.CORE);
                TinkerRegistry.addMaterialStats(Materials.fluix_crystal,
                        new CoreMaterialStats(12, 15),
                        new PlatesMaterialStats(0.85f, 5, 0f),
                        new TrimMaterialStats(3.5f));
            }
        }

        if(Loader.isModLoaded("naturesaura") && Config.naturesaura) {
            if(Config.infused_iron) {
                ArmorMaterials.addArmorTrait(Materials.infused_iron, Traits.AURA_INFUSION);
                ArmorMaterials.addArmorTrait(Materials.infused_iron, ArmorTraits.magnetic2);
                TinkerRegistry.addMaterialStats(Materials.infused_iron,
                        new CoreMaterialStats(12, 15),
                        new PlatesMaterialStats(0.85f, 5, 0f),
                        new TrimMaterialStats(3.5f));
            }
            if(Config.ancient_wood) {
                ArmorMaterials.addArmorTrait(Materials.ancient_wood, Traits.AURA_INFUSION);
                ArmorMaterials.addArmorTrait(Materials.ancient_wood, ArmorTraits.ecological);
                TinkerRegistry.addMaterialStats(Materials.ancient_wood,
                        new CoreMaterialStats(50, 3),
                        new PlatesMaterialStats(1f, 4, 0f),
                        new TrimMaterialStats(0.5f));
            }
        }
        if(Loader.isModLoaded("atum") && Config.atum) {
            if(Config.limestone) {
                ArmorMaterials.addArmorTrait(Materials.limestone, ArmorTraits.cheap);
                ArmorMaterials.addArmorTrait(Materials.limestone, ArmorTraits.cheapskate);
                TinkerRegistry.addMaterialStats(Materials.limestone,
                        new CoreMaterialStats(9f, 5),
                        new PlatesMaterialStats(1f, 20, 0.5f),
                        new TrimMaterialStats(1f));
            }
            if(Config.khnumite) {
                ArmorMaterials.addArmorTrait(Materials.khnumite, ArmorTraits.cheap);
                ArmorMaterials.addArmorTrait(Materials.khnumite, ArmorTraits.cheapskate, ArmorMaterialType.PLATES);
                TinkerRegistry.addMaterialStats(Materials.khnumite,
                        new CoreMaterialStats(5.3f, 3),
                        new PlatesMaterialStats(0.75f, -1.5f, 0f),
                        new TrimMaterialStats(1.75f));
            }
        }
        if((Loader.isModLoaded("astralsorcery") && Config.astral)) {
            ArmorMaterials.addArmorTrait(Materials.starmetal, Traits.astral);
            ArmorMaterials.addArmorTrait(Materials.starmetal, ArmorTraits.alien, ArmorMaterialType.PLATES);
            TinkerRegistry.addMaterialStats(Materials.starmetal,
                    new CoreMaterialStats(12, 15),
                    new PlatesMaterialStats(0.85f, 5, 0f),
                    new TrimMaterialStats(3.5f));
        }

        if(Loader.isModLoaded("mysticalworld") && Config.mysticalworld) {
            ArmorRegistryLib amethyst = new ArmorRegistryLib(Materials.amethyst);
            amethyst.registerMaterialTrait(ArmorTraits.calcic);
            amethyst.setCoreStats(95, 23);
            amethyst.setPlatesStats(0.9f, 85, 1f);
            amethyst.setTrimStats(45);
            amethyst.registerArmor();
        }

        if(Loader.isModLoaded("roots") && Config.roots) {
            ArmorRegistryLib runestone = new ArmorRegistryLib(Materials.runestone);
            runestone.registerMaterialTrait(ArmorTraits.cheap);
            runestone.setCoreStats(80, 15);
            runestone.setPlatesStats(1, 80, 0f);
            runestone.setTrimStats(45);
            runestone.registerArmor();
        }
        if(Loader.isModLoaded("bigreactors") && Config.extreme) {
            ArmorRegistryLib yellorium = new ArmorRegistryLib(Materials.yellorium);
            yellorium.registerMaterialTrait(Traits.radioactive);
            yellorium.setCoreStats(95, 20);
            yellorium.setPlatesStats(1, 85, 1f);
            yellorium.setTrimStats(45);
            yellorium.registerArmor();

            ArmorRegistryLib blutonium = new ArmorRegistryLib(Materials.blutonium);
            blutonium.registerMaterialTrait(Traits.nuclearwaste);
            blutonium.setCoreStats(95, 20);
            blutonium.setPlatesStats(1, 85, 1f);
            blutonium.setTrimStats(45);
            blutonium.registerArmor();
        }
    }
    public void init(FMLInitializationEvent e) {

    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
