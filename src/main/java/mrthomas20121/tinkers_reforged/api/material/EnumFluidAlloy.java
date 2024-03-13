package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.recipe.FluidValues;

import java.util.function.Supplier;

public enum EnumFluidAlloy implements EnumData {

    LAVIUM(1100, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.LAVIUM).get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.moltenCobalt.get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.blazingBlood.get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.liquidSoul.get(), FluidValues.INGOT)
    ),
    QIVIUM(1100,() -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.QIVIUM).get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.moltenCobalt.get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.blazingBlood.get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.magma.get(), FluidValues.INGOT)
    ),
    DURALUMIN(800, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.DURALUMIN).get(), FluidValues.INGOT*2),
            () -> fs(TinkerFluids.moltenCopper.get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.moltenAluminum.get(), FluidValues.INGOT*3)
    ),
    ELECTRIC_COPPER(800, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.ELECTRIC_COPPER).get(), FluidValues.INGOT*2),
            () -> fs(TinkerFluids.moltenCopper.get(), FluidValues.INGOT*3),
            () -> fs(TinkerFluids.moltenClay.get(), FluidValues.BRICK)
    ),
    ETRYX(1500, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.ETRYX).get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.moltenAmethyst.get(), FluidValues.GEM),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.KEPU).get(), FluidValues.INGOT)
    ),
    BLAZIUM(1500, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.BLAZIUM).get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.blazingBlood.get(), FluidAttributes.BUCKET_VOLUME / 2),
            () -> fs(TinkerFluids.moltenAmethyst.get(), FluidValues.GEM)
    ),
    PROTO_LAVA(1500, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.PROTO_LAVA).get(), FluidAttributes.BUCKET_VOLUME),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.KEPU).get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.moltenEnder.get(), FluidValues.SLIMEBALL*4),
            () -> fs(Fluids.LAVA, FluidAttributes.BUCKET_VOLUME)
    );

    public final Supplier<FluidStack> output;
    public final Supplier<FluidStack>[] inputs;
    public final int temp;

    @SafeVarargs
    EnumFluidAlloy(int temp, Supplier<FluidStack> output, Supplier<FluidStack>... inputs) {
        this.output = output;
        this.inputs = inputs;
        this.temp = temp;
    }

    private static FluidStack fs(Fluid fluid, int amount) {
        return new FluidStack(fluid, amount);
    }
}
