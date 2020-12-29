package mrthomas20121.tinkers_reforged.modules;

import appeng.items.materials.MaterialType;
import mrthomas20121.biolib.library.ModuleBase;
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

public class ModuleAe2 implements ModuleBase {

    private Material certus_quartz = new Material("ref_certus_quartz", 0xBADBFF);
    private Material charged_certus_quartz = new Material("ref_charged_certus_quartz", 0xBADBFF);
    private Material fluix_crystal = new Material("ref_fluix_crystal", 0x614EAB);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.certus_quartz) {
            certus_quartz.addTrait(TinkerTraits.fractured);
            TinkerRegistry.addMaterial(certus_quartz);
            TinkerRegistry.addMaterialStats(certus_quartz,
                    new HeadMaterialStats(230, 4.2f, 3f, HarvestLevels.IRON),
                    new HandleMaterialStats(0.8f, 90),
                    new ExtraMaterialStats(70),
                    new BowMaterialStats(4.2f, 1.2f, 3f));
        }

        if(TinkersReforgedConfig.SettingMaterials.materials.fluix_crystal) {
            fluix_crystal.addTrait(ReforgedTraits.signal);
            TinkerRegistry.addMaterial(fluix_crystal);
            TinkerRegistry.addMaterialStats(fluix_crystal,
                    new HeadMaterialStats(230, 4.2f, 3f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.8f, 90),
                    new ExtraMaterialStats(70),
                    new BowMaterialStats(4.5f, 7.3f, 1f));
        }

        if(TinkersReforgedConfig.SettingMaterials.materials.charged_certus_quartz) {
            charged_certus_quartz.addTrait(ReforgedTraits.flux, MaterialTypes.HEAD);
            charged_certus_quartz.addTrait(TinkerTraits.shocking);
            TinkerRegistry.addMaterial(charged_certus_quartz);
            TinkerRegistry.addMaterialStats(charged_certus_quartz,
                    new HeadMaterialStats(230, 4.2f, 3f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.8f, 90),
                    new ExtraMaterialStats(70),
                    new BowMaterialStats(5, 5, 5));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {

        OreDictionary.registerOre("gemQuartzCertus", MaterialType.CERTUS_QUARTZ_CRYSTAL.stack(1));
        OreDictionary.registerOre("gemQuartzCertusCharged", MaterialType.CERTUS_QUARTZ_CRYSTAL_CHARGED.stack(1));
        OreDictionary.registerOre("gemFluix", MaterialType.FLUIX_CRYSTAL.stack(1));

        if(TinkersReforgedConfig.SettingMaterials.materials.certus_quartz) {
            certus_quartz.setCraftable(true);
            certus_quartz.setRepresentativeItem("gemQuartzCertus");
            certus_quartz.addItem(MaterialType.CERTUS_QUARTZ_CRYSTAL.stack(1), 1, Material.VALUE_Ingot);
        }

        if(TinkersReforgedConfig.SettingMaterials.materials.fluix_crystal) {
            fluix_crystal.setCraftable(true);
            fluix_crystal.setRepresentativeItem("gemFluix");
            fluix_crystal.addItem(MaterialType.FLUIX_CRYSTAL.stack(1), 1, Material.VALUE_Ingot);
        }

        if(TinkersReforgedConfig.SettingMaterials.materials.charged_certus_quartz) {
            charged_certus_quartz.setCraftable(true);
            charged_certus_quartz.setRepresentativeItem("gemQuartzCertusCharged");
            charged_certus_quartz.addItem(MaterialType.CERTUS_QUARTZ_CRYSTAL_CHARGED.stack(1), 1, Material.VALUE_Ingot);
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
