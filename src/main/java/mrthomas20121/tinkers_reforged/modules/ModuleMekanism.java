package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.MaterialGen;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.TraitBright;
import mrthomas20121.tinkers_reforged.trait.TraitRefined;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleMekanism implements ModuleBase {

    private MaterialGen osmium = new MaterialGen("osmium", 0x7F8EB2, "Osmium", 700);
    private MaterialGen refined_obsidian = new MaterialGen("refined_obsidian", 0x463763, "Obsidian",700);
    private MaterialGen refined_glownstone = new MaterialGen("refined_glowstone", 0xEAC829, "Glowstone", 700);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(osmium.getIdentifier())) {
            osmium.preInit();
            osmium.getMaterial().addTrait(TinkerTraits.established, MaterialTypes.HEAD);
            osmium.getMaterial().addTrait(TinkerTraits.dense);
            TinkerRegistry.addMaterial(osmium.getMaterial());
            TinkerRegistry.addMaterialStats(osmium.getMaterial(),
                    new HeadMaterialStats(410, 5.5f, 5.5f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 80),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(2.9f, 7, 5.1f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(refined_obsidian.getIdentifier())) {
            refined_obsidian.preInit();
            refined_obsidian.getMaterial().addTrait(new TraitRefined(), MaterialTypes.HEAD);
            refined_obsidian.getMaterial().addTrait(TinkerTraits.duritos);
            TinkerRegistry.addMaterial(refined_obsidian.getMaterial());
            TinkerRegistry.addMaterialStats(refined_obsidian.getMaterial(),
                    new HeadMaterialStats(550, 6.5f, 6.5f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1.2f, 100),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(3.2f, 5, 6.1f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(refined_glownstone.getIdentifier())) {
            refined_glownstone.preInit();
            refined_glownstone.getMaterial().addTrait(new TraitRefined(), MaterialTypes.HEAD);
            refined_glownstone.getMaterial().addTrait(new TraitBright());
            TinkerRegistry.addMaterial(refined_glownstone.getMaterial());
            TinkerRegistry.addMaterialStats(refined_glownstone.getMaterial(),
                    new HeadMaterialStats(550, 6.5f, 6.5f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1.2f, 100),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(3.2f, 5, 6.1f));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(osmium.getIdentifier())) {
            osmium.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(refined_obsidian.getIdentifier())) {
            refined_obsidian.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(refined_glownstone.getIdentifier())) {
            refined_glownstone.init();
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
