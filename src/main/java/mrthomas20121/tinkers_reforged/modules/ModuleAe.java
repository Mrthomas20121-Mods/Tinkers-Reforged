package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Traits.Traits;
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
        Resources.certus_quartz.builder.setTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
        Resources.certus_quartz.builder.setTrait(TinkerTraits.fractured);
        Resources.certus_quartz.builder.setHeadStats(230, 4.2f, 3f, HarvestLevels.IRON);
        Resources.certus_quartz.builder.setHandleStats(0.8f, 90);
        Resources.certus_quartz.builder.setExtraStats(70);

        Resources.fluix_crystal.builder.setTrait(Traits.flux, MaterialTypes.HEAD);
        Resources.fluix_crystal.builder.setTrait(Traits.signal);
        Resources.fluix_crystal.builder.setHeadStats(230, 4.2f, 3f, HarvestLevels.IRON);
        Resources.fluix_crystal.builder.setHandleStats(0.8f, 90);
        Resources.fluix_crystal.builder.setExtraStats(70);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {

        if(ConfigMaterials.certus_quartz) {
            Resources.certus_quartz.builder.preInit("crystalCertusQuartz");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.certus_quartz.builder, 0);
            }
            Resources.materials.add(Resources.certus_quartz);
        }
        if(ConfigMaterials.fluix_crystal) {
            Resources.fluix_crystal.builder.preInit("crystalFluix");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.fluix_crystal.builder, 0);
            }
            Resources.materials.add(Resources.fluix_crystal);
        }

    }
    @Override
    public void init(FMLInitializationEvent e) {
        Resources.certus_quartz.builder.addItem("crystalPureCertusQuartz", Material.VALUE_Ingot);
        Resources.fluix_crystal.builder.addItem("crystalFluix", Material.VALUE_Ingot);
        Resources.fluix_crystal.builder.addItem("crystalPureFluix", Material.VALUE_Ingot);
        Resources.certus_quartz.builder.setRepresentativeItem("crystalCertusQuartz");
        Resources.fluix_crystal.builder.setRepresentativeItem("crystalFluix");
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
