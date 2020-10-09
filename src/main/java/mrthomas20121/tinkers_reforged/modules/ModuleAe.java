package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.trait.Traits;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAe implements ModuleBase {

    public ModuleAe() {
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {

        MaterialStats stats = new MaterialStats();
        stats.setHeadMaterialStats(230, 4.2f, 3f, HarvestLevels.IRON);
        stats.setHandleMaterialStats(0.8f, 90);
        stats.setExtraMaterialStats(70);
        stats.setBowMaterialStats(5.2f, 1.2f, 3f);

        if(ConfigMaterials.certus_quartz) {

            Resources.certus_quartz.addTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
            Resources.certus_quartz.addTrait(TinkerTraits.fractured);
            Resources.certus_quartz.addItems("crystalCertusQuartz");
            Resources.certus_quartz.getMaterial().addItem("crystalPureCertusQuartz", 1, Material.VALUE_Ingot);
            Resources.certus_quartz.setOredict("CertusQuartz");
            Resources.certus_quartz.createMaterial(stats, "crystal");
            Resources.certus_quartz.getMaterial().setCraftable(true);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.certus_quartz, stats,0);
            }
            Resources.materials.add(Resources.certus_quartz);
        }
        if(ConfigMaterials.fluix_crystal) {
            Resources.fluix_crystal.setOredict("Fluix");
            Resources.fluix_crystal.addTrait(Traits.flux, MaterialTypes.HEAD);
            Resources.fluix_crystal.addTrait(Traits.signal);

            Resources.fluix_crystal.addItems("crystalFluix");
            Resources.fluix_crystal.getMaterial().addItem("crystalPureFluix", 1, Material.VALUE_Ingot);
            Resources.fluix_crystal.createMaterial(stats, "crystal");
            Resources.fluix_crystal.getMaterial().setCraftable(true);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.fluix_crystal, stats, 0);
            }
            Resources.materials.add(Resources.fluix_crystal);
        }

    }
    @Override
    public void init(FMLInitializationEvent e) {
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
