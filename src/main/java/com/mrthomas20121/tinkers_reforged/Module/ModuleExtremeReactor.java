package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import com.mrthomas20121.libs.RegistryLib;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import net.minecraftforge.fluids.FluidRegistry;

public class ModuleExtremeReactor extends ModuleBase {
    public RegistryLib yellorium = new RegistryLib(Materials.yellorium);
    public RegistryLib blutonium = new RegistryLib(Materials.blutonium);
    public RegistryLib ludicrite = new RegistryLib(Materials.ludicrite);
    public RegistryLib cyanite = new RegistryLib(Materials.cyanite);

    public ModuleExtremeReactor() {

        yellorium.setCraftable(false);
        yellorium.setCastable(true);
        yellorium.addCommonItems("yellorium");
        yellorium.registerHeadStats(200, 5f, 5f, HarvestLevels.OBSIDIAN);
        yellorium.registerHandleStats(1f, 100);
        yellorium.registerExtraStats(20);
        yellorium.addMaterialTrait(Traits.radioactive);
        Materials.mats.add(yellorium.getMat());

        blutonium.setCraftable(false);
        blutonium.setCastable(true);
        blutonium.addCommonItems("Blutonium");
        blutonium.registerHeadStats(200, 6f, 6f, HarvestLevels.OBSIDIAN);
        blutonium.registerHandleStats(1f, 120);
        blutonium.registerExtraStats(20);
        blutonium.addMaterialTrait(Traits.nuclearwaste);
        Materials.mats.add(blutonium.getMat());

        ludicrite.setCraftable(false);
        ludicrite.setCastable(true);
        ludicrite.addCommonItems("Ludicrite");
        ludicrite.registerHeadStats(200, 7f, 7f, HarvestLevels.COBALT);
        ludicrite.registerHandleStats(1f, 140);
        ludicrite.registerExtraStats(20);
        ludicrite.addMaterialTrait(Traits.nuclearwaste);
        ludicrite.addMaterialTrait(Traits.radioactive, MaterialTypes.HEAD);
        Materials.mats.add(ludicrite.getMat());

        cyanite.setCraftable(false);
        cyanite.setCastable(true);
        cyanite.addCommonItems("Cyanite");
        cyanite.registerHeadStats(200, 5f, 5f, HarvestLevels.OBSIDIAN);
        cyanite.registerHandleStats(1f, 100);
        cyanite.registerExtraStats(20);
        cyanite.addMaterialTrait(Traits.nuclearwaste);
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
