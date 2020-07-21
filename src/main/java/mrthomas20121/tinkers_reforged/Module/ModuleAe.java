package mrthomas20121.tinkers_reforged.Module;

import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAe implements ModuleBase {

    public MaterialBuilder certus_quartz = new MaterialBuilder(Materials.certus_quartz);
    public MaterialBuilder fluix_crystal = new MaterialBuilder(Materials.fluix_crystal);

    public ModuleAe() {
        certus_quartz.setCraftable(true).setCastable(false);
        certus_quartz.setTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
        certus_quartz.setTrait(TinkerTraits.fractured);
        certus_quartz.setHeadStats(230, 4.2f, 3f, HarvestLevels.IRON);
        certus_quartz.setHandleStats(0.8f, 90);
        certus_quartz.setExtraStats(70);

        fluix_crystal.setCraftable(true).setCastable(false);
        fluix_crystal.setTrait(Traits.flux, MaterialTypes.HEAD);
        fluix_crystal.setTrait(Traits.signal);
        fluix_crystal.setHeadStats(230, 4.2f, 3f, HarvestLevels.IRON);
        fluix_crystal.setHandleStats(0.8f, 90);
        fluix_crystal.setExtraStats(70);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {

        if(Config.certus_quartz) {
            certus_quartz.preInit("CrystalCertusQuartz");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(certus_quartz, 0);
            }
            Materials.mats.add(certus_quartz.getMat());
        }
        if(Config.fluix_crystal) {
            fluix_crystal.preInit("crystalFluix");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(fluix_crystal, 0);
            }
            Materials.mats.add(fluix_crystal.getMat());
        }

    }
    @Override
    public void init(FMLInitializationEvent e) {
        certus_quartz.addItem("crystalCertusQuartz", Material.VALUE_Ingot);
        certus_quartz.addItem("crystalPureCertusQuartz", Material.VALUE_Ingot);
        fluix_crystal.addItem("crystalFluix", Material.VALUE_Ingot);
        fluix_crystal.addItem("crystalPureFluix", Material.VALUE_Ingot);
        certus_quartz.setRepresentativeItem("crystalCertusQuartz");
        fluix_crystal.setRepresentativeItem("crystalFluix");
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
