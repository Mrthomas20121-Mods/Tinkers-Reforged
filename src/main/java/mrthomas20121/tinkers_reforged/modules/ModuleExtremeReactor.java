package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import net.minecraftforge.fluids.FluidRegistry;

public class ModuleExtremeReactor implements ModuleBase {

    public ModuleExtremeReactor() {

        Resources.yellorium.builder.setHeadStats(200, 5f, 5f, HarvestLevels.OBSIDIAN);
        Resources.yellorium.builder.setHandleStats(1f, 100);
        Resources.yellorium.builder.setExtraStats(20);
        Resources.yellorium.builder.setTrait(Traits.radioactive);

        Resources.blutonium.builder.setHeadStats(200, 6f, 6f, HarvestLevels.OBSIDIAN);
        Resources.blutonium.builder.setHandleStats(1f, 120);
        Resources.blutonium.builder.setExtraStats(20);
        Resources.blutonium.builder.setTrait(Traits.nuclearwaste);

        Resources.ludicrite.builder.setHeadStats(200, 7f, 7f, HarvestLevels.COBALT);
        Resources.ludicrite.builder.setHandleStats(1f, 140);
        Resources.ludicrite.builder.setExtraStats(20);
        Resources.ludicrite.builder.setTrait(Traits.nuclearwaste);
        Resources.ludicrite.builder.setTrait(Traits.radioactive, MaterialTypes.HEAD);

        Resources.cyanite.builder.setHeadStats(200, 5f, 5f, HarvestLevels.OBSIDIAN);
        Resources.cyanite.builder.setHandleStats(1f, 100);
        Resources.cyanite.builder.setExtraStats(20);
        Resources.cyanite.builder.setTrait(Traits.nuclearwaste);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        //Resources.yellorium.registerFluid();
        Resources.blutonium.registerFluid();
        Resources.ludicrite.registerFluid();

        if(ConfigMaterials.yellorium)
        {
            Resources.yellorium.builder.addCommonItems("Yellorium");
            Resources.yellorium.builder.setFluid(FluidRegistry.getFluid("yellorium"));
            Resources.yellorium.builder.preInit("Yellorium", FluidRegistry.getFluid("yellorium"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.yellorium.builder, 1f);
            }
            Resources.materials.add(Resources.yellorium);
        }

        if(ConfigMaterials.blutonium)
        {
            Resources.blutonium.builder.addCommonItems("Blutonium");
            Resources.blutonium.builder.setFluid(FluidRegistry.getFluid("blutonium"));
            Resources.blutonium.builder.preInit("Blutonium", FluidRegistry.getFluid("blutonium"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.blutonium.builder, 1f);
            }
            Resources.materials.add(Resources.blutonium);
        }

        if(ConfigMaterials.ludicrite)
        {
            Resources.ludicrite.builder.addCommonItems("Ludicrite");
            Resources.ludicrite.builder.setFluid(FluidRegistry.getFluid("ludicrite"));
            Resources.ludicrite.builder.preInit("Ludicrite", FluidRegistry.getFluid("ludicrite"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.ludicrite.builder, 1.5f);
            }
            Resources.materials.add(Resources.ludicrite);
        }

        //Resources.cyanite.registerFluid();
        if(ConfigMaterials.cyanite)
        {
            Resources.cyanite.builder.addCommonItems("Cyanite");
            Resources.cyanite.builder.setFluid(FluidRegistry.getFluid("cyanite"));
            Resources.cyanite.builder.preInit("Cyanite", FluidRegistry.getFluid("cyanite"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.cyanite.builder, 0);
            }
            Resources.materials.add(Resources.cyanite);
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        if(ConfigMaterials.yellorium) Resources.yellorium.builder.registerInitFluid(FluidRegistry.getFluid("yellorium"), "Yellorium");
        if(ConfigMaterials.cyanite) Resources.cyanite.builder.registerInitFluid(FluidRegistry.getFluid("cyanite"), "Cyanite");
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
