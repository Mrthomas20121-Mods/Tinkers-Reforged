package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.util.Helpers;
import mrthomas20121.tinkers_reforged.api.material.EnumFluid;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FluidObject;

import java.util.Map;

public class TinkersReforgedFluids {

    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(TinkersReforged.MOD_ID);

    public static Map<EnumFluid, FluidObject<ForgeFlowingFluid>> ALL_FLUIDS = Helpers.mapOfKeys(EnumFluid.class,
            fluid -> register(fluid.getName(), fluid.getTemp()));

    private static FluidObject<ForgeFlowingFluid> register(String name, int temp) {
        String still = String.format("%s:block/fluid/%s/still", TinkersReforged.MOD_ID, name);
        String flow = String.format("%s:block/fluid/%s/flowing", TinkersReforged.MOD_ID, name);
        return FLUIDS.register(name, FluidAttributes.builder(new ResourceLocation(still), new ResourceLocation(flow)).density(2000).viscosity(10000).temperature(temp).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA), Material.LAVA, 15);
    }
}
