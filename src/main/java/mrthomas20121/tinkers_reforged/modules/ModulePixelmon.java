package mrthomas20121.tinkers_reforged.modules;

import com.pixelmonmod.pixelmon.config.PixelmonBlocks;
import com.pixelmonmod.pixelmon.config.PixelmonItems;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModulePixelmon implements ModuleBase {

    MaterialGen firestone = new MaterialGen("firestone", 0xE98E33, "Firestone", 500, true);
    MaterialGen waterstone = new MaterialGen("waterstone", 0x5D75A5, "Waterstone", 500, true);
    MaterialGen leafstone = new MaterialGen("leafstone", 0x798957, "Leafstone", 500, true);
    MaterialGen thunderstone = new MaterialGen("thunderstone", 0xB3DCAB, "Thunderstone", 500, true);
    MaterialGen sunstone = new MaterialGen("sunstone", 0xD75A2B, "Sunstone", 500, true);
    MaterialGen dawnstone = new MaterialGen("dawnstone", 0x0EBCB1, "Dawnstone", 500, true);
    MaterialGen duskstone = new MaterialGen("duskstone", 0x795291, "Duskstone", 500, true);
    MaterialGen crystal = new MaterialGen("crystal", 0x94D3D3, "Crystal", 800, true);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.firestone) {
            firestone.preInit();
            firestone.getMaterial().addTrait(ReforgedTraits.backfire);
            TinkerRegistry.addMaterial(firestone.getMaterial());
            TinkerRegistry.addMaterialStats(firestone.getMaterial(),
                    new HeadMaterialStats(340, 5, 4, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.waterstone) {
            waterstone.preInit();
            waterstone.getMaterial().addTrait(TinkerTraits.aquadynamic);
            TinkerRegistry.addMaterial(waterstone.getMaterial());
            TinkerRegistry.addMaterialStats(waterstone.getMaterial(),
                    new HeadMaterialStats(340, 5, 4, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.leafstone) {
            leafstone.preInit();
            leafstone.getMaterial().addTrait(ReforgedTraits.leafBlower);
            TinkerRegistry.addMaterial(leafstone.getMaterial());
            TinkerRegistry.addMaterialStats(leafstone.getMaterial(),
                    new HeadMaterialStats(300, 4, 3, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.thunderstone) {
            thunderstone.preInit();
            thunderstone.getMaterial().addTrait(ReforgedTraits.rod);
            TinkerRegistry.addMaterial(thunderstone.getMaterial());
            TinkerRegistry.addMaterialStats(thunderstone.getMaterial(),
                    new HeadMaterialStats(300, 2, 1, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.sunstone) {
            sunstone.preInit();
            sunstone.getMaterial().addTrait(ReforgedTraits.bright);
            TinkerRegistry.addMaterial(sunstone.getMaterial());
            TinkerRegistry.addMaterialStats(sunstone.getMaterial(),
                    new HeadMaterialStats(300, 2, 1, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.duskstone) {
            duskstone.preInit();
            duskstone.getMaterial().addTrait(TinkerTraits.poisonous);
            TinkerRegistry.addMaterial(duskstone.getMaterial());
            TinkerRegistry.addMaterialStats(duskstone.getMaterial(),
                    new HeadMaterialStats(300, 2, 1, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.dawnstone) {
            dawnstone.preInit();
            dawnstone.getMaterial().addTrait(ReforgedTraits.lifeSteal);
            TinkerRegistry.addMaterial(dawnstone.getMaterial());
            TinkerRegistry.addMaterialStats(dawnstone.getMaterial(),
                    new HeadMaterialStats(300, 2, 1, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.crystal) {
            crystal.preInit();
            crystal.getMaterial().addTrait(TinkerTraits.sharp);
            TinkerRegistry.addMaterial(crystal.getMaterial());
            TinkerRegistry.addMaterialStats(crystal.getMaterial(),
                    new HeadMaterialStats(300, 2, 1, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        OreDictionary.registerOre("oreWaterstone", PixelmonBlocks.waterStoneOre);
        OreDictionary.registerOre("gemWaterstone", PixelmonItems.waterStone);
        OreDictionary.registerOre("nuggetWaterstone", PixelmonItems.waterStoneShard);

        OreDictionary.registerOre("oreFirestone", PixelmonBlocks.fireStoneOre);
        OreDictionary.registerOre("gemFirestone", PixelmonItems.fireStone);
        OreDictionary.registerOre("nuggetFirestone", PixelmonItems.fireStoneShard);

        OreDictionary.registerOre("oreLeafstone", PixelmonBlocks.leafStoneOre);
        OreDictionary.registerOre("gemLeafstone", PixelmonItems.leafStone);
        OreDictionary.registerOre("nuggetLeafstone", PixelmonItems.leafStoneShard);

        OreDictionary.registerOre("oreThunderstone", PixelmonBlocks.thunderStoneOre);
        OreDictionary.registerOre("gemThunderstone", PixelmonItems.thunderStone);
        OreDictionary.registerOre("nuggetThunderstone", PixelmonItems.thunderStoneShard);

        OreDictionary.registerOre("oreSunstone", PixelmonBlocks.sunStoneOre);
        OreDictionary.registerOre("gemSunstone", PixelmonItems.sunStone);
        OreDictionary.registerOre("nuggetSunstone", PixelmonItems.sunStoneShard);

        OreDictionary.registerOre("gemDawnstone", PixelmonItems.dawnStone);
        OreDictionary.registerOre("nuggetDawnstone", PixelmonItems.dawnStoneShard);

        OreDictionary.registerOre("gemDuskstone", PixelmonItems.duskStone);
        OreDictionary.registerOre("nuggetDuskstone", PixelmonItems.duskStoneShard);

        if(TinkersReforgedConfig.SettingMaterials.materials.firestone) {
            firestone.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.waterstone) {
            waterstone.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.leafstone) {
            leafstone.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.thunderstone) {
            thunderstone.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.sunstone) {
            sunstone.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.duskstone) {
            duskstone.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.dawnstone) {
            dawnstone.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.crystal) {
            crystal.init();
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
