package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleRoots extends ModuleBase {
    public RegistryLib runestone = new RegistryLib(Materials.runestone);

    public ModuleRoots() {
        runestone.setCraftable(true);
        runestone.setCastable(false);
        runestone.registerHeadStats(200, 4f, 4f, HarvestLevels.STONE);
        runestone.registerHandleStats(1f, 100);
        runestone.registerExtraStats(-10);
        runestone.addMaterialTrait(TinkerTraits.cheap, MaterialTypes.HEAD);
        runestone.addMaterialTrait(TinkerTraits.cheapskate);
        Materials.mats.add(runestone.getMat());
    }

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.runestone) {
            runestone.preInit("runestone");
        }
    }
    public void init(FMLInitializationEvent e) {
        runestone.setRepresentativeItem("runestone");
    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
