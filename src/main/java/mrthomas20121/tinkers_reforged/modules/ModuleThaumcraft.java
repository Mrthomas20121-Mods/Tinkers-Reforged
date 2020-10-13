package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import mrthomas20121.tinkers_reforged.trait.Traits;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class ModuleThaumcraft implements ModuleBase {

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {

        if(ConfigMaterials.thaumium)
        {
            MaterialStats thaumiumStats = new MaterialStats();
            thaumiumStats.setHeadMaterialStats(400, 7, 4.25f, HarvestLevels.OBSIDIAN);
            thaumiumStats.setHandleMaterialStats(1, 30);
            thaumiumStats.setExtraMaterialStats(110);

            Resources.thaumium.addTrait(Traits.traitCrystalSurge);
            Resources.thaumium.createMaterial(thaumiumStats);
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
