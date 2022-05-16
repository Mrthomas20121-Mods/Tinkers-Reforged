package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FluidObject;

public class TinkersReforgedFluids {

    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(TinkersReforged.MOD_ID);

    public static FluidObject<ForgeFlowingFluid> lapis = register("molten_lapis", 900);
    public static FluidObject<ForgeFlowingFluid> redstone = register("molten_redstone", 800);
    public static FluidObject<ForgeFlowingFluid> blazing_copper = register("molten_blazing_copper", 1700);
    public static FluidObject<ForgeFlowingFluid> duralumin = register("molten_duralumin", 1000);
    public static FluidObject<ForgeFlowingFluid> electrical_copper = register("molten_electrical_copper", 1100);
    public static FluidObject<ForgeFlowingFluid> lavium = register("molten_lavium", 1500);
    public static FluidObject<ForgeFlowingFluid> qivium = register("molten_qivium", 1500);
    public static FluidObject<ForgeFlowingFluid> gausum = register("molten_gausum", 1500);
    public static FluidObject<ForgeFlowingFluid> felsteel = register("molten_felsteel", 1800);
    public static FluidObject<ForgeFlowingFluid> chorus_metal = register("molten_chorus_metal", 1500);
    public static FluidObject<ForgeFlowingFluid> kepu = register("molten_kepu", 1600);
    public static FluidObject<ForgeFlowingFluid> chorus = register("molten_chorus", 1200);
    public static FluidObject<ForgeFlowingFluid> shulker = register("molten_shulker", 1200);
    public static FluidObject<ForgeFlowingFluid> proto_lava = register("molten_proto_lava", 2500);

    private static FluidObject<ForgeFlowingFluid> register(String name, int temp) {
        String still = String.format("%s:block/fluid/%s_still", TinkersReforged.MOD_ID, name);
        String flow = String.format("%s:block/fluid/%s_flowing", TinkersReforged.MOD_ID, name);
        return FLUIDS.register(name, FluidAttributes.builder(new ResourceLocation(still), new ResourceLocation(flow)).density(2000).viscosity(10000).temperature(temp).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA), Material.LAVA, 15);
    }
}
