package mrthomas20121.tinkers_reforged.api;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.mantle.registration.object.FluidObject;

public abstract class AbstractFluid {

    protected RegistryObject<ForgeFlowingFluid.Source> stillFluid;
    protected RegistryObject<ForgeFlowingFluid.Flowing> flowingFluid;

    protected RegistryObject<FlowingFluidBlock> block;
    protected RegistryObject<Item> bucket;

    protected FluidObject<ForgeFlowingFluid> object;

    protected ForgeFlowingFluid.Properties properties;

    protected AbstractFluid(String name, FluidAttributes.Builder attributes) {

        stillFluid = DeferredRegistrerFluid.FLUIDS.register(name, () -> new ForgeFlowingFluid.Source(properties));
        flowingFluid = DeferredRegistrerFluid.FLUIDS.register(flowing(name), () -> new ForgeFlowingFluid.Flowing(properties));

        properties = new ForgeFlowingFluid.Properties(stillFluid, flowingFluid, attributes);
    }

    public Fluid getFluid() {
        return stillFluid.get().getFluid();
    }

    public FluidObject<ForgeFlowingFluid> asObject() {
        return object;
    }

    public static String flowing(String fluid) {

        return fluid + "_flowing";
    }

    public static String bucket(String fluid) {

        return fluid + "_bucket";
    }
}
