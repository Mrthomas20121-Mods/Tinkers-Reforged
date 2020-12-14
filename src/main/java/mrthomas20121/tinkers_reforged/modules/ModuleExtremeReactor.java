package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.MaterialGen;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class ModuleExtremeReactor implements ModuleBase {

    MaterialGen yellorium = new MaterialGen("yellorium", 0xD9DB5C, "Yellorium", 800);
    MaterialGen cyanite = new MaterialGen("cyanite", 0x5CAFDB, "Cyanite", 800);
    MaterialGen ludicrite = new MaterialGen("ludicrite", 0xDD5EDD, "Ludicrite", 800);
    MaterialGen blutonium = new MaterialGen("blutonium", 0x4642D6, "Blutonium", 1000);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(yellorium.getIdentifier())) {
            TinkerRegistry.addMaterial(yellorium.getMaterial());
            TinkerRegistry.addMaterialStats(yellorium.getMaterial(),
                    new HeadMaterialStats(200, 5.3f, 5.3f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1.1f, 100),
                    new ExtraMaterialStats(5),
                    new BowMaterialStats(5.3f, 5.5f, 5.3f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(cyanite.getIdentifier())) {
            TinkerRegistry.addMaterial(cyanite.getMaterial());
            TinkerRegistry.addMaterialStats(cyanite.getMaterial(),
                    new HeadMaterialStats(200, 5.3f, 5.3f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1.1f, 30),
                    new ExtraMaterialStats(5),
                    new BowMaterialStats(2.3f, 5.2f, 4.3f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(ludicrite.getIdentifier())) {
            TinkerRegistry.addMaterial(ludicrite.getMaterial());
            TinkerRegistry.addMaterialStats(ludicrite.getMaterial(),
                    new HeadMaterialStats(200, 5.3f, 5.3f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1.1f, 100),
                    new ExtraMaterialStats(5),
                    new BowMaterialStats(7.1f, 5.1f, 3.1f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(blutonium.getIdentifier())) {
            TinkerRegistry.addMaterial(blutonium.getMaterial());
            TinkerRegistry.addMaterialStats(blutonium.getMaterial(),
                    new HeadMaterialStats(200, 5.3f, 5.3f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1.1f, 100),
                    new ExtraMaterialStats(5),
                    new BowMaterialStats(2.1f, 10.1f, 5.1f));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(yellorium.getIdentifier())) {
            yellorium.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(cyanite.getIdentifier())) {
            cyanite.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(ludicrite.getIdentifier())) {
            ludicrite.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(blutonium.getIdentifier())) {
            blutonium.init();
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
