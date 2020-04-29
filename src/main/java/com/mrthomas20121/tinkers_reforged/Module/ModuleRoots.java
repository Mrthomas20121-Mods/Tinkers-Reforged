package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleRoots extends ModuleBase {
    public RegistryLib runestone = new RegistryLib(Materials.runestone);

    public ModuleRoots() {
        runestone.setCraftable(true);
        runestone.setCastable(false);
        runestone.addCommonItems("Blutonium");
        runestone.registerHeadStats(200, 4f, 4f, HarvestLevels.STONE);
        runestone.registerHandleStats(1f, 100);
        runestone.registerExtraStats(-10);
        runestone.registerMaterialTrait(TinkerTraits.cheap, MaterialTypes.HEAD);
        runestone.registerMaterialTrait(TinkerTraits.cheapskate);
        Materials.mats.add(runestone.getMat());
    }

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.runestone) {
            runestone.registerPreInit("runestone");
        }
    }
    public void init(FMLInitializationEvent e) {

    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
