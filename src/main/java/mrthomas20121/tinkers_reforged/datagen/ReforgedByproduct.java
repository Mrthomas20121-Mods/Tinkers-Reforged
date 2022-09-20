package mrthomas20121.tinkers_reforged.datagen;

import net.minecraft.world.level.material.Fluid;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.IByproduct;
import slimeknights.tconstruct.library.recipe.FluidValues;

import java.util.Locale;
import java.util.function.Supplier;

public enum ReforgedByproduct implements IByproduct {
    BLAZING_BLOOD(true, TinkerFluids.blazingBlood),
    ENDER(true, TinkerFluids.moltenEnder);

    private final String name;
    private final boolean alwaysPresent;
    private final Supplier<? extends Fluid> fluidSupplier;
    private final int amount;

    ReforgedByproduct(boolean alwaysPresent, Supplier<? extends Fluid> fluidSupplier) {
        this.name = name().toLowerCase(Locale.ROOT);
        this.alwaysPresent = alwaysPresent;
        this.fluidSupplier = fluidSupplier;
        this.amount = FluidValues.INGOT;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isAlwaysPresent() {
        return alwaysPresent;
    }

    @Override
    public Fluid getFluid() {
        return fluidSupplier.get();
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
