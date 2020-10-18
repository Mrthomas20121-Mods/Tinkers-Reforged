package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.Traits;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.legacy.blue_skies.items.ItemsSkies;
import com.legacy.blue_skies.blocks.BlocksSkies;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleBlueSkies implements ModuleBase {

    public ModuleBlueSkies() {
    }

    public void preInit(FMLPreInitializationEvent e) {
        MaterialStats gemStats = new MaterialStats();
        gemStats.setHeadMaterialStats(200, 6.3f, 4f, HarvestLevels.DIAMOND);
        gemStats.setHandleMaterialStats(0.9f, 90);
        gemStats.setExtraMaterialStats(10);
        gemStats.setBowMaterialStats(1.5f, 5.2f, 3.2f);

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.horizonite.getMaterial().getIdentifier())) {
            Resources.horizonite.addTrait(TinkerTraits.autosmelt, MaterialTypes.HEAD);
            Resources.horizonite.addTrait(Traits.pyromancy);
            Resources.horizonite.createMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.horizonite, gemStats, 1);
            }
            Resources.materials.add(Resources.horizonite);
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.pyrope.getMaterial().getIdentifier())) {
            Resources.pyrope.addTrait(Traits.traitFast, MaterialTypes.HEAD);
            Resources.pyrope.addTrait(TinkerTraits.sharp);
            Resources.pyrope.createGemMaterial(gemStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.pyrope, gemStats, 0);
            }
            Resources.materials.add(Resources.pyrope);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.charoite.getMaterial().getIdentifier())) {
            MaterialStats charoiteStats = new MaterialStats();
            charoiteStats.setHeadMaterialStats(400, 8f, 8f, HarvestLevels.DIAMOND);
            charoiteStats.setHandleMaterialStats(1.5f, 100);
            charoiteStats.setExtraMaterialStats(100);
            charoiteStats.setBowMaterialStats(5f, 5.2f, 5f);

            Resources.charoite.addTrait(TinkerTraits.lightweight, MaterialTypes.HEAD);
            Resources.charoite.addTrait(TinkerTraits.sharp);
            Resources.charoite.createGemMaterial(charoiteStats);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.charoite, charoiteStats, 0);
            }
            Resources.materials.add(Resources.charoite);
        }
    }
    public void init(FMLInitializationEvent e) {
        OredictHelper.RegisterIngotItem("Ventium", ItemsSkies.ventium_ingot);
        OredictHelper.RegisterBucketItem("Ventium", ItemsSkies.ventium_bucket);
        OredictHelper.RegisterOreBlock("Ventium", BlocksSkies.ventium_ore);
        OredictHelper.RegisterIngotItem("Horizonite", ItemsSkies.horizonite_ingot);
        OredictHelper.RegisterOreBlock("Horizonite", BlocksSkies.horizonite_ore);
        OredictHelper.RegisterBlock("Horizonnite", BlocksSkies.horizonite_block);
        OredictHelper.RegisterIngotItem("Falsite", ItemsSkies.falsite_ingot);
        OredictHelper.RegisterOreBlock("Falsite", BlocksSkies.falsite_ore);
        OredictHelper.RegisterGemItem("Pyrope", ItemsSkies.pyrope_gem);
        OredictHelper.RegisterOreBlock("Pyrope", BlocksSkies.everbright_pyrope_ore);
        OredictHelper.RegisterOreBlock("Pyrope", BlocksSkies.everdawn_pyrope_ore);
        OredictHelper.RegisterBlock("Pyrope", BlocksSkies.pyrope_block);
        OredictHelper.RegisterGemItem("Turquoise", ItemsSkies.turquoise_gem);
        OredictHelper.RegisterOreBlock("Turquoise", BlocksSkies.everbright_turquoise_ore);
        OredictHelper.RegisterOreBlock("Turquoise", BlocksSkies.everdawn_turquoise_ore);
        OredictHelper.RegisterBlock("Turquoise", BlocksSkies.turquoise_block);
        OredictHelper.RegisterGemItem("Charoite", ItemsSkies.charoite);
        OredictHelper.RegisterOreBlock("Charoite", BlocksSkies.everbright_charoite_ore);
        OredictHelper.RegisterOreBlock("Charoite", BlocksSkies.everdawn_charoite_ore);
        OredictHelper.RegisterGemItem("Diopside", ItemsSkies.diopside_gem);
        OredictHelper.RegisterOreBlock("Diopside", BlocksSkies.everbright_diopside_ore);
        OredictHelper.RegisterOreBlock("Diopside", BlocksSkies.everdawn_diopside_ore);
    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
