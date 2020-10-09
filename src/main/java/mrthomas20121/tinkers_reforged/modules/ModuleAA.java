package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.biolib.common.SmelteryUtils;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.trait.Traits;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import de.ellpeck.actuallyadditions.mod.items.*;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

import static slimeknights.tconstruct.smeltery.TinkerSmeltery.castIngot;
import static slimeknights.tconstruct.smeltery.TinkerSmeltery.castNugget;

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

        if(ConfigMaterials.blackquartz)
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

        if(ConfigMaterials.enori)
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

        if(ConfigMaterials.void_crystal)
        {
            Resources.void_crystal.addTrait(Traits.void_trait);
            Resources.void_crystal.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.void_crystal, gemStats, 0);
            }

            Resources.materials.add(Resources.void_crystal);
        }

        if(ConfigMaterials.emeradic)
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

        if(ConfigMaterials.palis)
        {
            Resources.palis.addTrait(Traits.rose);
            Resources.palis.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.palis, gemStats, 0);
            }

            Resources.materials.add(Resources.palis);
        }

        if(ConfigMaterials.redstonia)
        {
            Resources.redstonia.addTrait(Traits.flux);
            Resources.redstonia.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.redstonia, gemStats, 0);
            }

            Resources.materials.add(Resources.redstonia);
        }

        if(ConfigMaterials.diamantine)
        {
            Resources.diamantine.addTrait(Traits.carbon);
            Resources.diamantine.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.diamantine, gemStats, 0);
            }

            Resources.materials.add(Resources.diamantine);
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        OredictHelper.RegisterGemItem("Redstonia", new ItemStack(InitItems.itemCrystal, 1, 0));
        OredictHelper.RegisterGemItem("Palis", new ItemStack(InitItems.itemCrystal, 1, 1));
        OredictHelper.RegisterGemItem("Diamantine", new ItemStack(InitItems.itemCrystal, 1, 2));
        OredictHelper.RegisterGemItem("Void", new ItemStack(InitItems.itemCrystal, 1, 3));
        OredictHelper.RegisterGemItem("Emeradic", new ItemStack(InitItems.itemCrystal, 1, 4));
        OredictHelper.RegisterGemItem("Enori", new ItemStack(InitItems.itemCrystal, 1, 5));

        OredictHelper.RegisterNuggetItem("Redstonia", new ItemStack(InitItems.itemCrystalShard, 1, 0));
        OredictHelper.RegisterNuggetItem("Palis", new ItemStack(InitItems.itemCrystalShard, 1, 1));
        OredictHelper.RegisterNuggetItem("Diamantine", new ItemStack(InitItems.itemCrystalShard, 1, 2));
        OredictHelper.RegisterNuggetItem("Void", new ItemStack(InitItems.itemCrystalShard, 1, 3));
        OredictHelper.RegisterNuggetItem("Emeradic", new ItemStack(InitItems.itemCrystalShard, 1, 4));
        OredictHelper.RegisterNuggetItem("Enori", new ItemStack(InitItems.itemCrystalShard, 1, 5));

        OredictHelper.RegisterBlock("Redstonia", new ItemStack(InitBlocks.blockCrystal, 1, 0));
        OredictHelper.RegisterBlock("Palis", new ItemStack(InitBlocks.blockCrystal, 1, 1));
        OredictHelper.RegisterBlock("Diamantine", new ItemStack(InitBlocks.blockCrystal, 1, 2));
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
        Resources.redstonia.getMaterial().setRepresentativeItem("gemRedstonia");
        Resources.redstonia.getMaterial().addItem("gemRedstonia", 1, Material.VALUE_Ingot);
        Resources.diamantine.getMaterial().setRepresentativeItem("gemDiamantine");
        Resources.diamantine.getMaterial().addItem("gemDiamantine", 1, Material.VALUE_Ingot);
        Resources.palis.getMaterial().setRepresentativeItem("gemPalis");
        Resources.palis.getMaterial().addItem("gemPalis", 1, Material.VALUE_Ingot);

        registerGems("QuartzBlack", "blackquartz", true);
        registerGems("Enori", "enori", false);
        registerGems("Void", "void", false);
        registerGems("Emeradic", "emeradic", false);
        registerGems("Palis", "palis", false);
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
    private void registerGems(String ore, String fluid, boolean small) {
        SmelteryUtils.registerCasting("nugget"+ore, castNugget, FluidRegistry.getFluid(fluid), Material.VALUE_Nugget);
        SmelteryUtils.registerCasting("gem"+ore, castIngot, FluidRegistry.getFluid(fluid), Material.VALUE_Ingot);
        SmelteryUtils.registerMelting("gem"+ore, FluidRegistry.getFluid(fluid), Material.VALUE_Ingot);
        SmelteryUtils.registerMelting("block"+ore, FluidRegistry.getFluid(fluid), Material.VALUE_Block);
        if(small) {
            SmelteryUtils.registerSmallBlockCasting(ore, FluidRegistry.getFluid(fluid));
        }
        else {
            SmelteryUtils.registerBlockCasting(ore, FluidRegistry.getFluid(fluid));
        }
    }
}