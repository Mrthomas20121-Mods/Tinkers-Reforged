package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;
import slimeknights.tconstruct.library.utils.HarvestLevels.*;

public class MaterialsAtum extends ModuleReforgedBase {

    private Material khnumite = new Material("ref_khnumite", 0x998B59);
    private Material limestone = new Material("ref_limestone", 0x0);

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.atum;
    }

    @Override
    public void earlyPreInit() {
        if(TinkersReforgedConfig.SettingMaterials.materials.limestone) {
            TinkerRegistry.addMaterial(limestone);
        }
    }

    @Override
    public void preInit() {
        if(TinkersReforgedConfig.SettingMaterials.materials.khnumite) {
            khnumite.addTrait(TinkerTraits.crude);
            TinkerRegistry.addMaterial(khnumite);
            TinkerRegistry.addMaterialStats(khnumite,
                    new HeadMaterialStats(230, 3.5f, 2.9f, HarvestLevels.STONE),
                    new HandleMaterialStats(0.9f, 80),
                    new ExtraMaterialStats(40));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.limestone) {
            limestone.addTrait(TinkerTraits.cheap);
            TinkerRegistry.addMaterialStats(limestone,
                    new HeadMaterialStats(120, 4.00f, 3.00f, HarvestLevels.IRON),
                    new HandleMaterialStats(0.50f, -50),
                    new ExtraMaterialStats(20));
        }
    }

    @Override
    public void init() {
        if(TinkersReforgedConfig.SettingMaterials.materials.khnumite) {
            khnumite.setCraftable(true);
            khnumite.setRepresentativeItem("ingotKhnumite");
            khnumite.addItem("ingotKhnumite", 1, Material.VALUE_Ingot);

            limestone.setRepresentativeItem(ForgeUtils.getBlock("atum", "limestone"));
            limestone.addItem(ForgeUtils.getBlock("atum", "limestone"), 1);
        }
    }
}
