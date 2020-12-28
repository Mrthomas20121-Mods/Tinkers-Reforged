package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import mrthomas20121.tinkers_reforged.ReforgedTraits;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class ModuleThermal implements ModuleBase {

    MaterialGen enderium = new MaterialGen("enderium", 0x006C5F, "Enderium", 1200);
    MaterialGen lumium = new MaterialGen("lumium", 0xEAD981, "Lumium", 1200);
    MaterialGen signalum = new MaterialGen("signalum", 0xA32500, "Signalum", 1200);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.enderium) {
			enderium.preInit();
            enderium.getMaterial().addTrait(ReforgedTraits.enderfestation);
            enderium.getMaterial().addTrait(ReforgedTraits.ender, MaterialTypes.HEAD);
            TinkerRegistry.addMaterial(enderium.getMaterial());
            TinkerRegistry.addMaterialStats(enderium.getMaterial(),
                    new HeadMaterialStats(750, 9.2f, 8.5f, HarvestLevels.COBALT),
                    new HandleMaterialStats(0.99f, 190),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(9.2f, 3.5f, 8.5f));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.lumium) {
			lumium.preInit();
            lumium.getMaterial().addTrait(ReforgedTraits.bright);
            lumium.getMaterial().addTrait(ReforgedTraits.rod, MaterialTypes.HEAD);
            TinkerRegistry.addMaterial(lumium.getMaterial());
            TinkerRegistry.addMaterialStats(lumium.getMaterial(),
                    new HeadMaterialStats(500, 9.2f, 8.5f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(0.99f, 190),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(5.2f, 1.5f, 10));
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.signalum) {
			signalum.preInit();
            signalum.getMaterial().addTrait(ReforgedTraits.teleport);
            signalum.getMaterial().addTrait(ReforgedTraits.flux, MaterialTypes.HEAD);
            TinkerRegistry.addMaterial(signalum.getMaterial());
            TinkerRegistry.addMaterialStats(signalum.getMaterial(),
                    new HeadMaterialStats(500, 9.2f, 8.5f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(0.99f, 190),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(5.2f, 1.5f, 10));
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        if(TinkersReforgedConfig.SettingMaterials.materials.enderium) {
            enderium.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.lumium) {
            lumium.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.materials.signalum) {
            signalum.init();
        }
        Fluid pyrotheum = FluidRegistry.getFluid("pyrotheum");
        pyrotheum.setTemperature(2273);
        if(TinkersReforgedConfig.SettingGeneral.mods.pyrotheum) TinkerRegistry.registerSmelteryFuel(new FluidStack(pyrotheum, 1000), 500);
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
