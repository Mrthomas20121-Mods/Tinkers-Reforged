package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.biolib.common.SmelteryUtils;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Traits.Traits;

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
        Resources.blackquartz.builder.setTrait(TinkerTraits.crude2, MaterialTypes.HEAD);
        Resources.blackquartz.builder.setTrait(TinkerTraits.sharp);
        Resources.blackquartz.builder.setHeadStats(204, 6, 4, HarvestLevels.DIAMOND);
        Resources.blackquartz.builder.setHandleStats(0.95f, 60);
        Resources.blackquartz.builder.setExtraStats(50);

        Resources.enori.builder.setTrait(Traits.starry_night, MaterialTypes.HEAD);
        Resources.enori.builder.setTrait(Traits.starshaped);
        Resources.enori.builder.setHeadStats(304, 6.5f, 6, HarvestLevels.DIAMOND);
        Resources.enori.builder.setHandleStats(0.95f, 60);
        Resources.enori.builder.setExtraStats(50);

        Resources.redstonia.builder.setTrait(Traits.flux);
        Resources.redstonia.builder.setHeadStats(304, 6.5f, 6, HarvestLevels.DIAMOND);
        Resources.redstonia.builder.setHandleStats(0.95f, 60);
        Resources.redstonia.builder.setExtraStats(50);

        Resources.void_crystal.builder.setTrait(Traits.void_trait);
        Resources.void_crystal.builder.setHeadStats(304, 9.5f, 6, HarvestLevels.DIAMOND);
        Resources.void_crystal.builder.setHandleStats(0.95f, 60);
        Resources.void_crystal.builder.setExtraStats(50);

        Resources.diamantine.builder.setTrait(Traits.carbon);
        Resources.diamantine.builder.setHeadStats(604, 6.9f, 6.1f, HarvestLevels.OBSIDIAN);
        Resources.diamantine.builder.setHandleStats(0.95f, 60);
        Resources.diamantine.builder.setExtraStats(50);

        Resources.emeradic.builder.setTrait(Traits.villager_love, MaterialTypes.HEAD);
        Resources.emeradic.builder.setTrait(Traits.curse);
        Resources.emeradic.builder.setHeadStats(604, 6.9f, 6.1f, HarvestLevels.OBSIDIAN);
        Resources.emeradic.builder.setHandleStats(0.95f, 60);
        Resources.emeradic.builder.setExtraStats(50);

        Resources.palis.builder.setTrait(Traits.rose);
        Resources.palis.builder.setHeadStats(304, 9.5f, 6, HarvestLevels.DIAMOND);
        Resources.palis.builder.setHandleStats(0.95f, 60);
        Resources.palis.builder.setExtraStats(50);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        Resources.blackquartz.registerFluid();
        Resources.enori.registerFluid();
        Resources.void_crystal.registerFluid();
        Resources.emeradic.registerFluid();
        Resources.palis.registerFluid();
        Resources.palis.registerFluid();
        Resources.redstonia.registerFluid();
        Resources.diamantine.registerFluid();

        if(ConfigMaterials.blackquartz)
        {
            Resources.blackquartz.builder.addGem("QuartzBlack");
            Resources.blackquartz.builder.preInit("QuartzBlack", "gem", FluidRegistry.getFluid("black_quartz"));
            Resources.materials.add(Resources.blackquartz);
        }

        if(ConfigMaterials.enori)
        {
            Resources.enori.builder.addItem("gemEnori", Material.VALUE_Ingot);
            Resources.enori.builder.preInit("Enori", "gem", FluidRegistry.getFluid("enori"));
            Resources.materials.add(Resources.enori);
        }

        if(ConfigMaterials.void_crystal)
        {
            Resources.void_crystal.builder.preInit("Void", "gem", FluidRegistry.getFluid("void"));
            Resources.materials.add(Resources.void_crystal);
        }

        if(ConfigMaterials.emeradic)
        {
            Resources.emeradic.builder.preInit("Emeradic", "gem", FluidRegistry.getFluid("emeradic"));
            Resources.materials.add(Resources.emeradic);
        }

        if(ConfigMaterials.palis)
        {
            Resources.palis.builder.preInit("Palis", "gem", FluidRegistry.getFluid("palis"));
            Resources.materials.add(Resources.palis);
        }

        if(ConfigMaterials.redstonia)
        {
            Resources.redstonia.builder.preInit("Redstonia", "gem", FluidRegistry.getFluid("redstonia"));
            Resources.materials.add(Resources.redstonia);
        }

        if(ConfigMaterials.diamantine)
        {
            Resources.diamantine.builder.preInit("Diamantine", "gem", FluidRegistry.getFluid("diamantine"));
            Resources.materials.add(Resources.diamantine);
        }

        if(Loader.isModLoaded("conarm"))
        {
            if(ConfigMaterials.blackquartz) armorUtils.setArmorStats(Resources.blackquartz.builder, 0);
            if(ConfigMaterials.enori) armorUtils.setArmorStats(Resources.enori.builder, 0);
            if(ConfigMaterials.void_crystal) armorUtils.setArmorStats(Resources.void_crystal.builder, 0);
            if(ConfigMaterials.emeradic) armorUtils.setArmorStats(Resources.emeradic.builder, 0);
            if(ConfigMaterials.palis) armorUtils.setArmorStats(Resources.palis.builder, 0);
            if(ConfigMaterials.redstonia) armorUtils.setArmorStats(Resources.redstonia.builder, 0);
            if(ConfigMaterials.diamantine) armorUtils.setArmorStats(Resources.diamantine.builder, 0);
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
        Resources.blackquartz.builder.setRepresentativeItem("gemQuartzBlack");
        Resources.blackquartz.builder.addItem("gemQuartzBlack", Material.VALUE_Ingot);
        Resources.enori.builder.setRepresentativeItem("gemEnori");
        Resources.enori.builder.addItem("gemEnori", Material.VALUE_Ingot);
        Resources.void_crystal.builder.setRepresentativeItem("gemVoid");
        Resources.void_crystal.builder.addItem("gemVoid", Material.VALUE_Ingot);
        Resources.emeradic.builder.setRepresentativeItem("gemEmeradic");
        Resources.emeradic.builder.addItem("gemEmeradic", Material.VALUE_Ingot);
        Resources.redstonia.builder.setRepresentativeItem("gemRedstonia");
        Resources.redstonia.builder.addItem("gemRedstonia", Material.VALUE_Ingot);
        Resources.diamantine.builder.setRepresentativeItem("gemDiamantine");
        Resources.diamantine.builder.addItem("gemDiamantine", Material.VALUE_Ingot);
        Resources.palis.builder.setRepresentativeItem("gemPalis");
        Resources.palis.builder.addItem("gemPalis", Material.VALUE_Ingot);

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