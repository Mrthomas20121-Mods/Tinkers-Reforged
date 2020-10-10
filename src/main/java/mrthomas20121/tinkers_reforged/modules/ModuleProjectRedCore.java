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
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleProjectRedCore implements ModuleBase {

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {

        if(ConfigMaterials.red_alloy)
        {
            MaterialStats redAlloyStats = new MaterialStats();
            redAlloyStats.setHeadMaterialStats(200, 6, 6, HarvestLevels.DIAMOND);
            redAlloyStats.setHandleMaterialStats(1.3f, 88);
            redAlloyStats.setExtraMaterialStats(27);
            redAlloyStats.setBowMaterialStats(8.8f, 4.2f, 4);

            Resources.red_alloy.addTrait(Traits.flux);
            Resources.red_alloy.createMaterial(redAlloyStats);
        }
        if(ConfigMaterials.electrotine)
        {
            MaterialStats electroStats = new MaterialStats();
            electroStats.setHeadMaterialStats(200, 4, 4, HarvestLevels.IRON);
            electroStats.setHandleMaterialStats(1.3f, 88);
            electroStats.setExtraMaterialStats(27);
            electroStats.setBowMaterialStats(6.6f, 4.2f, 4);

            Resources.electrotine.addTrait(TinkerTraits.shocking);
            Resources.electrotine.createMaterial(electroStats, "dust");
            Resources.electrotine.setMode(true);
        }
        if(ConfigMaterials.electrotine_alloy)
        {
            MaterialStats electrotineAlloyStats = new MaterialStats();
            electrotineAlloyStats.setHeadMaterialStats(300, 8, 7, HarvestLevels.DIAMOND);
            electrotineAlloyStats.setHandleMaterialStats(1.3f, 88);
            electrotineAlloyStats.setExtraMaterialStats(47);
            electrotineAlloyStats.setBowMaterialStats(6.6f, 4.2f, 4);
            Resources.electrotine_alloy.addTrait(TinkerTraits.shocking);
            Resources.electrotine_alloy.addTrait(TinkerTraits.magnetic);
            Resources.electrotine_alloy.createMaterial(electrotineAlloyStats);
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
