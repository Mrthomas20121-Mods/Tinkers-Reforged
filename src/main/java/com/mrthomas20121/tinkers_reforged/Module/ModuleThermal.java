package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
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
    private String lumiumOre = "Lumium";
    private String enderiumOre = "Enderium";
    private String signalumOre = "Signalum";
    private String platinumOre = "Platinum";
    private String iridiumOre = "Iridium";
    private String invarOre = "Invar";
    private String aluminumOre = "Aluminum";
    public RegistryLib platinum = new RegistryLib(Materials.platinum);
    public RegistryLib iridium = new RegistryLib(Materials.iridium);
    public RegistryLib invar = new RegistryLib(Materials.invar);
    public RegistryLib aluminum = new RegistryLib(Materials.aluminum);
    public RegistryLib enderium = new RegistryLib(Materials.enderium);
    public RegistryLib signalum = new RegistryLib(Materials.signalum);
    public RegistryLib lumium = new RegistryLib(Materials.lumium);

    public ModuleThermal() {

        enderium.setCraftable(false).setCastable(true);
        enderium.registerMaterialTrait(Traits.enderfestation);
        enderium.registerMaterialTrait(Traits.ender, MaterialTypes.HEAD);
        enderium.registerHeadStats(750, 9.0f, 8.5f, HarvestLevels.COBALT);
        enderium.registerHandleStats(0.9f, 170);
        enderium.registerExtraStats(90);
        enderium.registerBowStats(2, 1.5f, 7);

        signalum.setCraftable(false).setCastable(true);
        signalum.registerMaterialTrait(Traits.signal);
        signalum.registerHeadStats(540, 7.3f, 6.9f, HarvestLevels.OBSIDIAN);
        signalum.registerHandleStats(1.3f, 90);
        signalum.registerExtraStats(80);
        signalum.registerBowStats(4.5f, 1, 6);

        lumium.setCraftable(false).setCastable(true);
        lumium.registerMaterialTrait(Traits.light);
        lumium.registerHeadStats(470, 7f, 5.1f, HarvestLevels.OBSIDIAN);
        lumium.registerHandleStats(1.2f, 90);
        lumium.registerExtraStats(80);
        lumium.registerBowStats(2, 1, 9);

        platinum.setCraftable(false).setCastable(true);
        platinum.registerMaterialTrait(TinkerTraits.dense);
        platinum.registerHeadStats(500, 7.0f, 6.5f, HarvestLevels.OBSIDIAN);
        platinum.registerHandleStats(0.9f, 90);
        platinum.registerExtraStats(10);
        platinum.registerBowStats(2, 1.5f, 7);

        iridium.setCastable(true).setCraftable(false);
        iridium.registerHeadStats(500, 7.1f, 6.4f, HarvestLevels.OBSIDIAN);
        iridium.registerHandleStats(1f, 90);
        iridium.registerExtraStats(15);
        iridium.registerMaterialTrait(TinkerTraits.dense);
        iridium.registerBowStats(2, 1.5f, 7);

        invar.setCastable(true).setCraftable(false);
        invar.registerHeadStats(500, 5.7f, 6.3f, HarvestLevels.OBSIDIAN);
        invar.registerHandleStats(1f, 90);
        invar.registerExtraStats(15);
        invar.registerMaterialTrait(TinkerTraits.hellish);
        invar.registerBowStats(2, 1.5f, 7);

        aluminum.setCastable(true).setCraftable(false);
        aluminum.registerHeadStats(450, 6.1f, 6f, HarvestLevels.OBSIDIAN);
        aluminum.registerHandleStats(1f, 70);
        aluminum.registerExtraStats(30);
        aluminum.registerMaterialTrait(TinkerTraits.dense);
        aluminum.registerBowStats(2, 1.5f, 7);

    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.enderium) {
            Fluid fluid = FluidRegistry.getFluid((enderiumOre.toLowerCase()));
            enderium.registerPreInit(enderiumOre, fluid);
            Materials.mats.add(enderium.getMat());
        }
        if(Config.signalum) {
            Fluid fluid = FluidRegistry.getFluid((signalumOre.toLowerCase()));
            signalum.registerPreInit(signalumOre, fluid);
            Materials.mats.add(signalum.getMat());
        }
        if(Config.lumium) {
            Fluid fluid = FluidRegistry.getFluid((lumiumOre.toLowerCase()));
            lumium.registerPreInit(lumiumOre, fluid);
            Materials.mats.add(lumium.getMat());
        }
        if(Config.platinum) {
            platinum.addCommonItems(platinumOre);
            Fluid fluid = FluidRegistry.getFluid((platinumOre.toLowerCase()));
            platinum.registerPreInit(platinumOre, fluid);
            Materials.mats.add(platinum.getMat());
        }
        if(Config.iridium) {
            iridium.addCommonItems(iridiumOre);
            Fluid fluid = FluidRegistry.getFluid((iridiumOre.toLowerCase()));
            iridium.registerPreInit(iridiumOre, fluid);
            Materials.mats.add(iridium.getMat());
        }
        if(Config.invar) {
            invar.addCommonItems(invarOre);
            Fluid fluid = FluidRegistry.getFluid((invarOre.toLowerCase()));
            invar.registerPreInit(invarOre, fluid);
            Materials.mats.add(invar.getMat());
        }
        if(Config.aluminum) {
            aluminum.addCommonItems(aluminumOre);
            Fluid fluid = FluidRegistry.getFluid((aluminumOre.toLowerCase()));
            aluminum.registerPreInit(aluminumOre, fluid);
            Materials.mats.add(aluminum.getMat());
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        if(Config.invar) {
            Fluid fluid = FluidRegistry.getFluid((invarOre.toLowerCase()));
            invar.registerInitFluid(fluid, invarOre);
            this.registerDefaultMelting(invarOre, fluid, true);
            invar.setCastable(true).setCraftable(false);
        }
        if(Config.aluminum) {
            Fluid fluid = FluidRegistry.getFluid((aluminumOre.toLowerCase()));
            aluminum.registerInitFluid(fluid, aluminumOre);
            this.registerDefaultMelting(aluminumOre, fluid, true);
            aluminum.setCastable(true).setCraftable(false);
        }
        if(Config.enderium) {
            Fluid fluid = FluidRegistry.getFluid((enderiumOre.toLowerCase()));
            enderium.registerInitFluid(fluid, enderiumOre);
            this.registerDefaultMelting(enderiumOre, fluid, true);
            enderium.setCastable(true).setCraftable(false);
        }
        if(Config.signalum) {
            Fluid fluid = FluidRegistry.getFluid((signalumOre.toLowerCase()));
            signalum.registerInitFluid(fluid, signalumOre);
            this.registerDefaultMelting(signalumOre, fluid, true);
            signalum.setCastable(true).setCraftable(false);
        }
        if(Config.lumium) {
            Fluid fluid = FluidRegistry.getFluid((lumiumOre.toLowerCase()));
            lumium.registerInitFluid(fluid, lumiumOre);
            this.registerDefaultMelting(lumiumOre, fluid, true);
            lumium.setCastable(true).setCraftable(false);
        }
        if(Config.iridium) {
            Fluid fluid = FluidRegistry.getFluid((iridiumOre.toLowerCase()));
            iridium.registerInitFluid(fluid, iridiumOre);
            this.registerDefaultMelting(iridiumOre, fluid, true);
            iridium.setCraftable(false).setCastable(true);
        }
        if(Config.platinum) {
            Fluid fluid = FluidRegistry.getFluid((platinumOre.toLowerCase()));
            platinum.registerInitFluid(fluid, platinumOre);
            this.registerDefaultMelting(platinumOre, fluid, true);
            platinum.setCraftable(false).setCastable(true);
        }
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
