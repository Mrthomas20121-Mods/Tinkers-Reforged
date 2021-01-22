package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.library.MaterialGen;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

public class ModuleHeatAndClimate implements ModuleBase {

    private MaterialGen nickel_silver = new MaterialGen("nickel_silver", 0x0, "NickelSilver", 800);
    private MaterialGen tool_steel = new MaterialGen("tool_steel", 0x0, "ToolSteel", 900);
    private MaterialGen titanium_alloy = new MaterialGen("titanium_alloy", 0x0, "TitaniumAlloy", 700);
    private MaterialGen Mangalloy = new MaterialGen("mangalloy", 0x0, "Mangalloy", 700);

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {

    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        if(FluidRegistry.isFluidRegistered("manganese")) {
            TinkerSmeltery.registerOredictMeltingCasting(FluidRegistry.getFluid("manganese"), "Manganese");
        }

    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
