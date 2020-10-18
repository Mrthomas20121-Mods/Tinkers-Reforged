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

public class ModuleThermal implements ModuleBase {

    public ModuleThermal() {
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {

        MaterialStats baseStats = new MaterialStats();
        baseStats.setHeadMaterialStats(500, 7.3f, 6.9f, HarvestLevels.OBSIDIAN);
        baseStats.setHandleMaterialStats(1.2f, 90);
        baseStats.setExtraMaterialStats(80);
        baseStats.setBowMaterialStats(7.3f, 2, 7f);

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.enderium.getMaterial().getIdentifier()))
        {

            MaterialStats enderiumStats = new MaterialStats();
            enderiumStats.setHeadMaterialStats(750, 9.2f, 8.5f, HarvestLevels.COBALT);
            enderiumStats.setHandleMaterialStats(0.99f, 190);
            enderiumStats.setExtraMaterialStats(90);
            enderiumStats.setBowMaterialStats(9.2f, 3.5f, 8.5f);

            Resources.enderium.setTemp(1900);
            Resources.enderium.addTrait(Traits.enderfestation);
            Resources.enderium.addTrait(Traits.traitTeleport);
            Resources.enderium.addTrait(Traits.ender, MaterialTypes.HEAD);
            Resources.enderium.createMaterial(enderiumStats);
            Resources.materials.add(Resources.enderium);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.enderium, enderiumStats, 2);
            }
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.signalum.getMaterial().getIdentifier()))
        {
            Resources.signalum.setTemp(1500);
            Resources.signalum.addTrait(Traits.flux, MaterialTypes.HEAD);
            Resources.signalum.addTrait(Traits.signal);
            Resources.signalum.createMaterial(baseStats);
            Resources.materials.add(Resources.signalum);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.signalum, baseStats, 1);
            }
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.lumium.getMaterial().getIdentifier()))
        {
            Resources.lumium.setTemp(1500);
            Resources.lumium.addTrait(Traits.light);
            Resources.lumium.addTrait(Traits.traitRod, MaterialTypes.HEAD);
            Resources.lumium.createMaterial(baseStats);
            Resources.materials.add(Resources.lumium);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.lumium, baseStats, 1);
            }
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {

    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
