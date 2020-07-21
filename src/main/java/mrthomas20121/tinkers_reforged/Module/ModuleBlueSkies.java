package mrthomas20121.tinkers_reforged.Module;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.SmelteryUtils;
import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;
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
    public MaterialBuilder ventium = new MaterialBuilder(Materials.ventium);
    public MaterialBuilder horizonite = new MaterialBuilder(Materials.horizonite);
    public MaterialBuilder pyrope = new MaterialBuilder(Materials.pyrope);
    public MaterialBuilder turquoise = new MaterialBuilder(Materials.turquoise);
    public MaterialBuilder chartoite = new MaterialBuilder(Materials.charoite);
    public MaterialBuilder diopside = new MaterialBuilder(Materials.diopside);

    public ModuleBlueSkies() {
        ventium.setCraftable(false).setCastable(true);
        ventium.setTrait(TinkerTraits.cheap);
        ventium.setHeadStats(150, 3, 3.2f, HarvestLevels.IRON);
        ventium.setHandleStats(1f, 30);
        ventium.setExtraStats(-1);
        ventium.setBowStats(0.5f, 7, 10);

        horizonite.setCraftable(false).setCastable(true);
        horizonite.setTrait(TinkerTraits.autosmelt, MaterialTypes.HEAD);
        horizonite.setTrait(Traits.pyromancy);
        horizonite.setHeadStats(200, 6.3f, 4f, HarvestLevels.DIAMOND);
        horizonite.setHandleStats(0.9f, 90);
        horizonite.setExtraStats(70);
        horizonite.setBowStats(2, 1.5f, 7);

        pyrope.setCraftable(false).setCastable(true);
        pyrope.setTrait(TinkerTraits.lightweight);
        pyrope.setHeadStats(100, 8, 7, HarvestLevels.DIAMOND);
        pyrope.setHandleStats(1, 5);
        pyrope.setExtraStats(-5);

        turquoise.setCraftable(false).setCastable(true);
        turquoise.setTrait(TinkerTraits.magnetic2);
        turquoise.setHeadStats(200, 6.3f, 4f, HarvestLevels.DIAMOND);
        turquoise.setHandleStats(0.9f, 90);
        turquoise.setExtraStats(70);
        turquoise.setBowStats(1.0f, 1.5f, 3);
    }

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.ventium) {
            ventium.setFluid(ModuleFluids.ventium);
            ventium.addCommonItems("Ventium");
            ventium.preInit("Ventium", ModuleFluids.ventium);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(ventium, 0);
            }
            Materials.mats.add(ventium.getMat());
        }
        if(Config.horizonite) {
            horizonite.setFluid(ModuleFluids.horizonite);
            horizonite.addCommonItems("Horizonite");
            horizonite.preInit("Horizonite", ModuleFluids.horizonite);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(horizonite, 0);
            }
            Materials.mats.add(horizonite.getMat());
        }
        if(Config.pyrope) {
            pyrope.addCommonItems("Pyrope");
            pyrope.setFluid(ModuleFluids.pyrope);
            pyrope.preInit("Pyrope", "gem", ModuleFluids.pyrope);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(pyrope, 0);
            }
            Materials.mats.add(pyrope.getMat());
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
