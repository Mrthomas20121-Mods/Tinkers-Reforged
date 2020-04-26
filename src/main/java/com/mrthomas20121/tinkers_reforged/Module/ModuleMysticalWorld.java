package com.mrthomas20121.tinkers_reforged.Module;

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

    public ModuleMysticalWorld() {
        Materials.mats.add(Materials.amethyst);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.amethyst) {
            TinkerRegistry.addMaterialStats(Materials.amethyst,
                    new HeadMaterialStats(300, 6f, 5f, HarvestLevels.COBALT),
                    new HandleMaterialStats(1f, 200),
                    new ExtraMaterialStats(30));
            Materials.amethyst.addItem("gemAmethyst", 1, Material.VALUE_Gem);
            Materials.amethyst.setCraftable(true).setCastable(false);
            Materials.amethyst.addTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
            Materials.amethyst.addTrait(TinkerTraits.sharp);
            MaterialIntegration amethystmi = new MaterialIntegration(Materials.amethyst).setRepresentativeItem("gemAmethyst");
            TinkerRegistry.integrate(amethystmi).preInit();
        }
    }
    @Override
    public void init(FMLInitializationEvent e) { }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}
