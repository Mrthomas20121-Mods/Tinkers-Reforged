package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import slimeknights.tconstruct.common.TinkerTags;

import java.util.Arrays;

public enum EnumFluid implements EnumData {
    PROTO_LAVA(2000, TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING),
    BLAZIUM(1700, TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING),
    BOMIN(1500, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    DURALUMIN(1000, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    DURASTEEL(1800, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    ELECTRIC_COPPER(1100, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    EPIDOTE(1100),
    ETRYX(1300, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    FEROBOLT(1300, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    GALLIUM(1500, TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    HORNIUM(1800, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    HUREAULITE(1100),
    KEPU(1600, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    LAVIUM(1400, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    MOSITE(1400, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    QIVIUM(1400, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    RED_BERYL(1100, TinkerTags.Fluids.AVERAGE_METAL_SPILLING, TinkerTags.Fluids.METAL_TOOLTIPS),
    TIBERIUM(1800, TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING),
    TITANIUM(1600, TinkerTags.Fluids.EXPENSIVE_METAL_SPILLING);

    private final int temp;
    private final TagKey<Fluid>[] fluids;

    @SafeVarargs
    EnumFluid(int temp, TagKey<Fluid> ...fluids) {
        this.temp = temp;
        this.fluids = fluids;
    }

    EnumFluid(int temp) {
        this(temp, TinkerTags.Fluids.AVERAGE_METAL_SPILLING);
    }

    public boolean hasAlloy() {
        return Arrays.stream(EnumFluidAlloy.values()).anyMatch(e -> e.getName().equals(this.getName()));
    }

    public EnumFluidAlloy getAlloy() {
        return EnumFluidAlloy.valueOf(getName());
    }

    public TagKey<Fluid>[] getFluid() {
        return fluids;
    }

    public int getTemp() {
        return temp;
    }
}
