package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.MaterialGen;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.TraitRefined;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleCavern2 implements ModuleBase {

    Material aquamarine = new Material("aquamarine", 0xA7E7E5);
    Material hexcite = new Material("hexcite", 0xDEDEDE);
    MaterialGen magnite = new MaterialGen("magnite", 0xD22700, "Magnite", 500);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(hexcite.getIdentifier())) {
            hexcite.addTrait(new TraitRefined());
            TinkerRegistry.addMaterial(hexcite);
            TinkerRegistry.addMaterialStats(hexcite,
                    new HeadMaterialStats(204, 5f, 5f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1f, 100),
                    new ExtraMaterialStats(10));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(aquamarine.getIdentifier())) {
            aquamarine.addTrait(TinkerTraits.aquadynamic);
            TinkerRegistry.addMaterial(aquamarine);
            TinkerRegistry.addMaterialStats(aquamarine,
                    new HeadMaterialStats(204, 6f, 4f, HarvestLevels.IRON),
                    new HandleMaterialStats(0.5f, 100),
                    new ExtraMaterialStats(10));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(magnite.getIdentifier())) {
            magnite.preInit();
            magnite.getMaterial().addTrait(TinkerTraits.stonebound);
            TinkerRegistry.addMaterial(magnite.getMaterial());
            TinkerRegistry.addMaterialStats(magnite.getMaterial(),
                    new HeadMaterialStats(204, 5f, 5f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1f, 100),
                    new ExtraMaterialStats(10));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(hexcite.getIdentifier())) {
            hexcite.setCraftable(true);
            hexcite.addItem("gemHexcite", 1, Material.VALUE_Ingot);
            hexcite.setRepresentativeItem("gemHexcite");
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(aquamarine.getIdentifier())) {

        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(magnite.getIdentifier())) {
            magnite.init();
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
