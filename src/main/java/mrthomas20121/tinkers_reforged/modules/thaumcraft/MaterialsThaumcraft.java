package mrthomas20121.tinkers_reforged.modules.thaumcraft;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class MaterialsThaumcraft implements ModuleBase {

    MaterialGen thaumium = new MaterialGen("thaumium", 0x7768A9, "Thaumium", 800);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.thaumium) {
            thaumium.preInit();
            thaumium.getMaterial().addTrait(ReforgedTraits.crystalSurge);
            TinkerRegistry.addMaterial(thaumium.getMaterial());
            TinkerRegistry.addMaterialStats(thaumium.getMaterial(),
                    new HeadMaterialStats(100, 4.5f, 4.4f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(1.1f, 30),
                    new ExtraMaterialStats(5),
                    new BowMaterialStats(2.3f, 5.5f, 3.3f));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.thaumium) {
            thaumium.init();
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
