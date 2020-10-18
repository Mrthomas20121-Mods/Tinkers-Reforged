package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.Traits;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import de.ellpeck.actuallyadditions.mod.items.*;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAA implements ModuleBase {

    public ModuleAA() {

    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        MaterialStats gemStats = new MaterialStats();
        gemStats.setHeadMaterialStats(304, 6.5f, 6f, HarvestLevels.DIAMOND);
        gemStats.setHandleMaterialStats(1.2f, 60);
        gemStats.setExtraMaterialStats(100);
        gemStats.setBowMaterialStats(2f, 1.4f, 7f);

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.blackquartz.getMaterial().getIdentifier()))
        {
            Resources.blackquartz.addTrait(TinkerTraits.crude2, MaterialTypes.HEAD);
            Resources.blackquartz.addTrait(TinkerTraits.sharp);
            Resources.blackquartz.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.blackquartz, gemStats, 0);
            }

            Resources.materials.add(Resources.blackquartz);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.enori.getMaterial().getIdentifier()))
        {
            Resources.enori.addTrait(Traits.starry_night, MaterialTypes.HEAD);
            Resources.enori.addTrait(Traits.starshaped);
            Resources.enori.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.enori, gemStats, 0);
            }

            Resources.materials.add(Resources.enori);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.void_crystal.getMaterial().getIdentifier()))
        {
            Resources.void_crystal.addTrait(Traits.void_trait);
            Resources.void_crystal.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.void_crystal, gemStats, 0);
            }

            Resources.materials.add(Resources.void_crystal);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.emeradic.getMaterial().getIdentifier()))
        {
            Resources.emeradic.addTrait(Traits.villager_love, MaterialTypes.HEAD);
            Resources.emeradic.addTrait(Traits.curse);
            Resources.emeradic.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.emeradic, gemStats, 0);
            }

            Resources.materials.add(Resources.emeradic);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.palis.getMaterial().getIdentifier()))
        {
            Resources.palis.addTrait(Traits.rose);
            Resources.palis.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.palis, gemStats, 0);
            }

            Resources.materials.add(Resources.palis);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.restonia.getMaterial().getIdentifier()))
        {
            Resources.restonia.addTrait(Traits.flux);
            Resources.restonia.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.restonia, gemStats, 0);
            }

            Resources.materials.add(Resources.restonia);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.diamatine.getMaterial().getIdentifier()))
        {
            Resources.diamatine.addTrait(Traits.carbon);
            Resources.diamatine.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.diamatine, gemStats, 0);
            }

            Resources.materials.add(Resources.diamatine);
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        OredictHelper.RegisterGemItem("Restonia", new ItemStack(InitItems.itemCrystal, 1, 0));
        OredictHelper.RegisterGemItem("Palis", new ItemStack(InitItems.itemCrystal, 1, 1));
        OredictHelper.RegisterGemItem("Diamatine", new ItemStack(InitItems.itemCrystal, 1, 2));
        OredictHelper.RegisterGemItem("Void", new ItemStack(InitItems.itemCrystal, 1, 3));
        OredictHelper.RegisterGemItem("Emeradic", new ItemStack(InitItems.itemCrystal, 1, 4));
        OredictHelper.RegisterGemItem("Enori", new ItemStack(InitItems.itemCrystal, 1, 5));

        OredictHelper.RegisterNuggetItem("Restonia", new ItemStack(InitItems.itemCrystalShard, 1, 0));
        OredictHelper.RegisterNuggetItem("Palis", new ItemStack(InitItems.itemCrystalShard, 1, 1));
        OredictHelper.RegisterNuggetItem("Diamantine", new ItemStack(InitItems.itemCrystalShard, 1, 2));
        OredictHelper.RegisterNuggetItem("Void", new ItemStack(InitItems.itemCrystalShard, 1, 3));
        OredictHelper.RegisterNuggetItem("Emeradic", new ItemStack(InitItems.itemCrystalShard, 1, 4));
        OredictHelper.RegisterNuggetItem("Enori", new ItemStack(InitItems.itemCrystalShard, 1, 5));

        OredictHelper.RegisterBlock("Restonia", new ItemStack(InitBlocks.blockCrystal, 1, 0));
        OredictHelper.RegisterBlock("Palis", new ItemStack(InitBlocks.blockCrystal, 1, 1));
        OredictHelper.RegisterBlock("Diamatine", new ItemStack(InitBlocks.blockCrystal, 1, 2));
        OredictHelper.RegisterBlock("Void", new ItemStack(InitBlocks.blockCrystal, 1, 3));
        OredictHelper.RegisterBlock("Emeradic", new ItemStack(InitBlocks.blockCrystal, 1, 4));
        OredictHelper.RegisterBlock("Enori", new ItemStack(InitBlocks.blockCrystal, 1, 5));
        Resources.blackquartz.getMaterial().setRepresentativeItem("gemQuartzBlack");
        Resources.blackquartz.getMaterial().addItem("gemQuartzBlack", 1, Material.VALUE_Ingot);
        Resources.enori.getMaterial().setRepresentativeItem("gemEnori");
        Resources.enori.getMaterial().addItem("gemEnori", 1, Material.VALUE_Ingot);
        Resources.void_crystal.getMaterial().setRepresentativeItem("gemVoid");
        Resources.void_crystal.getMaterial().addItem("gemVoid", 1, Material.VALUE_Ingot);
        Resources.emeradic.getMaterial().setRepresentativeItem("gemEmeradic");
        Resources.emeradic.getMaterial().addItem("gemEmeradic", 1, Material.VALUE_Ingot);
        Resources.restonia.getMaterial().setRepresentativeItem("gemRestonia");
        Resources.restonia.getMaterial().addItem("gemRestonia", 1, Material.VALUE_Ingot);
        Resources.diamatine.getMaterial().setRepresentativeItem("gemDiamatine");
        Resources.diamatine.getMaterial().addItem("gemDiamatine", 1, Material.VALUE_Ingot);
        Resources.palis.getMaterial().setRepresentativeItem("gemPalis");
        Resources.palis.getMaterial().addItem("gemPalis", 1, Material.VALUE_Ingot);
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}