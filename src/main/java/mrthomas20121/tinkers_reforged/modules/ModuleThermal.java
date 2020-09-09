package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.FluidUtils;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
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

    public ModuleThermal() {
        Resources.enderium.builder.setTrait(Traits.enderfestation);
        Resources.enderium.builder.setTrait(Traits.ender, MaterialTypes.HEAD);
        Resources.enderium.builder.setHeadStats(750, 9.0f, 8.5f, HarvestLevels.COBALT);
        Resources.enderium.builder.setHandleStats(0.9f, 170);
        Resources.enderium.builder.setExtraStats(90);
        Resources.enderium.builder.setBowStats(2, 1.5f, 7);

        Resources.signalum.builder.setTrait(Traits.signal);
        Resources.signalum.builder.setTrait(Traits.flux);
        Resources.signalum.builder.setHeadStats(540, 7.3f, 6.9f, HarvestLevels.OBSIDIAN);
        Resources.signalum.builder.setHandleStats(1.3f, 90);
        Resources.signalum.builder.setExtraStats(80);
        Resources.signalum.builder.setBowStats(4.5f, 1, 6);

        Resources.lumium.builder.setTrait(Traits.light);
        Resources.lumium.builder.setHeadStats(470, 7f, 5.1f, HarvestLevels.OBSIDIAN);
        Resources.lumium.builder.setHandleStats(1.2f, 90);
        Resources.lumium.builder.setExtraStats(80);
        Resources.lumium.builder.setBowStats(2, 1, 9);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {

        if(ConfigMaterials.enderium)
        {
            Resources.enderium.builder.addCommonItems("Enderium");
            Resources.enderium.builder.preInit("Enderium", FluidUtils.getFluid("enderium"));
            Resources.materials.add(Resources.enderium);
        }
        if(ConfigMaterials.signalum)
        {
            Resources.signalum.builder.addCommonItems("Signalum");
            Resources.signalum.builder.preInit("Signalum", FluidUtils.getFluid("signalum"));
            Resources.materials.add(Resources.signalum);
        }

        if(ConfigMaterials.lumium)
        {
            Resources.lumium.builder.addCommonItems("Lumium");
            Resources.lumium.builder.preInit("Lumium", FluidUtils.getFluid("Lumium"));
            Resources.materials.add(Resources.lumium);
        }

        if(Loader.isModLoaded("conarm"))
        {
            if(ConfigMaterials.lumium) armorUtils.setArmorStats(Resources.lumium.builder, 1);
            if(ConfigMaterials.signalum) armorUtils.setArmorStats(Resources.signalum.builder, 1);
            if(ConfigMaterials.enderium) armorUtils.setArmorStats(Resources.enderium.builder, 2);
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {

    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
}
