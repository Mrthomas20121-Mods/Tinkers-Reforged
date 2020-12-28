package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAtum implements ModuleBase {

    private Material khnumite = new Material("ref_khnumite", 0x998B59);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.khnumite) {
            khnumite.addTrait(TinkerTraits.crude);
            TinkerRegistry.addMaterial(khnumite);
            TinkerRegistry.addMaterialStats(khnumite,
                    new HeadMaterialStats(230, 3.5f, 2.9f, HarvestLevels.STONE),
                    new HandleMaterialStats(0.9f, 80),
                    new ExtraMaterialStats(40));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.khnumite) {
            khnumite.setCraftable(true);
            khnumite.setRepresentativeItem("ingotKhnumite");
            khnumite.addItem("ingotKhnumite", 1, Material.VALUE_Ingot);
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
