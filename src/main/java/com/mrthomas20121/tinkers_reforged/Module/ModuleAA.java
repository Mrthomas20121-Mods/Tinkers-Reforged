package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.OredictHelper;
import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.libs.SmelteryUtils;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;

import de.ellpeck.actuallyadditions.mod.items.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAA extends ModuleBase {
  
  public RegistryLib blackquartz = new RegistryLib(Materials.blackquartz);
  public RegistryLib enori = new RegistryLib(Materials.enori);
  public RegistryLib redstonia = new RegistryLib(Materials.redstonia);
  public RegistryLib voidCrystal = new RegistryLib(Materials.void_crystal);
  public RegistryLib diamantine = new RegistryLib(Materials.diamantine);
  public RegistryLib emeradic = new RegistryLib(Materials.emeradic);
  public RegistryLib palis = new RegistryLib(Materials.palis);

    public ModuleAA() {
        blackquartz.setCraftable(false).setCastable(true);
        blackquartz.addMaterialTrait(TinkerTraits.crude2, MaterialTypes.HEAD);
        blackquartz.addMaterialTrait(TinkerTraits.sharp);
        blackquartz.registerHeadStats(204, 6, 4, HarvestLevels.DIAMOND);
        blackquartz.registerHandleStats(0.95f, 60);
        blackquartz.registerExtraStats(50);

        enori.addMaterialTrait(Traits.starry_night, MaterialTypes.HEAD);
        enori.addMaterialTrait(Traits.starshaped);
        enori.setCraftable(false).setCastable(true);
        enori.registerHeadStats(304, 6.5f, 6, HarvestLevels.DIAMOND);
        enori.registerHandleStats(0.95f, 60);
        enori.registerExtraStats(50);

        
        redstonia.setCraftable(false).setCastable(true);
        redstonia.registerHeadStats(304, 6.5f, 6, HarvestLevels.DIAMOND);
        redstonia.registerHandleStats(0.95f, 60);
        redstonia.registerExtraStats(50);

        voidCrystal.addMaterialTrait(Traits.void_trait);
        voidCrystal.setCraftable(false).setCastable(true);
        voidCrystal.registerHeadStats(304, 9.5f, 6, HarvestLevels.DIAMOND);
        voidCrystal.registerHandleStats(0.95f, 60);
        voidCrystal.registerExtraStats(50);

        diamantine.setCraftable(false).setCastable(true);
        diamantine.registerHeadStats(604, 6.9f, 6.1f, HarvestLevels.OBSIDIAN);
        diamantine.registerHandleStats(0.95f, 60);
        diamantine.registerExtraStats(50);

        emeradic.setCraftable(false).setCastable(true);

        palis.setCraftable(false).setCastable(true);
    }

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.blackquartz) {
            blackquartz.setFluid(FluidRegistry.getFluid("black_quartz"));
            blackquartz.addGemItem("QuartzBlack");
            blackquartz.preInit("QuartzBlack", "gem", FluidRegistry.getFluid("black_quartz"));
        }
        if(Config.enori) {
            //enori.setRepresentativeItem("gemEnori");
            enori.addItem("gemEnori", Material.VALUE_Ingot);
            enori.preInit("Enori", "gem",FluidRegistry.getFluid("enori_crystal"));
        }
        if(Config.voidcrystal) {
            voidCrystal.preInit("Void", "gem", FluidRegistry.getFluid("void_crystal"));
        }
    }
    public void init(FMLInitializationEvent e) {
        OredictHelper.RegisterGemItem("Redstonia",new ItemStack(InitItems.itemCrystal, 1, 0));
        OredictHelper.RegisterGemItem("Palis",new ItemStack(InitItems.itemCrystal, 1, 1));
        OredictHelper.RegisterGemItem("Diamantine",new ItemStack(InitItems.itemCrystal, 1, 2));
        OredictHelper.RegisterGemItem("Void",new ItemStack(InitItems.itemCrystal, 1, 3));
        OredictHelper.RegisterGemItem("Emeradic",new ItemStack(InitItems.itemCrystal, 1, 4));
        OredictHelper.RegisterGemItem("Enori",new ItemStack(InitItems.itemCrystal, 1, 5));
        blackquartz.setRepresentativeItem("gemQuartzBlack");
        blackquartz.addGemItem("QuartzBlack");
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
        SmelteryUtils.registerGemCasting("QuartzBlack", FluidRegistry.getFluid("black_quartz"));
        SmelteryUtils.registerBlockCasting("QuartzBlack", FluidRegistry.getFluid("black_quartz"));
        SmelteryUtils.registerMelting("gemQuartzBlack", FluidRegistry.getFluid("black_quartz"), Material.VALUE_Gem);
        SmelteryUtils.registerMelting("blockQuartzBlack", FluidRegistry.getFluid("black_quartz"), Material.VALUE_BrickBlock);
        SmelteryUtils.registerCasting("gemEnori", FluidRegistry.getFluid("enori_crystal"), Material.VALUE_Ingot);
        SmelteryUtils.registerMelting("gemEnori", FluidRegistry.getFluid("enori_crystal"), Material.VALUE_Ingot);
    }
    public void postInit(FMLPostInitializationEvent e) {

    }

}