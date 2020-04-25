package com.mrthomas20121.tinkers_reforged.Module;

import c4.conarm.lib.materials.ArmorMaterials;
import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
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
                        new PlatesMaterialStats(1, 90, 3.9f),
                        new TrimMaterialStats(50.5f));
            }
            if(Config.lumium) {
                ArmorMaterials.addArmorTrait(Materials.lumium, Traits.light);
                TinkerRegistry.addMaterialStats(Materials.lumium,
                        new CoreMaterialStats(250, 29),
                        new PlatesMaterialStats(1.1f, 70, 3f),
                        new TrimMaterialStats(50f));
            }
        }
        if(Loader.isModLoaded("naturesaura") && Config.naturesaura) {
            if(Config.infused_iron) {
                ArmorMaterials.addArmorTrait(Materials.infused_iron, Traits.infusing);
                ArmorMaterials.addArmorTrait(Materials.infused_iron, ArmorTraits.magnetic2);
                TinkerRegistry.addMaterialStats(Materials.infused_iron,
                        new CoreMaterialStats(12, 15),
                        new PlatesMaterialStats(0.85f, 5, 0f),
                        new TrimMaterialStats(3.5f));
            }
            if(Config.ancient_wood) {
                ArmorMaterials.addArmorTrait(Materials.ancient_wood, Traits.infusing);
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
                ArmorMaterials.addArmorTrait(Materials.khnumite, ArmorTraits.cheapskate);
                TinkerRegistry.addMaterialStats(Materials.khnumite,
                        new CoreMaterialStats(5.3f, 3),
                        new PlatesMaterialStats(0.75f, -1.5f, 0f),
                        new TrimMaterialStats(1.75f));
            }
        }
    }
    public void init(FMLInitializationEvent e) {

    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
