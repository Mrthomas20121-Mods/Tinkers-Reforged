package mrthomas20121.tinkers_reforged.Module;

import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleThermal implements ModuleBase {
    private String lumiumOre = "Lumium";
    private String enderiumOre = "Enderium";
    private String signalumOre = "Signalum";
    private String platinumOre = "Platinum";
    private String iridiumOre = "Iridium";
    private String invarOre = "Invar";
    private String aluminumOre = "Aluminum";
    public MaterialBuilder platinum = new MaterialBuilder(Materials.platinum);
    public MaterialBuilder iridium = new MaterialBuilder(Materials.iridium);
    public MaterialBuilder invar = new MaterialBuilder(Materials.invar);
    public MaterialBuilder aluminum = new MaterialBuilder(Materials.aluminum);
    public MaterialBuilder enderium = new MaterialBuilder(Materials.enderium);
    public MaterialBuilder signalum = new MaterialBuilder(Materials.signalum);
    public MaterialBuilder lumium = new MaterialBuilder(Materials.lumium);

    public ModuleThermal() {

        enderium.setCraftable(false).setCastable(true);
        enderium.setTrait(Traits.enderfestation);
        enderium.setTrait(Traits.ender, MaterialTypes.HEAD);
        enderium.setHeadStats(750, 9.0f, 8.5f, HarvestLevels.COBALT);
        enderium.setHandleStats(0.9f, 170);
        enderium.setExtraStats(90);
        enderium.setBowStats(2, 1.5f, 7);

        signalum.setCraftable(false).setCastable(true);
        signalum.setTrait(Traits.signal);
        signalum.setTrait(Traits.flux);
        signalum.setHeadStats(540, 7.3f, 6.9f, HarvestLevels.OBSIDIAN);
        signalum.setHandleStats(1.3f, 90);
        signalum.setExtraStats(80);
        signalum.setBowStats(4.5f, 1, 6);

        lumium.setCraftable(false).setCastable(true);
        lumium.setTrait(Traits.light);
        lumium.setHeadStats(470, 7f, 5.1f, HarvestLevels.OBSIDIAN);
        lumium.setHandleStats(1.2f, 90);
        lumium.setExtraStats(80);
        lumium.setBowStats(2, 1, 9);

        platinum.setCraftable(false).setCastable(true);
        platinum.setTrait(TinkerTraits.dense);
        platinum.setHeadStats(500, 7.0f, 6.5f, HarvestLevels.OBSIDIAN);
        platinum.setHandleStats(0.9f, 90);
        platinum.setExtraStats(10);
        platinum.setBowStats(2, 1.5f, 7);

        iridium.setCastable(true).setCraftable(false);
        iridium.setHeadStats(500, 7.1f, 6.4f, HarvestLevels.OBSIDIAN);
        iridium.setHandleStats(1f, 90);
        iridium.setExtraStats(15);
        iridium.setTrait(TinkerTraits.dense);
        iridium.setBowStats(2, 1.5f, 7);

        invar.setCastable(true).setCraftable(false);
        invar.setHeadStats(500, 5.7f, 6.3f, HarvestLevels.OBSIDIAN);
        invar.setHandleStats(1f, 90);
        invar.setExtraStats(15);
        invar.setTrait(TinkerTraits.hellish);
        invar.setBowStats(2, 1.5f, 7);

        aluminum.setCastable(true).setCraftable(false);
        aluminum.setHeadStats(450, 6.1f, 6f, HarvestLevels.OBSIDIAN);
        aluminum.setHandleStats(1f, 70);
        aluminum.setExtraStats(30);
        aluminum.setTrait(TinkerTraits.dense);
        aluminum.setBowStats(2, 1.5f, 7);

    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.enderium) {
            Fluid fluid = FluidRegistry.getFluid((enderiumOre.toLowerCase()));
            enderium.preInit(enderiumOre, fluid);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(enderium, 0);
            }
            Materials.mats.add(enderium.getMat());
        }
        if(Config.signalum) {
            Fluid fluid = FluidRegistry.getFluid((signalumOre.toLowerCase()));
            signalum.preInit(signalumOre, fluid);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(signalum, 0);
            }
            Materials.mats.add(signalum.getMat());
        }
        if(Config.lumium) {
            Fluid fluid = FluidRegistry.getFluid((lumiumOre.toLowerCase()));
            lumium.preInit(lumiumOre, fluid);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(lumium, 0);
            }
            Materials.mats.add(lumium.getMat());
        }
        if(Config.platinum) {
            platinum.addCommonItems(platinumOre);
            Fluid fluid = FluidRegistry.getFluid((platinumOre.toLowerCase()));
            platinum.preInit(platinumOre, fluid);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(platinum, 0);
            }
            Materials.mats.add(platinum.getMat());
        }
        if(Config.iridium) {
            iridium.addCommonItems(iridiumOre);
            Fluid fluid = FluidRegistry.getFluid((iridiumOre.toLowerCase()));
            iridium.preInit(iridiumOre, fluid);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(iridium, 0);
            }
            Materials.mats.add(iridium.getMat());
        }
        if(Config.invar) {
            invar.addCommonItems(invarOre);
            Fluid fluid = FluidRegistry.getFluid((invarOre.toLowerCase()));
            invar.preInit(invarOre, fluid);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(invar, 0);
            }
            Materials.mats.add(invar.getMat());
        }
        if(Config.aluminum) {
            aluminum.addCommonItems(aluminumOre);
            Fluid fluid = FluidRegistry.getFluid((aluminumOre.toLowerCase()));
            aluminum.preInit(aluminumOre, fluid);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(aluminum, 0);
            }
            Materials.mats.add(aluminum.getMat());
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        if(Config.enderium) {
            enderium.registerInitFluid(FluidRegistry.getFluid((enderiumOre.toLowerCase())), enderiumOre);
            enderium.setCastable(true).setCraftable(false);
            //this.registerDefaultCasting(enderiumOre, FluidRegistry.getFluid((enderiumOre.toLowerCase())), false);
        }
        if(Config.signalum) {
            signalum.registerInitFluid(FluidRegistry.getFluid((signalumOre.toLowerCase())), signalumOre);
            signalum.setCastable(true).setCraftable(false);
            //this.registerDefaultCasting(signalumOre, FluidRegistry.getFluid((signalumOre.toLowerCase())), false);
        }
        if(Config.lumium) {
            lumium.registerInitFluid(FluidRegistry.getFluid((lumiumOre.toLowerCase())), lumiumOre);
            lumium.setCastable(true).setCraftable(false);
            //this.registerDefaultCasting(lumiumOre, FluidRegistry.getFluid((lumiumOre.toLowerCase())), false);
        }
        if(Config.iridium) {
            iridium.registerInitFluid(FluidRegistry.getFluid((iridiumOre.toLowerCase())), iridiumOre);
            iridium.setCraftable(false).setCastable(true);
            //this.registerDefaultCasting(iridiumOre, FluidRegistry.getFluid((iridiumOre.toLowerCase())), false);
        }
        if(Config.invar) {
            invar.registerInitFluid(FluidRegistry.getFluid((invarOre.toLowerCase())), iridiumOre);
            invar.setCraftable(false).setCastable(true);
            //this.registerDefaultCasting(invarOre, FluidRegistry.getFluid((invarOre.toLowerCase())), false);
        }
        if(Config.platinum) {
            platinum.registerInitFluid(FluidRegistry.getFluid((platinumOre.toLowerCase())), platinumOre);
            platinum.setCraftable(false).setCastable(true);
        }
        if(Config.pyrotheum) {
            TinkerRegistry.registerSmelteryFuel(new FluidStack(FluidRegistry.getFluid("pyrotheum").setTemperature(2000), 1000), 1000);
        }
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
