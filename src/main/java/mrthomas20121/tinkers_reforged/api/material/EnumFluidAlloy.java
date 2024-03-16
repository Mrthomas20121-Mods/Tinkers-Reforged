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
    DURASTEEL(2000, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.DURASTEEL).get(), FluidValues.INGOT*2),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.KEPU).get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.moltenAluminum.get(), FluidValues.INGOT*3)
    ),
    ELECTRIC_COPPER(800, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.ELECTRIC_COPPER).get(), FluidValues.INGOT*2),
            () -> fs(TinkerFluids.moltenCopper.get(), FluidValues.INGOT*3),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.RED_BERYL).get(), FluidValues.BRICK)
    ),
    HORNIUM(600, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.HORNIUM).get(), FluidValues.INGOT*2),
            () -> fs(TinkerFluids.moltenAluminum.get(), FluidValues.INGOT),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.GALLIUM).get(), FluidValues.INGOT)
    ),
    MOSITE(800, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.MOSITE).get(), FluidValues.INGOT*2),
            () -> fs(TinkerFluids.moltenNetherite.get(), FluidValues.INGOT),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.GALLIUM).get(), FluidValues.INGOT)
    ),
    ETRYX(1500, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.ETRYX).get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.moltenAmethyst.get(), FluidValues.GEM),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.TITANIUM).get(), FluidValues.GEM)
    ),
    FEROBOLT(900, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.FEROBOLT).get(), FluidValues.INGOT),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.EPIDOTE).get(), FluidValues.GEM),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.HUREAULITE).get(), FluidValues.GEM),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.RED_BERYL).get(), FluidValues.GEM)
    ),
    BLAZIUM(1500, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.BLAZIUM).get(), FluidValues.INGOT*4),
            () -> fs(TinkerFluids.blazingBlood.get(), FluidAttributes.BUCKET_VOLUME / 2),
            () -> fs(TinkerFluids.moltenAmethyst.get(), FluidValues.GEM)
    ),
    BOMIN(1000, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.BOMIN).get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.magma.get(), FluidValues.SLIMEBALL*4),
            () -> fs(TinkerFluids.moltenAluminum.get(), FluidValues.INGOT)
    ),
    PROTO_LAVA_FROM_KEPU(1700, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.PROTO_LAVA).get(), FluidAttributes.BUCKET_VOLUME),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.KEPU).get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.moltenEnder.get(), FluidValues.SLIMEBALL*4),
            () -> fs(TinkerFluids.blazingBlood.get(), FluidAttributes.BUCKET_VOLUME)
    ),
    PROTO_LAVA_FROM_TITANIUM(1700, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.PROTO_LAVA).get(), FluidAttributes.BUCKET_VOLUME*2),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.TITANIUM).get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.moltenEnder.get(), FluidValues.SLIMEBALL*6),
            () -> fs(TinkerFluids.blazingBlood.get(), FluidAttributes.BUCKET_VOLUME)
    ),
    TIBERIUM(2000, () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.TIBERIUM).get(), FluidValues.INGOT),
            () -> fs(TinkerFluids.moltenEnder.get(), FluidValues.SLIMEBALL),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.TITANIUM).get(), FluidValues.INGOT),
            () -> fs(TinkersReforgedFluids.ALL_FLUIDS.get(EnumFluid.KEPU).get(), FluidValues.INGOT)
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
