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
import slimeknights.tconstruct.tools.TinkerTraits;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class ModuleCavern implements ModuleBase
{

    public ModuleCavern()
    {
    }

    @Override
    public void preInit(FMLPreInitializationEvent e)
    {
        MaterialStats baseStats = new MaterialStats();
        baseStats.setHeadMaterialStats(150, 5f, 5f, HarvestLevels.DIAMOND);
        baseStats.setHandleMaterialStats(1.4f, 0);
        baseStats.setExtraMaterialStats(50);
        baseStats.setBowMaterialStats(1.2f, 3, 1.5f);

        MaterialStats aquamarineStats = new MaterialStats();
        aquamarineStats.setHeadMaterialStats(204, 6f, 4f, HarvestLevels.IRON);
        aquamarineStats.setHandleMaterialStats(1.20f, 10);
        aquamarineStats.setExtraMaterialStats(70);
        aquamarineStats.setBowMaterialStats(0.9f, 30, 1.2f);

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.aquamarine.getMaterial().getIdentifier()))
        {
            Resources.aquamarine.addTrait(TinkerTraits.aquadynamic);
            Resources.aquamarine.createGemMaterial(aquamarineStats);
            Resources.materials.add(Resources.aquamarine);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.aquamarine, aquamarineStats, 0);
            }
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.magnite.getMaterial().getIdentifier()))
        {
            Resources.magnite.addTrait(TinkerTraits.aridiculous);
            Resources.magnite.createMaterial(baseStats);
            Resources.materials.add(Resources.magnite);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.magnite, baseStats, 0);
            }
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.hexcite.getMaterial().getIdentifier()))
        {
            Resources.hexcite.addTrait(Traits.refined);
            Resources.hexcite.createGemMaterial(baseStats);
            Resources.materials.add(Resources.hexcite);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.hexcite, baseStats, 0);
            }
        }
    }

    @Override
    public void init(FMLInitializationEvent e)
    {
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) { }
}
