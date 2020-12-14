package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.MaterialGen;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.*;
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
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(enderium.getIdentifier())) {
            enderium.getMaterial().addTrait(new TraitEnderfestation());
            enderium.getMaterial().addTrait(new TraitEnder(), MaterialTypes.HEAD);
            TinkerRegistry.addMaterial(enderium.getMaterial());
            TinkerRegistry.addMaterialStats(enderium.getMaterial(),
                    new HeadMaterialStats(750, 9.2f, 8.5f, HarvestLevels.COBALT),
                    new HandleMaterialStats(0.99f, 190),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(9.2f, 3.5f, 8.5f));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(lumium.getIdentifier())) {
            lumium.getMaterial().addTrait(new TraitBright());
            lumium.getMaterial().addTrait(new TraitRod(), MaterialTypes.HEAD);
            TinkerRegistry.addMaterial(lumium.getMaterial());
            TinkerRegistry.addMaterialStats(lumium.getMaterial(),
                    new HeadMaterialStats(500, 9.2f, 8.5f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(0.99f, 190),
                    new ExtraMaterialStats(100),
                    new BowMaterialStats(5.2f, 1.5f, 10));
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(signalum.getIdentifier())) {
            signalum.getMaterial().addTrait(new TraitTeleport());
            signalum.getMaterial().addTrait(new TraitFlux(), MaterialTypes.HEAD);
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
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(enderium.getIdentifier())) {
            enderium.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(lumium.getIdentifier())) {
            lumium.init();
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(signalum.getIdentifier())) {
            signalum.init();
        }
        Fluid pyrotheum = FluidRegistry.getFluid("pyrotheum");
        pyrotheum.setTemperature(2000);
        if(TinkersReforgedConfig.SettingGeneral.pyrotheum) TinkerRegistry.registerSmelteryFuel(new FluidStack(pyrotheum, 1000), 500);
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
