package mrthomas20121.tinkers_reforged.modules;

import com.pixelmonmod.pixelmon.config.PixelmonBlocks;
import com.pixelmonmod.pixelmon.config.PixelmonItems;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.MaterialGen;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.*;
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

    MaterialGen fire = new MaterialGen("leafstone", 0xE98E33, "Firestone", 500, 1);
    MaterialGen water = new MaterialGen("waterstone", 0x5D75A5, "Waterstone", 500, 1);
    MaterialGen leaf = new MaterialGen("leafstone", 0x798957, "Leafstone", 500, 1);
    MaterialGen thunder = new MaterialGen("thunderstone", 0xB3DCAB, "Thunderstone", 500, 1);
    MaterialGen sun = new MaterialGen("sunstone", 0xD75A2B, "Sunstone", 500, 1);
    MaterialGen dawn = new MaterialGen("dawnstone", 0x0EBCB1, "Dawnstone", 500, 1);
    MaterialGen dusk = new MaterialGen("duskstone", 0x795291, "Duskstone", 500, 1);
    MaterialGen crystal = new MaterialGen("crystal", 0x94D3D3, "Crystal", 800, 1);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(fire.getIdentifier())) {
            fire.preInit();
            fire.getMaterial().addTrait(new TraitBackfire());
            TinkerRegistry.addMaterial(fire.getMaterial());
            TinkerRegistry.addMaterialStats(fire.getMaterial(),
                    new HeadMaterialStats(340, 5, 4, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(water.getIdentifier())) {
            water.preInit();
            water.getMaterial().addTrait(TinkerTraits.aquadynamic);
            TinkerRegistry.addMaterial(water.getMaterial());
            TinkerRegistry.addMaterialStats(water.getMaterial(),
                    new HeadMaterialStats(340, 5, 4, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(leaf.getIdentifier())) {
            leaf.preInit();
            leaf.getMaterial().addTrait(new TraitLeafBlower());
            TinkerRegistry.addMaterial(leaf.getMaterial());
            TinkerRegistry.addMaterialStats(leaf.getMaterial(),
                    new HeadMaterialStats(300, 4, 3, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(thunder.getIdentifier())) {
            thunder.preInit();
            thunder.getMaterial().addTrait(new TraitRod());
            TinkerRegistry.addMaterial(thunder.getMaterial());
            TinkerRegistry.addMaterialStats(thunder.getMaterial(),
                    new HeadMaterialStats(300, 2, 1, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(sun.getIdentifier())) {
            sun.preInit();
            sun.getMaterial().addTrait(new TraitBright());
            TinkerRegistry.addMaterial(sun.getMaterial());
            TinkerRegistry.addMaterialStats(sun.getMaterial(),
                    new HeadMaterialStats(300, 2, 1, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(dusk.getIdentifier())) {
            dusk.preInit();
            dusk.getMaterial().addTrait(TinkerTraits.poisonous);
            TinkerRegistry.addMaterial(dusk.getMaterial());
            TinkerRegistry.addMaterialStats(dusk.getMaterial(),
                    new HeadMaterialStats(300, 2, 1, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(dawn.getIdentifier())) {
            dawn.preInit();
            dawn.getMaterial().addTrait(new TraitLifeSteal());
            TinkerRegistry.addMaterial(dawn.getMaterial());
            TinkerRegistry.addMaterialStats(dawn.getMaterial(),
                    new HeadMaterialStats(300, 2, 1, HarvestLevels.IRON),
                    new HandleMaterialStats(1, 90),
                    new ExtraMaterialStats(10),
                    new BowMaterialStats(2, 1.5f, 6));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(crystal.getIdentifier())) {
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

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(fire.getIdentifier())) {
            fire.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(water.getIdentifier())) {
            water.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(leaf.getIdentifier())) {
            leaf.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(thunder.getIdentifier())) {
            thunder.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(sun.getIdentifier())) {
            sun.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(dusk.getIdentifier())) {
            dusk.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(dawn.getIdentifier())) {
            dawn.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(crystal.getIdentifier())) {
            crystal.init();
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
