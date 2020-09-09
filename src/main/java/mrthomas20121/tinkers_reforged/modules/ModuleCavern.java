package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.FluidUtils;
import mrthomas20121.tinkers_reforged.Traits.Traits;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.tools.TinkerTraits;
import slimeknights.tconstruct.library.utils.HarvestLevels;

public class ModuleCavern implements ModuleBase
{

    public ModuleCavern()
    {
        Resources.aquamarine.builder.setTrait(TinkerTraits.aquadynamic);
        Resources.aquamarine.builder.setHeadStats(204, 6f, 4f, HarvestLevels.IRON);
        Resources.aquamarine.builder.setHandleStats(1.20f, 0);
        Resources.aquamarine.builder.setExtraStats(50);

        Resources.magnite.builder.setTrait(TinkerTraits.aridiculous);
		Resources.magnite.builder.setHeadStats(150, 5f, 5f, HarvestLevels.DIAMOND);
        Resources.magnite.builder.setHandleStats(1.4f, 0);
        Resources.magnite.builder.setExtraStats(50);

        Resources.hexcite.builder.setTrait(Traits.refined);
		Resources.hexcite.builder.setHeadStats(150, 5f, 5f, HarvestLevels.DIAMOND);
        Resources.hexcite.builder.setHandleStats(1.4f, 0);
        Resources.hexcite.builder.setExtraStats(50);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e)
    {
        Resources.aquamarine.registerFluid();
        Resources.magnite.registerFluid();
        Resources.hexcite.registerFluid();

        if(ConfigMaterials.aquamarine)
        {
            Resources.aquamarine.builder.addCommonItems("Aquamarine");
            Resources.aquamarine.builder.addGem("Aquamarine");
            Resources.aquamarine.builder.preInit("Aquamarine", FluidUtils.getFluid("aquamarine"));
        }
        if(ConfigMaterials.magnite)
        {
            Resources.magnite.builder.addCommonItems("Magnite");
            Resources.magnite.builder.preInit("Magnite", FluidUtils.getFluid("magnite"));
        }
        if(ConfigMaterials.hexcite)
        {
            Resources.hexcite.builder.addCommonItems("Hexcite");
            Resources.hexcite.builder.preInit("Hexcite", FluidUtils.getFluid("hexcite"));
        }
    }

    @Override
    public void init(FMLInitializationEvent e)
    {
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) { }
}
