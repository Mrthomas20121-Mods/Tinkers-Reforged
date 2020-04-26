package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.Config.Config;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleRoots extends ModuleBase {

    public ModuleRoots() {
        Materials.mats.add(Materials.runestone);
    }

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.runestone) {
            TinkerRegistry.addMaterialStats(Materials.runestone,
                    new HeadMaterialStats(200, 4f, 4f, HarvestLevels.STONE),
                    new HandleMaterialStats(1f, 100),
                    new ExtraMaterialStats(-10));
            Materials.amethyst.addItem("runestone", 1, Material.VALUE_Ingot);
            Materials.amethyst.setCraftable(true).setCastable(false);
            Materials.amethyst.addTrait(TinkerTraits.cheap, MaterialTypes.HEAD);
            Materials.amethyst.addTrait(TinkerTraits.cheapskate);
            MaterialIntegration amethystmi = new MaterialIntegration(Materials.amethyst).setRepresentativeItem("runestone");
            TinkerRegistry.integrate(amethystmi).preInit();
        }
    };
    public void init(FMLInitializationEvent e) {

    };
    public void postInit(FMLPostInitializationEvent e) {

    };
}
