package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleThermal extends ModuleBase {
    private String lumium = "Lumium";
    private String enderium = "Enderium";
    private String signalum = "Signalum";

    public ModuleThermal() {
        Materials.mats.add(Materials.lumium);
        Materials.mats.add(Materials.enderium);
        Materials.mats.add(Materials.signalum);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {

        if(Config.enderium) {
            Fluid enderiumF = FluidRegistry.getFluid((enderium.toLowerCase()));
            TinkerRegistry.addMaterialStats(Materials.enderium,
                    new HeadMaterialStats(750, 9.0f, 8.5f, HarvestLevels.COBALT),
                    new HandleMaterialStats(0.9f, 170),
                    new ExtraMaterialStats(100));
            Materials.enderium.addCommonItems(enderium);
            Materials.enderium.setFluid(enderiumF);
            Materials.enderium.addTrait(Traits.enderfestation, MaterialTypes.HANDLE);
            Materials.enderium.addTrait(Traits.enderfestation, MaterialTypes.HEAD);
            Materials.enderium.addTrait(Traits.ender, MaterialTypes.HEAD);
            Materials.enderium.addTrait(Traits.enderfestation, MaterialTypes.EXTRA);
            Materials.enderium.setCraftable(false).setCastable(true);
            MaterialIntegration enderiummi = new MaterialIntegration(Materials.enderium, enderiumF).setRepresentativeItem("ingot" + enderium);
            TinkerRegistry.integrate(enderiummi).toolforge().preInit();
        }

        if(Config.signalum) {
            Fluid signalumF = FluidRegistry.getFluid((signalum.toLowerCase()));
            TinkerRegistry.addMaterialStats(Materials.signalum,
                    new HeadMaterialStats(540, 7.1f, 5f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1.3f, 90),
                    new ExtraMaterialStats(70));
            Materials.signalum.setCraftable(false).setCastable(true);
            Materials.signalum.addCommonItems(signalum);
            Materials.signalum.setFluid(signalumF);
            Materials.signalum.addTrait(Traits.signal, MaterialTypes.HANDLE);
            Materials.signalum.addTrait(Traits.signal, MaterialTypes.HEAD);
            Materials.signalum.addTrait(Traits.signal, MaterialTypes.EXTRA);
            MaterialIntegration signalumlmi = new MaterialIntegration(Materials.signalum, signalumF).setRepresentativeItem("ingot" + signalum);
            TinkerRegistry.integrate(signalumlmi).toolforge().preInit();
        }

        if(Config.lumium) {
            Fluid lumiumF = FluidRegistry.getFluid((lumium.toLowerCase()));
            TinkerRegistry.addMaterialStats(Materials.lumium,
                    new HeadMaterialStats(470, 7f, 5.1f, HarvestLevels.OBSIDIAN),
                    new HandleMaterialStats(1.2f, 90),
                    new ExtraMaterialStats(80));
            Materials.lumium.setCraftable(false).setCastable(true);
            Materials.lumium.addCommonItems(lumium);
            Materials.lumium.setFluid(lumiumF);
            Materials.lumium.addTrait(TinkerTraits.aridiculous, MaterialTypes.HANDLE);
            Materials.lumium.addTrait(Traits.light, MaterialTypes.HEAD);
            Materials.lumium.addTrait(Traits.light, MaterialTypes.EXTRA);
            MaterialIntegration lumiummi = new MaterialIntegration(Materials.lumium, lumiumF).setRepresentativeItem("ingot" + lumium);
            TinkerRegistry.integrate(lumiummi).toolforge().preInit();
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        if(Config.enderium) {
            Materials.enderium.setFluid(FluidRegistry.getFluid((enderium.toLowerCase())));
            Materials.enderium.setCastable(true).setCraftable(false);
        }

        if(Config.signalum) {
            Materials.signalum.setFluid(FluidRegistry.getFluid((signalum.toLowerCase())));
            Materials.signalum.setCastable(true).setCraftable(false);
        }

        if(Config.lumium) {
            Materials.lumium.setFluid(FluidRegistry.getFluid((lumium.toLowerCase())));
            Materials.lumium.setCastable(true).setCraftable(false);
        }
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
    @Override
    @SideOnly(Side.CLIENT)
    public void clientPostInit()
    {

    }
}
