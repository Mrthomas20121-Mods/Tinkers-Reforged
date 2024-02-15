package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedModifiers;
import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.LazyModifier;

import java.util.Map;
import java.util.function.Supplier;

import static slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider.*;

public enum EnumMaterial implements EnumData {

    BLAZIUM(2, false, ORDER_NETHER, EnumMaterialPalette.BLAZIUM, EnumMaterialStats.BLAZIUM, TinkersReforgedModifiers.hellish_repair, EnumFluid.BLAZIUM),
    BOMIN(3, false, ORDER_NETHER, EnumMaterialPalette.BOMIN, EnumMaterialStats.BOMIN, TinkersReforgedModifiers.overheated, EnumFluid.BOMIN),
    DURALUMIN(2, false, ORDER_GENERAL, EnumMaterialPalette.DURALUMIN, EnumMaterialStats.DURALUMIN, TinkersReforgedModifiers.rock_solid, EnumFluid.DURALUMIN),
    DURASTEEL(5, false, ORDER_END, EnumMaterialPalette.DURASTEEL, EnumMaterialStats.DURASTEEL, TinkersReforgedModifiers.adaptability, EnumFluid.DURASTEEL),
    ELECTRIC_COPPER(2, false, ORDER_GENERAL, EnumMaterialPalette.ELECTRIC_COPPER, EnumMaterialStats.ELECTRIC_COPPER, TinkersReforgedModifiers.excavation, EnumFluid.ELECTRICAL_COPPER),
    ENDER_BONE(2, true, ORDER_END, EnumMaterialPalette.ENDER_BONE, EnumMaterialStats.ENDER_BONE, "bone", TinkersReforgedModifiers.razor_sharp),
    EPIDOTE(2, false, ORDER_GENERAL, EnumMaterialPalette.EPIDOTE, EnumMaterialStats.EPIDOTE, "crystal", TinkersReforgedModifiers.rupture, EnumFluid.EPIDOTE),
    ETRYX(5, false, ORDER_END, EnumMaterialPalette.ETRYX, EnumMaterialStats.ETRYX, TinkersReforgedModifiers.frozen_blade, EnumFluid.ETRYX),
    FEROBOLT(3, false, ORDER_NETHER, EnumMaterialPalette.FEROBOLT, EnumMaterialStats.FEROBOLT, TinkersReforgedModifiers.dark_poison, EnumFluid.FEROBOLT),
    HORNIUM(5, false, ORDER_END, EnumMaterialPalette.HORNIUM, EnumMaterialStats.HORNIUM, TinkersReforgedModifiers.octal, EnumFluid.HORNIUM),
    HUREAULITE(2, false, ORDER_GENERAL, EnumMaterialPalette.HUREAULITE, EnumMaterialStats.HUREAULITE, "crystal", TinkersReforgedModifiers.sorcery, EnumFluid.HUREAULITE),
    KEPU(4, false, ORDER_END, EnumMaterialPalette.KEPU, EnumMaterialStats.KEPU, TinkersReforgedModifiers.extinguish, EnumFluid.KEPU),
    LAVIUM(3, false, ORDER_NETHER, EnumMaterialPalette.LAVIUM, EnumMaterialStats.LAVIUM, TinkersReforgedModifiers.hellfire, EnumFluid.LAVIUM),
    MOSITE(3, false, ORDER_NETHER, EnumMaterialPalette.MOSITE, EnumMaterialStats.MOSITE, TinkersReforgedModifiers.biome_effect, EnumFluid.MOSITE),
    QIVIUM(3, false, ORDER_NETHER, EnumMaterialPalette.QIVIUM, EnumMaterialStats.QIVIUM, TinkersReforgedModifiers.debris, EnumFluid.QIVIUM),
    RED_BERYL(2, false, ORDER_GENERAL, EnumMaterialPalette.RED_BERYL, EnumMaterialStats.RED_BERYL, "crystal", TinkersReforgedModifiers.headshot, EnumFluid.RED_BERYL),
    TIBERIUM(5, false, ORDER_END, EnumMaterialPalette.TIBERIUM, EnumMaterialStats.TIBERIUM, TinkersReforgedModifiers.gigantic, EnumFluid.TIBERIUM),
    TITANIUM(4, false, ORDER_END, EnumMaterialPalette.TITANIUM, EnumMaterialStats.TITANIUM, TinkersReforgedModifiers.nocturnal, EnumFluid.TITANIUM);

    public final MaterialId id;
    public final int tier;
    public final boolean craftable;
    public final int order;
    public final String fallback;
    public final EnumMaterialStats stats;
    public final EnumMaterialPalette palette;
    public final LazyModifier mod;
    public final EnumFluid fluid;

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, LazyModifier mod) {
        // default fallback is metal
        this(tier, craftable, order, palette, stats, "metal", mod);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, LazyModifier mod, EnumFluid fluid) {
        // default fallback is metal
        this(tier, craftable, order, palette, stats, "metal", mod, fluid);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, String fallback, LazyModifier mod) {
        this(tier, craftable, order, palette, stats, fallback, mod, null);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, String fallback, LazyModifier mod, EnumFluid fluid) {
        this.id = create(this.getName());
        this.craftable = craftable;
        this.order = order;
        this.stats = stats;
        this.palette = palette;
        this.fallback = fallback;
        this.tier = tier;
        this.mod = mod;
        this.fluid = fluid;
    }

    private static MaterialId create(String name) {
        return new MaterialId(new ResourceLocation(TinkersReforged.MOD_ID, name));
    }
}
