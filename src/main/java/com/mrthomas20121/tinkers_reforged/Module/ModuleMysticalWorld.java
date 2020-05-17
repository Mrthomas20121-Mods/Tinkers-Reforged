package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleMysticalWorld extends ModuleBase {

    public RegistryLib amethyst = new RegistryLib(Materials.amethyst);

    public ModuleMysticalWorld() {
        amethyst.setCraftable(true).setCastable(false);
        amethyst.registerMaterialTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
        amethyst.registerMaterialTrait(TinkerTraits.sharp);
        amethyst.registerHeadStats(300, 6f, 5f, HarvestLevels.DIAMOND);
        amethyst.registerHandleStats(1, 200);
        amethyst.registerExtraStats(30);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.amethyst) {
            amethyst.addGemItem("Amethyst");
            amethyst.preInit("Amethyst");
            Materials.mats.add(amethyst.getMat());
        }
    }
    @Override
    public void init(FMLInitializationEvent e) { }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}
