package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.SmelteryUtils;
import com.mrthomas20121.libs.OredictHelper;
import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.legacy.blue_skies.items.ItemsSkies;
import com.legacy.blue_skies.blocks.BlocksSkies;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleBlueSkies extends ModuleBase {
    public RegistryLib ventium = new RegistryLib(Materials.ventium);
    public RegistryLib horizonite = new RegistryLib(Materials.horizonite);
    public RegistryLib pyrope = new RegistryLib(Materials.pyrope);
    public RegistryLib turquoise = new RegistryLib(Materials.turquoise);
    public RegistryLib chartoite = new RegistryLib(Materials.charoite);
    public RegistryLib diopside = new RegistryLib(Materials.diopside);

    public ModuleBlueSkies() {
        ventium.setCraftable(false).setCastable(true);
        ventium.addMaterialTrait(TinkerTraits.cheap);
        ventium.registerHeadStats(150, 3, 3.2f, HarvestLevels.IRON);
        ventium.registerHandleStats(1f, 30);
        ventium.registerExtraStats(-1);
        ventium.registerBowStats(0.5f, 7, 10);

        horizonite.setCraftable(false).setCastable(true);
        horizonite.addMaterialTrait(TinkerTraits.autosmelt, MaterialTypes.HEAD);
        horizonite.addMaterialTrait(Traits.pyromancy);
        horizonite.registerHeadStats(200, 6.3f, 4f, HarvestLevels.DIAMOND);
        horizonite.registerHandleStats(0.9f, 90);
        horizonite.registerExtraStats(70);
        horizonite.registerBowStats(2, 1.5f, 7);

        pyrope.setCraftable(false).setCastable(true);
        pyrope.addMaterialTrait(TinkerTraits.lightweight);
        pyrope.registerHeadStats(100, 8, 7, HarvestLevels.DIAMOND);
        pyrope.registerHandleStats(1, 5);
        pyrope.registerExtraStats(-5);

        turquoise.setCraftable(false).setCastable(true);
        turquoise.addMaterialTrait(TinkerTraits.magnetic2);
        turquoise.registerHeadStats(200, 6.3f, 4f, HarvestLevels.DIAMOND);
        turquoise.registerHandleStats(0.9f, 90);
        turquoise.registerExtraStats(70);
        turquoise.registerBowStats(1.0f, 1.5f, 3);
    }

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.ventium) {
            ventium.setFluid(ModuleFluids.ventium);
            ventium.addCommonItems("Ventium");
            ventium.preInit("Ventium", ModuleFluids.ventium);
        }
        if(Config.horizonite) {
            horizonite.setFluid(ModuleFluids.horizonite);
            horizonite.addCommonItems("Horizonite");
            horizonite.preInit("Horizonite", ModuleFluids.horizonite);
        }
        if(Config.pyrope) {
            pyrope.addCommonItems("Pyrope");
            pyrope.setFluid(ModuleFluids.pyrope);
            pyrope.preInit("Pyrope", "gem", ModuleFluids.pyrope);
        }
    }
    public void init(FMLInitializationEvent e) {
        OredictHelper.RegisterIngotItem("Ventium", ItemsSkies.ventium_ingot);
        OredictHelper.RegisterBucketItem("Ventium", ItemsSkies.ventium_bucket);
        OredictHelper.RegisterOreBlock("Ventium", BlocksSkies.ventium_ore);
        OredictHelper.RegisterIngotItem("Horizonite", ItemsSkies.horizonite_ingot);
        OredictHelper.RegisterOreBlock("Horizonite", BlocksSkies.horizonite_ore);
        OredictHelper.RegisterBlock("Horizonnite", BlocksSkies.horizonite_block);
        OredictHelper.RegisterIngotItem("Falsite", ItemsSkies.falsite_ingot);
        OredictHelper.RegisterOreBlock("Falsite", BlocksSkies.falsite_ore);
        OredictHelper.RegisterGemItem("Pyrope", ItemsSkies.pyrope_gem);
        OredictHelper.RegisterOreBlock("Pyrope", BlocksSkies.everbright_pyrope_ore);
        OredictHelper.RegisterOreBlock("Pyrope", BlocksSkies.everdawn_pyrope_ore);
        OredictHelper.RegisterBlock("Pyrope", BlocksSkies.pyrope_block);
        OredictHelper.RegisterGemItem("Turquoise", ItemsSkies.turquoise_gem);
        OredictHelper.RegisterOreBlock("Turquoise", BlocksSkies.everbright_turquoise_ore);
        OredictHelper.RegisterOreBlock("Turquoise", BlocksSkies.everdawn_turquoise_ore);
        OredictHelper.RegisterBlock("Turquoise", BlocksSkies.turquoise_block);
        OredictHelper.RegisterGemItem("Chartoite", ItemsSkies.charoite);
        OredictHelper.RegisterOreBlock("Chartoite", BlocksSkies.everbright_charoite_ore);
        OredictHelper.RegisterOreBlock("Chartoite", BlocksSkies.everdawn_charoite_ore);
        OredictHelper.RegisterGemItem("Diopside", ItemsSkies.diopside_gem);
        OredictHelper.RegisterOreBlock("Diopside", BlocksSkies.everbright_diopside_ore);
        OredictHelper.RegisterOreBlock("Diopside", BlocksSkies.everdawn_diopside_ore);

        if(Config.pyrope) {
            pyrope.setRepresentativeItem("gemPyrope");
            SmelteryUtils.registerGemCasting("Pyrope", FluidRegistry.getFluid("pyrope"));
        }
    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
