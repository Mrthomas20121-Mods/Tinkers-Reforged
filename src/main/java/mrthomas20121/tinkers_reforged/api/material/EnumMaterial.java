package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

import static slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider.*;

public enum EnumMaterial implements EnumData {

    BLAZIUM(false, ORDER_NETHER, EnumMaterialPalette.BLAZIUM, EnumMaterialStats.BLAZIUM),
    BOMIN(false, ORDER_NETHER, EnumMaterialPalette.BOMIN, EnumMaterialStats.BOMIN),
    DURALUMIN(false, ORDER_GENERAL, EnumMaterialPalette.DURALUMIN, EnumMaterialStats.DURALUMIN),
    DURASTEEL(false, ORDER_END, EnumMaterialPalette.DURASTEEL, EnumMaterialStats.DURASTEEL),
    ELECTRIC_COPPER(false, ORDER_GENERAL, EnumMaterialPalette.ELECTRIC_COPPER, EnumMaterialStats.ELECTRIC_COPPER),
    ENDER_BONE(true, ORDER_END, EnumMaterialPalette.ENDER_BONE, EnumMaterialStats.ENDER_BONE, "bone"),
    EPIDOTE(false, ORDER_GENERAL, EnumMaterialPalette.EPIDOTE, EnumMaterialStats.EPIDOTE, "crystal"),
    ETRYX(false, ORDER_END, EnumMaterialPalette.ETRYX, EnumMaterialStats.ETRYX),
    FEROBOLT(false, ORDER_NETHER, EnumMaterialPalette.FEROBOLT, EnumMaterialStats.FEROBOLT),
    HORNIUM(false, ORDER_END, EnumMaterialPalette.HORNIUM, EnumMaterialStats.HORNIUM),
    HUREAULITE(false, ORDER_GENERAL, EnumMaterialPalette.HUREAULITE, EnumMaterialStats.HUREAULITE, "crystal"),
    KEPU(false, ORDER_END, EnumMaterialPalette.KEPU, EnumMaterialStats.KEPU),
    LAVIUM(false, ORDER_NETHER, EnumMaterialPalette.LAVIUM, EnumMaterialStats.LAVIUM),
    MOSITE(false, ORDER_NETHER, EnumMaterialPalette.MOSITE, EnumMaterialStats.MOSITE),
    QIVIUM(false, ORDER_NETHER, EnumMaterialPalette.QIVIUM, EnumMaterialStats.QIVIUM),
    RED_BERYL(false, ORDER_GENERAL, EnumMaterialPalette.RED_BERYL, EnumMaterialStats.RED_BERYL, "crystal"),
    TIBERIUM(false, ORDER_END, EnumMaterialPalette.TIBERIUM, EnumMaterialStats.TIBERIUM),
    TITANIUM(false, ORDER_END, EnumMaterialPalette.TITANIUM, EnumMaterialStats.TITANIUM);

    public final MaterialId id;
    public final boolean craftable;
    public final int order;
    public final String fallback;
    public final EnumMaterialStats stats;
    public final EnumMaterialPalette palette;

    EnumMaterial(boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats) {
        // default fallback is metal
        this(craftable, order, palette, stats, "metal");
    }

    EnumMaterial(boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, String fallback) {
        this.id = create(this.getName());
        this.craftable = craftable;
        this.order = order;
        this.stats = stats;
        this.palette = palette;
        this.fallback = fallback;
    }

    private static MaterialId create(String name) {
        return new MaterialId(new ResourceLocation(TinkersReforged.MOD_ID, name));
    }
}
