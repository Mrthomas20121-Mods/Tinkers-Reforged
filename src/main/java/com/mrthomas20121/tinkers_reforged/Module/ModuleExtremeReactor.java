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
        yellorium.registerMaterialTrait(Traits.radioactive);
        Materials.mats.add(yellorium.getMat());

        blutonium.setCraftable(false);
        blutonium.setCastable(true);
        blutonium.addCommonItems("Blutonium");
        blutonium.registerHeadStats(200, 6f, 6f, HarvestLevels.OBSIDIAN);
        blutonium.registerHandleStats(1f, 120);
        blutonium.registerExtraStats(20);
        blutonium.registerMaterialTrait(Traits.nuclearwaste);
        Materials.mats.add(blutonium.getMat());

        ludicrite.setCraftable(false);
        ludicrite.setCastable(true);
        ludicrite.addCommonItems("Ludicrite");
        ludicrite.registerHeadStats(200, 7f, 7f, HarvestLevels.COBALT);
        ludicrite.registerHandleStats(1f, 140);
        ludicrite.registerExtraStats(20);
        ludicrite.registerMaterialTrait(Traits.nuclearwaste);
        ludicrite.registerMaterialTrait(Traits.radioactive, MaterialTypes.HEAD);
        Materials.mats.add(ludicrite.getMat());

        cyanite.setCraftable(false);
        cyanite.setCastable(true);
        cyanite.addCommonItems("Cyanite");
        cyanite.registerHeadStats(200, 5f, 5f, HarvestLevels.OBSIDIAN);
        cyanite.registerHandleStats(1f, 100);
        cyanite.registerExtraStats(20);
        cyanite.registerMaterialTrait(Traits.nuclearwaste);
        Materials.mats.add(cyanite.getMat());
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.yellorium) {
            yellorium.setFluid(FluidRegistry.getFluid("yellorium"));
            yellorium.registerPreInit("Yellorium", FluidRegistry.getFluid("yellorium"));
        }
        if(Config.blutonium) {
            FluidRegistry.registerFluid(ModuleFluids.blutonium);
            FluidRegistry.addBucketForFluid(ModuleFluids.blutonium);
            blutonium.setFluid(ModuleFluids.blutonium);
            blutonium.registerPreInit("Blutonium", ModuleFluids.blutonium);
        }
        if(Config.ludicrite) {
            FluidRegistry.registerFluid(ModuleFluids.ludicrite);
            FluidRegistry.addBucketForFluid(ModuleFluids.ludicrite);
            ludicrite.setFluid(ModuleFluids.ludicrite);
            ludicrite.registerPreInit("Ludicrite", ModuleFluids.ludicrite);
        }
        if(Config.cyanite) {
            cyanite.setFluid(FluidRegistry.getFluid("cyanite"));
            cyanite.registerPreInit("Cyanite", FluidRegistry.getFluid("cyanite"));
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        if(Config.yellorium) {
            yellorium.registerInitFluid(FluidRegistry.getFluid("yellorium"), "Yellorium");
            //this.registerDefaultMelting("Yellorium", BrFluids.fluidYellorium);
        }
        if(Config.cyanite) {
            cyanite.registerInitFluid(FluidRegistry.getFluid("cyanite"), "Cyanite");
           //this.registerDefaultMelting("Cyanite", BrFluids.fluidCyanite);
        }
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
