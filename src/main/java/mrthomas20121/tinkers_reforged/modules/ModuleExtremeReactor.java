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
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class ModuleExtremeReactor implements ModuleBase {

    public ModuleExtremeReactor() {
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        MaterialStats stats = new MaterialStats();
        stats.setHeadMaterialStats(200, 5.3f, 5.3f, HarvestLevels.OBSIDIAN);
        stats.setHandleMaterialStats(1.1f, 100);
        stats.setExtraMaterialStats(20);
        stats.setBowMaterialStats(2.1f, 10.1f, 5.1f);

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.yellorium.getMaterial().getIdentifier()))
        {
            Resources.yellorium.addTrait(Traits.radioactive);
            Resources.yellorium.createMaterial(stats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.yellorium, stats, 1f);
            }
            Resources.materials.add(Resources.yellorium);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.blutonium.getMaterial().getIdentifier()))
        {
            Resources.blutonium.addTrait(Traits.nuclearwaste);
            Resources.blutonium.createMaterial(stats);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.blutonium, stats, 1f);
            }
            Resources.materials.add(Resources.blutonium);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.ludicrite.getMaterial().getIdentifier()))
        {
            Resources.ludicrite.addTrait(Traits.nuclearwaste);
            Resources.ludicrite.addTrait(Traits.radioactive, MaterialTypes.HEAD);
            Resources.ludicrite.createMaterial(stats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.ludicrite, stats, 1.5f);
            }
            Resources.materials.add(Resources.ludicrite);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.cyanite.getMaterial().getIdentifier()))
        {
            Resources.cyanite.addTrait(Traits.nuclearwaste, MaterialTypes.HEAD);
            Resources.cyanite.addTrait(Traits.traitSoft);
            Resources.cyanite.createMaterial(stats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.cyanite, stats, 0);
            }
            Resources.materials.add(Resources.cyanite);
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {

    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
