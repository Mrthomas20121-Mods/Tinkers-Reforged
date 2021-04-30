package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class MaterialsPixelmon extends ModuleReforgedBase {

    private MaterialGen firestone = new MaterialGen("firestone", 0xE98E33, "Firestone", 500, true);
    private MaterialGen waterstone = new MaterialGen("waterstone", 0x5D75A5, "Waterstone", 500, true);
    private MaterialGen leafstone = new MaterialGen("leafstone", 0x798957, "Leafstone", 500, true);
    private MaterialGen thunderstone = new MaterialGen("thunderstone", 0xB3DCAB, "Thunderstone", 500, true);
    private MaterialGen sunstone = new MaterialGen("sunstone", 0xD75A2B, "Sunstone", 500, true);
    private MaterialGen dawnstone = new MaterialGen("dawnstone", 0x0EBCB1, "Dawnstone", 500, true);
    private MaterialGen duskstone = new MaterialGen("duskstone", 0x795291, "Duskstone", 500, true);
    private MaterialGen crystal = new MaterialGen("crystal", 0x94D3D3, "Crystal", 800, true);

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.pixelmon;
    }

    @Override
    public void preInit() {
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
    public void init() {
        OreDictionary.registerOre("oreWaterstone", ForgeUtils.getBlock(Reference.pixelmon, "water_stone_ore"));
        OreDictionary.registerOre("gemWaterstone", ForgeUtils.getItem(Reference.pixelmon, "water_stone"));
        OreDictionary.registerOre("nuggetWaterstone", ForgeUtils.getItem(Reference.pixelmon, "water_stone_shard"));

        OreDictionary.registerOre("oreFirestone", ForgeUtils.getBlock(Reference.pixelmon, "fire_stone_ore"));
        OreDictionary.registerOre("gemFirestone", ForgeUtils.getItem(Reference.pixelmon, "fire_stone"));
        OreDictionary.registerOre("nuggetFirestone", ForgeUtils.getItem(Reference.pixelmon, "fire_stone_shard"));

        OreDictionary.registerOre("oreLeafstone", ForgeUtils.getBlock(Reference.pixelmon, "leaf_stone_ore"));
        OreDictionary.registerOre("gemLeafstone", ForgeUtils.getItem(Reference.pixelmon, "leaf_stone"));
        OreDictionary.registerOre("nuggetLeafstone", ForgeUtils.getItem(Reference.pixelmon, "leaf_stone_shard"));

        OreDictionary.registerOre("oreThunderstone", ForgeUtils.getBlock(Reference.pixelmon, "thunder_stone_ore"));
        OreDictionary.registerOre("gemThunderstone", ForgeUtils.getItem(Reference.pixelmon, "thunder_stone"));
        OreDictionary.registerOre("nuggetThunderstone", ForgeUtils.getItem(Reference.pixelmon, "thunder_stone_shard"));

        OreDictionary.registerOre("oreSunstone", ForgeUtils.getBlock(Reference.pixelmon, "sun_stone_ore"));
        OreDictionary.registerOre("gemSunstone", ForgeUtils.getItem(Reference.pixelmon, "sun_stone"));
        OreDictionary.registerOre("nuggetSunstone", ForgeUtils.getItem(Reference.pixelmon, "sun_stone_shard"));

        OreDictionary.registerOre("gemDawnstone", ForgeUtils.getItem(Reference.pixelmon, "dawnstone"));
        OreDictionary.registerOre("nuggetDawnstone", ForgeUtils.getItem(Reference.pixelmon, "dawnstone_shard"));

        OreDictionary.registerOre("gemDuskstone", ForgeUtils.getItem(Reference.pixelmon, "duskstone"));
        OreDictionary.registerOre("nuggetDuskstone", ForgeUtils.getItem(Reference.pixelmon, "duskstone_shard"));

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
}
