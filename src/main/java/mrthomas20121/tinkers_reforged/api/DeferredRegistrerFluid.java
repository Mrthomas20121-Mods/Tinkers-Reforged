package mrthomas20121.tinkers_reforged.api;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeferredRegistrerFluid {

    public static DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, TinkersReforged.MOD_ID);

    public void register(IEventBus bus) {
        FLUIDS.register(bus);
    }

    public ReforgedFluid register(String key, int temp, int light) {
        return ReforgedFluid.register(key, temp, light);
    }
}
