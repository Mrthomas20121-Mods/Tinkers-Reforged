package mrthomas20121.tinkers_reforged.modules;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import de.ellpeck.actuallyadditions.mod.items.InitItems;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.modifier.ModEnderStar;
import mrthomas20121.tinkers_reforged.trait.modifier.ModLensKiller;
import mrthomas20121.tinkers_reforged.trait.modifier.ModLensMiner;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAA implements ModuleBase {

    public static MaterialGen blackquartz = new MaterialGen("blackquartz", 0x161515, "QuartzBlack", 700, true);
    public static MaterialGen restonia = new MaterialGen("restonia", 0xF30000, "Restonia", 500, true);
    public static MaterialGen palis = new MaterialGen("palis", 0x1E1B88, "Palis", 700, true);
    public static MaterialGen diamatine = new MaterialGen("diamatine", 0x9A9CFF, "Diamatine", 700, true);
    public static MaterialGen void_crystal = new MaterialGen("void_crystal", 0x171717, "Void", 700, true);
    public static MaterialGen emeradic = new MaterialGen("emeradic", 0x15EA0A, "Emeradic", 700, true);
    public static MaterialGen enori = new MaterialGen("enori", 0xF6F3FF, "Enori", 700, true);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.black_quartz) {
            blackquartz.preInit();
            blackquartz.getMaterial().addTrait(TinkerTraits.crude2, MaterialTypes.HEAD);
            blackquartz.getMaterial().addTrait(TinkerTraits.sharp);
            TinkerRegistry.addMaterial(blackquartz.getMaterial());
            TinkerRegistry.addMaterialStats(blackquartz.getMaterial(),
                    new HeadMaterialStats(304, 6.5f, 6f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(2, 1.4f, 7));
        }

        if(TinkersReforgedConfig.SettingMaterials.materials.restonia) {
            restonia.preInit();
            restonia.getMaterial().addTrait(ReforgedTraits.flux);
            TinkerRegistry.addMaterial(restonia.getMaterial());
            TinkerRegistry.addMaterialStats(restonia.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));
        }

        if(TinkersReforgedConfig.SettingMaterials.materials.palis) {
            palis.preInit();
            palis.getMaterial().addTrait(ReforgedTraits.rose);
            TinkerRegistry.addMaterial(palis.getMaterial());
            TinkerRegistry.addMaterialStats(palis.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));
        }

        if(TinkersReforgedConfig.SettingMaterials.materials.diamatine) {
            diamatine.preInit();
            diamatine.getMaterial().addTrait(ReforgedTraits.carbon);
            TinkerRegistry.addMaterial(diamatine.getMaterial());
            TinkerRegistry.addMaterialStats(diamatine.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));
        }

        if(TinkersReforgedConfig.SettingMaterials.materials.void_crystal) {
            void_crystal.preInit();
            void_crystal.getMaterial().addTrait(ReforgedTraits.voidTrait);
            TinkerRegistry.addMaterial(void_crystal.getMaterial());
            TinkerRegistry.addMaterialStats(void_crystal.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));
        }

        if(TinkersReforgedConfig.SettingMaterials.materials.emeradic) {
            emeradic.preInit();
            emeradic.getMaterial().addTrait(ReforgedTraits.villagerLove, MaterialTypes.HEAD);
            emeradic.getMaterial().addTrait(ReforgedTraits.curse);
            TinkerRegistry.addMaterial(emeradic.getMaterial());
            TinkerRegistry.addMaterialStats(emeradic.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));
        }

        if(TinkersReforgedConfig.SettingMaterials.materials.enori) {
            enori.preInit();
            enori.getMaterial().addTrait(ReforgedTraits.starMagnetism, MaterialTypes.HEAD);
            enori.getMaterial().addTrait(ReforgedTraits.starShaped);
            TinkerRegistry.addMaterial(enori.getMaterial());
            TinkerRegistry.addMaterialStats(enori.getMaterial(),
                    new HeadMaterialStats(450, 6.7f, 6.2f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.2f, 60),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(10, 1.2f, 3));
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

        if(TinkersReforgedConfig.SettingMaterials.materials.black_quartz) {
            blackquartz.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.restonia) {
            restonia.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.palis) {
            palis.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.diamatine) {
            diamatine.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.void_crystal) {
            void_crystal.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.emeradic) {
            emeradic.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.enori) {
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
