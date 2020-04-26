package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

import static com.mrthomas20121.tinkers_reforged.Module.Materials.mats;

public class ModuleAstralSorcery extends ModuleBase {

    public ModuleAstralSorcery() {
        mats.add(Materials.starmetal);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        // starmetal
        TinkerRegistry.addMaterialStats(Materials.starmetal,
                new HeadMaterialStats(200, 5.2f, 3.2f, HarvestLevels.IRON),
                new HandleMaterialStats(0.9f, 70),
                new ExtraMaterialStats(50),
                new BowMaterialStats(3.0f, 3f, 3f));
        Materials.starmetal.addItem("ingotAstralStarmetal", 1, Material.VALUE_Ingot);
        Materials.starmetal.addItem("dustAstralStarmetal", 1, Material.VALUE_Ingot);
        Materials.starmetal.setCraftable(true).setCastable(false);
        Materials.starmetal.addTrait(Traits.astral, MaterialTypes.HEAD);
        Materials.starmetal.addTrait(TinkerTraits.alien);
        MaterialIntegration starmetalmi = new MaterialIntegration(Materials.starmetal).setRepresentativeItem("ingotAstralStarmetal");
        TinkerRegistry.integrate(starmetalmi).preInit();
    }
    @Override
    public void init(FMLInitializationEvent e) {

    }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}
