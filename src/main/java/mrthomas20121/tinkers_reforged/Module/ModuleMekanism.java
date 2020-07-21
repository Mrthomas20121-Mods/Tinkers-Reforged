package mrthomas20121.tinkers_reforged.Module;

import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleMekanism implements ModuleBase {
    public MaterialBuilder osmium = new MaterialBuilder(Materials.osmium);
    public MaterialBuilder refined_obsidian = new MaterialBuilder(Materials.refined_obsidian);
    public MaterialBuilder refined_glowstone = new MaterialBuilder(Materials.refined_glowstone);

    public ModuleMekanism() {
        osmium.setCraftable(false).setCastable(true);
        osmium.setTrait(TinkerTraits.established, MaterialTypes.HEAD);
        osmium.setTrait(TinkerTraits.dense);
        osmium.setHeadStats(220, 5.5f, 5.5f, HarvestLevels.IRON);
        osmium.setHandleStats(0.9f, 90);
        osmium.setExtraStats(50);
        osmium.setBowStats(2.5f, 3, 2.5f);

        refined_obsidian.setCraftable(false).setCastable(true);
        refined_obsidian.setTrait(Traits.refined, MaterialTypes.HEAD);
        refined_obsidian.setTrait(TinkerTraits.duritos);
        refined_obsidian.setHeadStats(550, 6.5f, 6.5f, HarvestLevels.OBSIDIAN);
        refined_obsidian.setHandleStats(1, 100);
        refined_obsidian.setExtraStats(50);
        refined_obsidian.setBowStats(2, 1.9f, 2.7f);

        refined_glowstone.setCraftable(false).setCastable(true);
        refined_glowstone.setTrait(Traits.refined, MaterialTypes.HEAD);
        refined_glowstone.setTrait(Traits.light);
        refined_glowstone.setHeadStats(540, 5f, 6.9f, HarvestLevels.OBSIDIAN);
        refined_glowstone.setHandleStats(1, 100);
        refined_glowstone.setExtraStats(50);
        refined_glowstone.setBowStats(2.7f, 5, 2.1f);
    }

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.refined_obsidian) {
            refined_obsidian.addCommonItems("RefinedObsidian");
            refined_obsidian.setFluid(FluidRegistry.getFluid("refined_obsidian"));
            refined_obsidian.preInit("RefinedObsidian", FluidRegistry.getFluid("refined_obsidian"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(refined_obsidian, 1f);
            }
            Materials.mats.add(refined_obsidian.getMat());
        }
        if(Config.refined_glowstone) {
            refined_glowstone.addCommonItems("RefinedGlowstone");
            refined_glowstone.setFluid(FluidRegistry.getFluid("refined_glowstone"));
            refined_glowstone.preInit("RefinedGlowstone", FluidRegistry.getFluid("refined_glowstone"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(refined_glowstone, 0);
            }
            Materials.mats.add(refined_glowstone.getMat());
        }
        if(Config.osmium) {
            osmium.addCommonItems("Osmium");
            osmium.setFluid(FluidRegistry.getFluid("osmium"));
            osmium.preInit("Osmium", FluidRegistry.getFluid("osmium"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(osmium, 0);
            }
            Materials.mats.add(osmium.getMat());
        }
    }
    public void init(FMLInitializationEvent e) {}
    public void postInit(FMLPostInitializationEvent e) { }
}
