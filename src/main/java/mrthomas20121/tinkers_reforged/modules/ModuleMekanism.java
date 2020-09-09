package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;

import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleMekanism implements ModuleBase {

    public ModuleMekanism() {
        Resources.osmium.builder.setTrait(TinkerTraits.established, MaterialTypes.HEAD);
        Resources.osmium.builder.setTrait(TinkerTraits.dense);
        Resources.osmium.builder.setHeadStats(220, 5.5f, 5.5f, HarvestLevels.IRON);
        Resources.osmium.builder.setHandleStats(0.9f, 90);
        Resources.osmium.builder.setExtraStats(50);
        Resources.osmium.builder.setBowStats(2.5f, 3, 2.5f);

        Resources.refined_obsidian.builder.setTrait(Traits.refined, MaterialTypes.HEAD);
        Resources.refined_obsidian.builder.setTrait(TinkerTraits.duritos);
        Resources.refined_obsidian.builder.setHeadStats(550, 6.5f, 6.5f, HarvestLevels.OBSIDIAN);
        Resources.refined_obsidian.builder.setHandleStats(1, 100);
        Resources.refined_obsidian.builder.setExtraStats(50);
        Resources.refined_obsidian.builder.setBowStats(2, 1.9f, 2.7f);

        Resources.refined_glowstone.builder.setCraftable(false).setCastable(true);
        Resources.refined_glowstone.builder.setTrait(Traits.refined, MaterialTypes.HEAD);
        Resources.refined_glowstone.builder.setTrait(Traits.light);
        Resources.refined_glowstone.builder.setHeadStats(540, 5f, 6.9f, HarvestLevels.OBSIDIAN);
        Resources.refined_glowstone.builder.setHandleStats(1, 100);
        Resources.refined_glowstone.builder.setExtraStats(50);
        Resources.refined_glowstone.builder.setBowStats(2.7f, 5, 2.1f);
    }

    public void preInit(FMLPreInitializationEvent e) {

        Resources.osmium.registerFluid();
        Resources.refined_glowstone.registerFluid();
        Resources.refined_obsidian.registerFluid();

        if(ConfigMaterials.refined_obsidian) {
            Resources.refined_obsidian.builder.addCommonItems("RefinedObsidian");
            Resources.refined_obsidian.builder.setFluid(FluidRegistry.getFluid("refined_obsidian"));
            Resources.refined_obsidian.builder.preInit("RefinedObsidian", FluidRegistry.getFluid("refined_obsidian"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.refined_obsidian.builder, 1f);
            }
            Resources.materials.add(Resources.refined_obsidian);
        }
        if(ConfigMaterials.refined_glowstone) {
            Resources.refined_glowstone.builder.addCommonItems("RefinedGlowstone");
            Resources.refined_glowstone.builder.setFluid(FluidRegistry.getFluid("refined_glowstone"));
            Resources.refined_glowstone.builder.preInit("RefinedGlowstone", FluidRegistry.getFluid("refined_glowstone"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.refined_glowstone.builder, 0);
            }
            Resources.materials.add(Resources.refined_glowstone);
        }
        if(ConfigMaterials.osmium) {
            Resources.osmium.builder.addCommonItems("Osmium");
            Resources.osmium.builder.preInit("Osmium", FluidRegistry.getFluid("osmium"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.osmium.builder, 0);
            }
            Resources.materials.add(Resources.osmium);
        }
    }
    public void init(FMLInitializationEvent e) {}
    public void postInit(FMLPostInitializationEvent e) { }
}
