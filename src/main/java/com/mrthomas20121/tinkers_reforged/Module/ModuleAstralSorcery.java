package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;
//import com.mrthomas20121.libs.SmelteryUtils;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAstralSorcery extends ModuleBase {

    public RegistryLib starmetal = new RegistryLib(Materials.starmetal);

    public ModuleAstralSorcery() {
        starmetal.setCraftable(false).setCastable(true);
        starmetal.registerMaterialTrait(Traits.astral, MaterialTypes.HEAD);
        starmetal.registerMaterialTrait(TinkerTraits.alien);
        starmetal.registerHeadStats(200, 5.2f, 3.2f, HarvestLevels.IRON);
        starmetal.registerHandleStats(0.9f, 70);
        starmetal.registerExtraStats(50);
        starmetal.registerBowStats(3.0f, 3f, 3f);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.starmetal) {
            starmetal.addCommonItems("AstralStarmetal");
            starmetal.addIngotItem("ingotAstralStarmetal");
            starmetal.addIngotItem("dustAstralStarmetal");
            starmetal.preInit("AstralStarmetal", FluidRegistry.getFluid("starmetal"));
            Materials.mats.add(starmetal.getMat());
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        starmetal.setCastable(true).setCraftable(false);
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}