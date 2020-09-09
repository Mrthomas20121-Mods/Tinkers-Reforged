package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.SmelteryUtils;
import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.biolib.util.FluidUtils;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.legacy.blue_skies.items.ItemsSkies;
import com.legacy.blue_skies.blocks.BlocksSkies;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleBlueSkies implements ModuleBase {

    public ModuleBlueSkies() {
        Resources.ventium.builder.setTrait(TinkerTraits.cheap);
        Resources.ventium.builder.setHeadStats(150, 3, 3.2f, HarvestLevels.IRON);
        Resources.ventium.builder.setHandleStats(1f, 30);
        Resources.ventium.builder.setExtraStats(-1);
        Resources.ventium.builder.setBowStats(0.5f, 7, 10);

        Resources.horizonite.builder.setTrait(TinkerTraits.autosmelt, MaterialTypes.HEAD);
        Resources.horizonite.builder.setTrait(Traits.pyromancy);
        Resources.horizonite.builder.setHeadStats(200, 6.3f, 4f, HarvestLevels.DIAMOND);
        Resources.horizonite.builder.setHandleStats(0.9f, 90);
        Resources.horizonite.builder.setExtraStats(70);
        Resources.horizonite.builder.setBowStats(2, 1.5f, 7);

        Resources.pyrope.builder.setCraftable(false).setCastable(true);
        Resources.pyrope.builder.setTrait(TinkerTraits.lightweight);
        Resources.pyrope.builder.setHeadStats(100, 8, 7, HarvestLevels.DIAMOND);
        Resources.pyrope.builder.setHandleStats(1, 5);
        Resources.pyrope.builder.setExtraStats(-5);

        Resources.turquoise.builder.setCraftable(false).setCastable(true);
        Resources.turquoise.builder.setTrait(TinkerTraits.magnetic2);
        Resources.turquoise.builder.setHeadStats(200, 6.3f, 4f, HarvestLevels.DIAMOND);
        Resources.turquoise.builder.setHandleStats(0.9f, 90);
        Resources.turquoise.builder.setExtraStats(70);
        Resources.turquoise.builder.setBowStats(1.0f, 1.5f, 3);
    }

    public void preInit(FMLPreInitializationEvent e) {
        Resources.pyrope.registerFluid();
        Resources.ventium.registerFluid();
        Resources.horizonite.registerFluid();

        if(ConfigMaterials.ventium) {
            Resources.ventium.builder.addCommonItems("Ventium");
            Resources.ventium.builder.preInit("Ventium", FluidUtils.getFluid("ventium"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.ventium.builder, 0);
            }
            Resources.materials.add(Resources.ventium);
        }
        if(ConfigMaterials.horizonite) {
            Resources.horizonite.builder.addCommonItems("Horizonite");
            Resources.horizonite.builder.preInit("Horizonite", FluidUtils.getFluid("horizonite"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.horizonite.builder, 0);
            }
            Resources.materials.add(Resources.horizonite);
        }
        if(ConfigMaterials.pyrope) {
            Resources.pyrope.builder.addCommonItems("Pyrope");
            Resources.pyrope.builder.addGem("Pyrope");
            Resources.pyrope.builder.preInit("Pyrope", FluidUtils.getFluid("pyrope"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.pyrope.builder, 0);
            }
            Resources.materials.add(Resources.pyrope);
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

        if(ConfigMaterials.pyrope) {
            Resources.pyrope.builder.setRepresentativeItem("gemPyrope");
            SmelteryUtils.registerGemCasting("Pyrope", FluidRegistry.getFluid("pyrope"));
        }
    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
