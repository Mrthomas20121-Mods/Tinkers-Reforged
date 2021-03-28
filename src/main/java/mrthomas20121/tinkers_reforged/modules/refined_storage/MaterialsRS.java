package mrthomas20121.tinkers_reforged.modules.refined_storage;

import com.raoulvdberge.refinedstorage.RSItems;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class MaterialsRS implements ModuleBase {

    private MaterialGen quartz_enriched_iron = new MaterialGen("quartz_enriched_iron", 0xF1F0EC, "QuartzEnrichedIron", 500);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.quartz_enriched_iron) {
            quartz_enriched_iron.preInit();
            quartz_enriched_iron.getMaterial().addTrait(ReforgedTraits.enriching, MaterialTypes.HEAD);
            quartz_enriched_iron.getMaterial().addTrait(TinkerTraits.magnetic2);
            TinkerRegistry.addMaterial(quartz_enriched_iron.getMaterial());
            TinkerRegistry.addMaterialStats(quartz_enriched_iron.getMaterial(),
                    new HeadMaterialStats(204, 6.05f, 4.20f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1f, 60),
                    new ExtraMaterialStats(50),
                    new BowMaterialStats(0.9f, 3f, 7.9f));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        OreDictionary.registerOre("ingotQuartzEnrichedIron", RSItems.QUARTZ_ENRICHED_IRON);
        if(TinkersReforgedConfig.SettingMaterials.materials.quartz_enriched_iron) {
            quartz_enriched_iron.init();
            quartz_enriched_iron.getMaterial().setRepresentativeItem(RSItems.QUARTZ_ENRICHED_IRON);
            quartz_enriched_iron.getMaterial().setRepresentativeItem("ingotQuartzEnrichedIron");
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
