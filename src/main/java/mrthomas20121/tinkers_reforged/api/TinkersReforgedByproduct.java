package mrthomas20121.tinkers_reforged.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import slimeknights.mantle.recipe.helper.FluidOutput;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.data.recipe.IByproduct;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.melting.IMeltingContainer;
import slimeknights.tconstruct.smeltery.data.Byproduct;

import java.util.Locale;

@RequiredArgsConstructor
@Getter
public enum TinkersReforgedByproduct implements IByproduct {

    GRAPHITE(true, TinkersReforgedFluids.METALS.get(Metal.GRAPHITE));

    private final String name;
    private final boolean alwaysPresent;
    private final FluidObject<?> fluid;
    private final int amount;
    private final int damageUnit;
    private final IMeltingContainer.OreRateType oreRate;

    TinkersReforgedByproduct(boolean alwaysPresent, FluidObject<?> fluid, int amount, int damageUnit, IMeltingContainer.OreRateType oreRate) {
        this.name = name().toLowerCase(Locale.ROOT);
        this.alwaysPresent = alwaysPresent;
        this.fluid = fluid;
        this.amount = amount;
        this.damageUnit = damageUnit;
        this.oreRate = oreRate;
    }

    TinkersReforgedByproduct(boolean alwaysPresent, FluidObject<?> fluid) {
        this(alwaysPresent, fluid, FluidValues.INGOT, FluidValues.NUGGET, IMeltingContainer.OreRateType.METAL);
    }

    @Override
    public FluidOutput getFluid(float scale) {
        return fluid.result((int)(amount * scale));
    }
}
