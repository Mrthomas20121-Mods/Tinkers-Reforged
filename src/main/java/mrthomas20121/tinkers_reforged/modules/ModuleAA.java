package mrthomas20121.tinkers_reforged.modules;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import de.ellpeck.actuallyadditions.mod.items.InitItems;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.biolib.util.ConarmUtil;
import mrthomas20121.tinkers_reforged.MaterialGen;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.*;
import mrthomas20121.tinkers_reforged.trait.modifier.ModEnderStar;
import mrthomas20121.tinkers_reforged.trait.modifier.ModLensKiller;
import mrthomas20121.tinkers_reforged.trait.modifier.ModLensMiner;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAA implements ModuleBase {

    MaterialGen blackquartz = new MaterialGen("blackquartz", 0x161515, "BlackQuartz", 700, 1);
    MaterialGen restonia = new MaterialGen("restonia", 0xF30000, "Restonia", 500, 1);
    MaterialGen palis = new MaterialGen("palis", 0x1E1B88, "Palis", 700, 1);
    MaterialGen diamatine = new MaterialGen("diamatine", 0x9A9CFF, "Diamatine", 700, 1);
    MaterialGen void_crystal = new MaterialGen("void", 0x171717, "Void", 700, 1);
    MaterialGen emeradic = new MaterialGen("emeradic", 0x15EA0A, "Emeradic", 700, 1);
    MaterialGen enori = new MaterialGen("enori", 0x15EA0A, "Enori", 700, 1);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(blackquartz.getIdentifier())) {
            blackquartz.preInit();
            blackquartz.getMaterial().addTrait(TinkerTraits.crude2, MaterialTypes.HEAD);
            blackquartz.getMaterial().addTrait(TinkerTraits.sharp);
            TinkerRegistry.addMaterial(blackquartz.getMaterial());
            TinkerRegistry.addMaterialStats(blackquartz.getMaterial(),
                    new HeadMaterialStats(304, 6.5f, 6f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(2, 1.4f, 7));

            if(Loader.isModLoaded("conarm")) {
                ConarmUtil.addArmorMat(blackquartz.getMaterial(), 0);
            }
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(restonia.getIdentifier())) {
            restonia.preInit();
            restonia.getMaterial().addTrait(new TraitFlux());
            TinkerRegistry.addMaterial(restonia.getMaterial());
            TinkerRegistry.addMaterialStats(restonia.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));

            if(Loader.isModLoaded("conarm")) {
                ConarmUtil.addArmorMat(restonia.getMaterial(), 0);
            }
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(palis.getIdentifier())) {
            palis.preInit();
            palis.getMaterial().addTrait(new TraitRose());
            TinkerRegistry.addMaterial(palis.getMaterial());
            TinkerRegistry.addMaterialStats(palis.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));

            if(Loader.isModLoaded("conarm")) {
                ConarmUtil.addArmorMat(palis.getMaterial(), 0);
            }
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(diamatine.getIdentifier())) {
            diamatine.preInit();
            diamatine.getMaterial().addTrait(new TraitCarbon());
            TinkerRegistry.addMaterial(diamatine.getMaterial());
            TinkerRegistry.addMaterialStats(diamatine.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));

            if(Loader.isModLoaded("conarm")) {
                ConarmUtil.addArmorMat(diamatine.getMaterial(), 0);
            }
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(void_crystal.getIdentifier())) {
            void_crystal.preInit();
            void_crystal.getMaterial().addTrait(new TraitVoid());
            TinkerRegistry.addMaterial(void_crystal.getMaterial());
            TinkerRegistry.addMaterialStats(void_crystal.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));

            if(Loader.isModLoaded("conarm")) {
                ConarmUtil.addArmorMat(void_crystal.getMaterial(), 0);
            }
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(void_crystal.getIdentifier())) {
            emeradic.preInit();
            emeradic.getMaterial().addTrait(new TraitVillagerLove(1), MaterialTypes.HEAD);
            emeradic.getMaterial().addTrait(new TraitCurse());
            TinkerRegistry.addMaterial(emeradic.getMaterial());
            TinkerRegistry.addMaterialStats(emeradic.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));

            if(Loader.isModLoaded("conarm")) {
                ConarmUtil.addArmorMat(emeradic.getMaterial(), 0);
            }
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(enori.getIdentifier())) {
            enori.preInit();
            enori.getMaterial().addTrait(new TraitStarryNight(), MaterialTypes.HEAD);
            enori.getMaterial().addTrait(new TraitStarShaped());
            TinkerRegistry.addMaterial(enori.getMaterial());
            TinkerRegistry.addMaterialStats(enori.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));

            if(Loader.isModLoaded("conarm")) {
                ConarmUtil.addArmorMat(enori.getMaterial(), 0);
            }
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        OreDictionary.registerOre("gemRestonia", new ItemStack(InitItems.itemCrystal, 1, 0));
        OreDictionary.registerOre("gemPalis", new ItemStack(InitItems.itemCrystal, 1, 1));
        OreDictionary.registerOre("gemDiamatine", new ItemStack(InitItems.itemCrystal, 1, 2));
        OreDictionary.registerOre("gemVoid", new ItemStack(InitItems.itemCrystal, 1, 3));
        OreDictionary.registerOre("gemEmeradic", new ItemStack(InitItems.itemCrystal, 1, 4));
        OreDictionary.registerOre("gemEnori", new ItemStack(InitItems.itemCrystal, 1, 5));

        OreDictionary.registerOre("nuggetRestonia", new ItemStack(InitItems.itemCrystalShard, 1, 0));
        OreDictionary.registerOre("nuggetPalis", new ItemStack(InitItems.itemCrystalShard, 1, 1));
        OreDictionary.registerOre("nuggetDiamatine", new ItemStack(InitItems.itemCrystalShard, 1, 2));
        OreDictionary.registerOre("nuggetVoid", new ItemStack(InitItems.itemCrystalShard, 1, 3));
        OreDictionary.registerOre("nuggetEmeradic", new ItemStack(InitItems.itemCrystalShard, 1, 4));
        OreDictionary.registerOre("nuggetEnori", new ItemStack(InitItems.itemCrystalShard, 1, 5));

        OreDictionary.registerOre("blockRestonia", new ItemStack(InitBlocks.blockCrystal, 1, 0));
        OreDictionary.registerOre("blockPalis", new ItemStack(InitBlocks.blockCrystal, 1, 1));
        OreDictionary.registerOre("blockDiamatine", new ItemStack(InitBlocks.blockCrystal, 1, 2));
        OreDictionary.registerOre("blockVoid", new ItemStack(InitBlocks.blockCrystal, 1, 3));
        OreDictionary.registerOre("blockEmeradic", new ItemStack(InitBlocks.blockCrystal, 1, 4));
        OreDictionary.registerOre("blockEnori", new ItemStack(InitBlocks.blockCrystal, 1, 5));

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(blackquartz.getIdentifier())) {
            blackquartz.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(restonia.getIdentifier())) {
            restonia.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(palis.getIdentifier())) {
            palis.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(diamatine.getIdentifier())) {
            diamatine.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(void_crystal.getIdentifier())) {
            void_crystal.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(emeradic.getIdentifier())) {
            emeradic.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(enori.getIdentifier())) {
            enori.init();
        }

        ModEnderStar modEnderStar = new ModEnderStar();
        ModLensKiller modLensKiller = new ModLensKiller();
        ModLensMiner modLensMiner = new ModLensMiner();

        modEnderStar.addItem(new ItemStack(InitItems.itemMisc, 1, 19), 1, 1);
        modLensKiller.addItem(new ItemStack(InitItems.itemMoreDamageLens), 1, 1);
        modLensMiner.addItem(new ItemStack(InitItems.itemMiningLens), 1, 1);

        TinkersReforged.proxy.registerModifierModel(modEnderStar,
                new ResourceLocation(TinkersReforged.MODID, "models/item/modifiers/" + modEnderStar.getIdentifier()));

        TinkersReforged.proxy.registerModifierModel(modLensKiller,
                new ResourceLocation(TinkersReforged.MODID, "models/item/modifiers/" + modLensKiller.getIdentifier()));
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
