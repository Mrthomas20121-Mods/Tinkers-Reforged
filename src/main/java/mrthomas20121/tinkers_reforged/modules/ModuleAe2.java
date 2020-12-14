package mrthomas20121.tinkers_reforged.modules;

import appeng.items.materials.MaterialType;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.TraitFlux;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(certus_quartz.getIdentifier())) {
            certus_quartz.addTrait(TinkerTraits.fractured);
            TinkerRegistry.addMaterial(certus_quartz);
            TinkerRegistry.addMaterialStats(certus_quartz,
                    new HeadMaterialStats(230, 4.2f, 3f, HarvestLevels.IRON),
                    new HandleMaterialStats(0.8f, 90),
                    new ExtraMaterialStats(70),
                    new BowMaterialStats(4.2f, 1.2f, 3f));
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(charged_certus_quartz.getIdentifier())) {
            fluix_crystal.addTrait(TinkerTraits.sharp);
            TinkerRegistry.addMaterial(fluix_crystal);
            TinkerRegistry.addMaterialStats(fluix_crystal,
                    new HeadMaterialStats(230, 4.2f, 3f, HarvestLevels.DIAMOND),
                    new HandleMaterialStats(0.8f, 90),
                    new ExtraMaterialStats(70),
                    new BowMaterialStats(4.5f, 7.3f, 1f));
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(charged_certus_quartz.getIdentifier())) {
            charged_certus_quartz.addTrait(new TraitFlux(), MaterialTypes.HEAD);
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

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(certus_quartz.getIdentifier())) {
            certus_quartz.setRepresentativeItem(MaterialType.CERTUS_QUARTZ_CRYSTAL.stack(1));
            certus_quartz.addItem(MaterialType.CERTUS_QUARTZ_CRYSTAL.stack(1), 1, Material.VALUE_Ingot);
            certus_quartz.setCraftable(true);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(fluix_crystal.getIdentifier())) {
            fluix_crystal.setRepresentativeItem(MaterialType.FLUIX_CRYSTAL.stack(1));
            fluix_crystal.addItem(MaterialType.FLUIX_CRYSTAL.stack(1), 1, Material.VALUE_Ingot);
            fluix_crystal.setCraftable(true);
        }

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(charged_certus_quartz.getIdentifier())) {
            charged_certus_quartz.setRepresentativeItem(MaterialType.CERTUS_QUARTZ_CRYSTAL_CHARGED.stack(1));
            charged_certus_quartz.addItem(MaterialType.CERTUS_QUARTZ_CRYSTAL_CHARGED.stack(1), 1, Material.VALUE_Ingot);
            charged_certus_quartz.setCraftable(true);
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
