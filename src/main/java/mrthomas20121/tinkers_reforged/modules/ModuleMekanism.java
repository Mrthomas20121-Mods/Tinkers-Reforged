package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.Traits;

import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleMekanism implements ModuleBase {

    public ModuleMekanism() {
    }

    public void preInit(FMLPreInitializationEvent e) {

        MaterialStats refined = new MaterialStats();
        refined.setHeadMaterialStats(550, 6.5f, 6.5f, HarvestLevels.OBSIDIAN);
        refined.setHandleMaterialStats(1.1f, 100);
        refined.setExtraMaterialStats(50);
        refined.setBowMaterialStats(2.9f, 7, 5.1f);

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.refined_obsidian.getMaterial().getIdentifier())) {
            Resources.refined_obsidian.addTrait(Traits.refined, MaterialTypes.HEAD);
            Resources.refined_obsidian.addTrait(TinkerTraits.duritos);
            Resources.refined_obsidian.createMaterial(refined);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.refined_obsidian, refined, 1);
            }
            Resources.materials.add(Resources.refined_obsidian);
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.refined_glowstone.getMaterial().getIdentifier())) {

            Resources.refined_glowstone.addTrait(Traits.refined, MaterialTypes.HEAD);
            Resources.refined_glowstone.addTrait(Traits.light);
            Resources.refined_glowstone.createMaterial(refined);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.refined_glowstone, refined, 0);
            }
            Resources.materials.add(Resources.refined_glowstone);
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.osmium.getMaterial().getIdentifier())) {
            MaterialStats osmium = new MaterialStats();
            osmium.setHeadMaterialStats(410, 5.5f, 5.5f, HarvestLevels.DIAMOND);
            osmium.setHandleMaterialStats(1.2f, 80);
            osmium.setExtraMaterialStats(50);
            osmium.setBowMaterialStats(5.7f, 15.2f, 1);

            Resources.osmium.addTrait(TinkerTraits.established, MaterialTypes.HEAD);
            Resources.osmium.addTrait(TinkerTraits.dense);
            Resources.osmium.createMaterial(osmium);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.osmium, osmium, 0);
            }
            Resources.materials.add(Resources.osmium);
        }
    }
    public void init(FMLInitializationEvent e) {
    }
    public void postInit(FMLPostInitializationEvent e) { }
}
