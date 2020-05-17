package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleMekanism extends ModuleBase {
    public RegistryLib osmium = new RegistryLib(Materials.osmium);
    public RegistryLib refined_obsidian = new RegistryLib(Materials.refined_obsidian);
    public RegistryLib refined_glowstone = new RegistryLib(Materials.refined_glowstone);

    public ModuleMekanism() {
        osmium.setCraftable(false).setCastable(true);
        osmium.registerMaterialTrait(TinkerTraits.established, MaterialTypes.HEAD);
        osmium.registerMaterialTrait(TinkerTraits.dense);
        osmium.registerHeadStats(220, 5.5f, 5.5f, HarvestLevels.IRON);
        osmium.registerHandleStats(0.9f, 90);
        osmium.registerExtraStats(50);
        osmium.registerBowStats(2.5f, 3, 2.5f);

        refined_obsidian.setCraftable(false).setCastable(true);
        refined_obsidian.registerMaterialTrait(Traits.refined, MaterialTypes.HEAD);
        refined_obsidian.registerMaterialTrait(TinkerTraits.duritos);
        refined_obsidian.registerHeadStats(550, 6.5f, 6.5f, HarvestLevels.OBSIDIAN);
        refined_obsidian.registerHandleStats(1, 100);
        refined_obsidian.registerExtraStats(50);
        refined_obsidian.registerBowStats(2, 1.9f, 2.7f);

        refined_glowstone.setCraftable(false).setCastable(true);
        refined_glowstone.registerMaterialTrait(Traits.refined, MaterialTypes.HEAD);
        refined_glowstone.registerMaterialTrait(Traits.light);
        refined_glowstone.registerHeadStats(540, 5f, 6.9f, HarvestLevels.OBSIDIAN);
        refined_glowstone.registerHandleStats(1, 100);
        refined_glowstone.registerExtraStats(50);
        refined_glowstone.registerBowStats(2.7f, 5, 2.1f);
    }

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.refined_obsidian) {
            refined_obsidian.addCommonItems("RefinedObsidian");
            refined_obsidian.setFluid(FluidRegistry.getFluid("refined_obsidian"));
            refined_obsidian.preInit("RefinedObsidian", FluidRegistry.getFluid("refined_obsidian"));
            Materials.mats.add(refined_obsidian.getMat());
        }
        if(Config.refined_glowstone) {
            refined_glowstone.addCommonItems("RefinedGlowstone");
            refined_glowstone.setFluid(FluidRegistry.getFluid("refined_glowstone"));
            refined_glowstone.preInit("RefinedGlowstone", FluidRegistry.getFluid("refined_glowstone"));
            Materials.mats.add(refined_glowstone.getMat());
        }
        if(Config.osmium) {
            osmium.addCommonItems("Osmium");
            osmium.setFluid(FluidRegistry.getFluid("osmium"));
            osmium.preInit("Osmium", FluidRegistry.getFluid("osmium"));
            Materials.mats.add(osmium.getMat());
        }
    }
    public void init(FMLInitializationEvent e) {}
    public void postInit(FMLPostInitializationEvent e) { }
}
