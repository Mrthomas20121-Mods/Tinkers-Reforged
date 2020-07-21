package mrthomas20121.tinkers_reforged.Module;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import mrthomas20121.biolib.common.MaterialBuilder;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import net.minecraftforge.fluids.FluidRegistry;

public class ModuleExtremeReactor implements ModuleBase {
    public MaterialBuilder yellorium = new MaterialBuilder(Materials.yellorium);
    public MaterialBuilder blutonium = new MaterialBuilder(Materials.blutonium);
    public MaterialBuilder ludicrite = new MaterialBuilder(Materials.ludicrite);
    public MaterialBuilder cyanite = new MaterialBuilder(Materials.cyanite);

    public ModuleExtremeReactor() {

        yellorium.setCraftable(false);
        yellorium.setCastable(true);
        yellorium.addCommonItems("yellorium");
        yellorium.setHeadStats(200, 5f, 5f, HarvestLevels.OBSIDIAN);
        yellorium.setHandleStats(1f, 100);
        yellorium.setExtraStats(20);
        yellorium.setTrait(Traits.radioactive);
        if(Loader.isModLoaded("conarm"))
        {
            armorUtils.setArmorStats(yellorium, 1f);
        }
        Materials.mats.add(yellorium.getMat());

        blutonium.setCraftable(false);
        blutonium.setCastable(true);
        blutonium.addCommonItems("Blutonium");
        blutonium.setHeadStats(200, 6f, 6f, HarvestLevels.OBSIDIAN);
        blutonium.setHandleStats(1f, 120);
        blutonium.setExtraStats(20);
        blutonium.setTrait(Traits.nuclearwaste);
        if(Loader.isModLoaded("conarm"))
        {
            armorUtils.setArmorStats(blutonium, 1f);
        }
        Materials.mats.add(blutonium.getMat());

        ludicrite.setCraftable(false);
        ludicrite.setCastable(true);
        ludicrite.addCommonItems("Ludicrite");
        ludicrite.setHeadStats(200, 7f, 7f, HarvestLevels.COBALT);
        ludicrite.setHandleStats(1f, 140);
        ludicrite.setExtraStats(20);
        ludicrite.setTrait(Traits.nuclearwaste);
        ludicrite.setTrait(Traits.radioactive, MaterialTypes.HEAD);
        if(Loader.isModLoaded("conarm"))
        {
            armorUtils.setArmorStats(ludicrite, 1.5f);
        }
        Materials.mats.add(ludicrite.getMat());

        cyanite.setCraftable(false);
        cyanite.setCastable(true);
        cyanite.addCommonItems("Cyanite");
        cyanite.setHeadStats(200, 5f, 5f, HarvestLevels.OBSIDIAN);
        cyanite.setHandleStats(1f, 100);
        cyanite.setExtraStats(20);
        cyanite.setTrait(Traits.nuclearwaste);
        if(Loader.isModLoaded("conarm"))
        {
            armorUtils.setArmorStats(cyanite, 0);
        }
        Materials.mats.add(cyanite.getMat());
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.yellorium) {
            yellorium.setFluid(FluidRegistry.getFluid("yellorium"));
            yellorium.preInit("Yellorium", FluidRegistry.getFluid("yellorium"));
        }
        if(Config.blutonium) {
            blutonium.setFluid(FluidRegistry.getFluid("blutonium"));
            blutonium.preInit("Blutonium", FluidRegistry.getFluid("blutonium"));
        }
        if(Config.ludicrite) {
            ludicrite.setFluid(FluidRegistry.getFluid("ludicrite"));
            ludicrite.preInit("Ludicrite", FluidRegistry.getFluid("ludicrite"));
        }
        if(Config.cyanite) {
            cyanite.setFluid(FluidRegistry.getFluid("cyanite"));
            cyanite.preInit("Cyanite", FluidRegistry.getFluid("cyanite"));
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        if(Config.yellorium) {
            yellorium.registerInitFluid(FluidRegistry.getFluid("yellorium"), "Yellorium");
        }
        if(Config.cyanite) {
            cyanite.registerInitFluid(FluidRegistry.getFluid("cyanite"), "Cyanite");
        }
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
