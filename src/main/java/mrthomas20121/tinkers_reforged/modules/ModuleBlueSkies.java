package mrthomas20121.tinkers_reforged.modules;

import com.legacy.blue_skies.blocks.BlocksSkies;
import com.legacy.blue_skies.items.ItemsSkies;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.MaterialGen;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.TraitFast;
import mrthomas20121.tinkers_reforged.trait.TraitPyromancy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleBlueSkies implements ModuleBase {

    MaterialGen horizonnite = new MaterialGen("horizonite", 0xF27B2B, "Horizonite", 700);
    MaterialGen charoite = new MaterialGen("charoite", 0x9A7FBA, "Charoite", 500);
    MaterialGen diopside = new MaterialGen("diopside", 0x4CE849, "Diopside", 500);
    MaterialGen pyrope = new MaterialGen("pyrope", 0xDA283E, "Pyrope", 500);
    MaterialGen turquoise = new MaterialGen("turquoise", 0xDA283E, "Turquoise", 500);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(horizonnite.getIdentifier())) {
            horizonnite.preInit();
            horizonnite.getMaterial().addTrait(TinkerTraits.autosmelt, MaterialTypes.HEAD);
            horizonnite.getMaterial().addTrait(new TraitPyromancy());
            TinkerRegistry.addMaterial(horizonnite.getMaterial());
            TinkerRegistry.addMaterialStats(horizonnite.getMaterial(),
                    new HeadMaterialStats(200, 6.3f, 4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.9f, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(3.5f, 2.2f, 4.2f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(charoite.getIdentifier())) {
            charoite.preInit();
            charoite.getMaterial().addTrait(TinkerTraits.lightweight);
            TinkerRegistry.addMaterial(charoite.getMaterial());
            TinkerRegistry.addMaterialStats(charoite.getMaterial(),
                    new HeadMaterialStats(200, 6.3f, 4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.9f, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2.5f, 3.2f, 3.2f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(diopside.getIdentifier())) {
            diopside.preInit();
            diopside.getMaterial().addTrait(TinkerTraits.sharp);
            TinkerRegistry.addMaterial(diopside.getMaterial());
            TinkerRegistry.addMaterialStats(diopside.getMaterial(),
                    new HeadMaterialStats(400, 8f, 8f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 90),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(3, 8.2f, 2.1f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(pyrope.getIdentifier())) {
            pyrope.preInit();
            pyrope.getMaterial().addTrait(new TraitFast());
            TinkerRegistry.addMaterial(pyrope.getMaterial());
            TinkerRegistry.addMaterialStats(pyrope.getMaterial(),
                    new HeadMaterialStats(200, 6.3f, 4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.9f, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(3.5f, 2.2f, 4.2f));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        OreDictionary.registerOre("ingotVentium", ItemsSkies.ventium_ingot);
        OreDictionary.registerOre("bucketVentium", ItemsSkies.ventium_bucket);
        OreDictionary.registerOre("oreVentium", BlocksSkies.ventium_ore);
        OreDictionary.registerOre("ingotHorizonite", ItemsSkies.horizonite_ingot);
        OreDictionary.registerOre("oreHorizonite", BlocksSkies.horizonite_ore);
        OreDictionary.registerOre("blockHorizonnite", BlocksSkies.horizonite_block);
        OreDictionary.registerOre("ingotFalsite", ItemsSkies.falsite_ingot);
        OreDictionary.registerOre("oreFalsite", BlocksSkies.falsite_ore);
        OreDictionary.registerOre("gemPyrope", ItemsSkies.pyrope_gem);
        OreDictionary.registerOre("orePyrope", BlocksSkies.everbright_pyrope_ore);
        OreDictionary.registerOre("orePyrope", BlocksSkies.everdawn_pyrope_ore);
        OreDictionary.registerOre("blockPyrope", BlocksSkies.pyrope_block);
        OreDictionary.registerOre("gemTurquoise", ItemsSkies.turquoise_gem);
        OreDictionary.registerOre("oreTurquoise", BlocksSkies.everbright_turquoise_ore);
        OreDictionary.registerOre("oreTurquoise", BlocksSkies.everdawn_turquoise_ore);
        OreDictionary.registerOre("blockTurquoise", BlocksSkies.turquoise_block);
        OreDictionary.registerOre("gemCharoite", ItemsSkies.charoite);
        OreDictionary.registerOre("oreCharoite", BlocksSkies.everbright_charoite_ore);
        OreDictionary.registerOre("oreCharoite", BlocksSkies.everdawn_charoite_ore);
        OreDictionary.registerOre("gemDiopside", ItemsSkies.diopside_gem);
        OreDictionary.registerOre("oreDiopside", BlocksSkies.everbright_diopside_ore);
        OreDictionary.registerOre("oreDiopside", BlocksSkies.everdawn_diopside_ore);

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(horizonnite.getIdentifier())) {
            horizonnite.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(charoite.getIdentifier())) {
            charoite.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(diopside.getIdentifier())) {
            diopside.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(pyrope.getIdentifier())) {
            pyrope.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(turquoise.getIdentifier())) {
            turquoise.init();
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
