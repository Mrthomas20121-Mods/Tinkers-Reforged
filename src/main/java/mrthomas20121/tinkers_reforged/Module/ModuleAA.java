package mrthomas20121.tinkers_reforged.Module;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.SmelteryUtils;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import de.ellpeck.actuallyadditions.mod.items.*;
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
  
    public MaterialBuilder blackquartz = new MaterialBuilder(Materials.blackquartz);
    public MaterialBuilder enori = new MaterialBuilder(Materials.enori);
    public MaterialBuilder redstonia = new MaterialBuilder(Materials.redstonia);
    public MaterialBuilder voidCrystal = new MaterialBuilder(Materials.void_crystal);
    public MaterialBuilder diamantine = new MaterialBuilder(Materials.diamantine);
    public MaterialBuilder emeradic = new MaterialBuilder(Materials.emeradic);
    public MaterialBuilder palis = new MaterialBuilder(Materials.palis);

    public ModuleAA() {
        blackquartz.setCraftable(false).setCastable(true);
        blackquartz.setTrait(TinkerTraits.crude2, MaterialTypes.HEAD);
        blackquartz.setTrait(TinkerTraits.sharp);
        blackquartz.setHeadStats(204, 6, 4, HarvestLevels.DIAMOND);
        blackquartz.setHandleStats(0.95f, 60);
        blackquartz.setExtraStats(50);

        enori.setTrait(Traits.starry_night, MaterialTypes.HEAD);
        enori.setTrait(Traits.starshaped);
        enori.setCraftable(false).setCastable(true);
        enori.setHeadStats(304, 6.5f, 6, HarvestLevels.DIAMOND);
        enori.setHandleStats(0.95f, 60);
        enori.setExtraStats(50);

        redstonia.setTrait(Traits.flux);
        redstonia.setCraftable(false).setCastable(true);
        redstonia.setHeadStats(304, 6.5f, 6, HarvestLevels.DIAMOND);
        redstonia.setHandleStats(0.95f, 60);
        redstonia.setExtraStats(50);

        voidCrystal.setTrait(Traits.void_trait);
        voidCrystal.setCraftable(false).setCastable(true);
        voidCrystal.setHeadStats(304, 9.5f, 6, HarvestLevels.DIAMOND);
        voidCrystal.setHandleStats(0.95f, 60);
        voidCrystal.setExtraStats(50);

        diamantine.setTrait(Traits.carbon);
        diamantine.setCraftable(false).setCastable(true);
        diamantine.setHeadStats(604, 6.9f, 6.1f, HarvestLevels.OBSIDIAN);
        diamantine.setHandleStats(0.95f, 60);
        diamantine.setExtraStats(50);

        emeradic.setTrait(Traits.villager_love, MaterialTypes.HEAD);
        emeradic.setTrait(Traits.curse);
        emeradic.setCraftable(false).setCastable(true);
        emeradic.setHeadStats(604, 6.9f, 6.1f, HarvestLevels.OBSIDIAN);
        emeradic.setHandleStats(0.95f, 60);
        emeradic.setExtraStats(50);

        palis.setTrait(Traits.rose);
        palis.setCraftable(false).setCastable(true);
        palis.setHeadStats(304, 9.5f, 6, HarvestLevels.DIAMOND);
        palis.setHandleStats(0.95f, 60);
        palis.setExtraStats(50);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.blackquartz) {
            blackquartz.setFluid(FluidRegistry.getFluid("black_quartz"));
            blackquartz.addGem("QuartzBlack");
            blackquartz.preInit("QuartzBlack", "gem", FluidRegistry.getFluid("black_quartz"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(blackquartz, 0);
            }
        }
        if (Config.enori) {
            // enori.setRepresentativeItem("gemEnori");
            enori.addItem("gemEnori", Material.VALUE_Ingot);
            enori.setFluid(FluidRegistry.getFluid("enori"));
            enori.preInit("Enori", "gem", FluidRegistry.getFluid("enori"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(enori, 0);
            }
        }
        if (Config.voidcrystal) {
            voidCrystal.setFluid(FluidRegistry.getFluid("void"));
            voidCrystal.preInit("Void", "gem", FluidRegistry.getFluid("void"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(voidCrystal, 0);
            }
        }
        if (Config.emeratic) {
            emeradic.setFluid(FluidRegistry.getFluid("emeradic"));
            emeradic.preInit("Emeradic", "gem", FluidRegistry.getFluid("emeradic"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(emeradic, 0);
            }
        }
        if (Config.palis) {
            palis.setFluid(FluidRegistry.getFluid("palis"));
            palis.preInit("Palis", "gem", FluidRegistry.getFluid("palis"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(palis, 0);
            }
        }
        if (Config.redstonia) {
            redstonia.setFluid(FluidRegistry.getFluid("redstonia"));
            redstonia.preInit("Redstonia", "gem", FluidRegistry.getFluid("redstonia"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(redstonia, 0);
            }
        }
        if (Config.diamantine) {
            diamantine.setFluid(FluidRegistry.getFluid("diamantine"));
            diamantine.preInit("Diamantine", "gem", FluidRegistry.getFluid("diamantine"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(diamantine, 0);
            }
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
        blackquartz.setRepresentativeItem("gemQuartzBlack");
        blackquartz.addGem("QuartzBlack");
        enori.setRepresentativeItem("gemEnori");
        enori.addItem("gemEnori", Material.VALUE_Ingot);
        voidCrystal.setRepresentativeItem("gemVoid");
        voidCrystal.addItem("gemVoid", Material.VALUE_Ingot);
        emeradic.setRepresentativeItem("gemEmeradic");
        emeradic.addItem("gemEmeradic", Material.VALUE_Ingot);
        redstonia.setRepresentativeItem("gemRedstonia");
        redstonia.addItem("gemRedstonia", Material.VALUE_Ingot);
        diamantine.setRepresentativeItem("gemDiamantine");
        diamantine.addItem("gemDiamantine", Material.VALUE_Ingot);
        palis.setRepresentativeItem("gemPalis");
        palis.addItem("gemPalis", Material.VALUE_Ingot);

        registerGems("QuartzBlack", "black_quartz", true);
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