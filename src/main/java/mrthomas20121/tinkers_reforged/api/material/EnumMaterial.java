package mrthomas20121.tinkers_reforged.api.material;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedModifiers;
import mrthomas20121.tinkers_reforged.util.EnumData;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.util.LazyModifier;

import static slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider.*;

public enum EnumMaterial implements EnumData {

    BLAZIUM(2, false, ORDER_NETHER, EnumMaterialPalette.BLAZIUM, EnumMaterialStats.BLAZIUM, TinkersReforgedModifiers.hellish_repair, EnumFluid.BLAZIUM, "a mix of Blazing Blood and Amethyst", "Use no durability while attacking if target is on fire."),
    BOMIN(3, false, ORDER_NETHER, EnumMaterialPalette.BOMIN, EnumMaterialStats.BOMIN, TinkersReforgedModifiers.overheated, EnumFluid.BOMIN, "Nether Metal material.", "Deal more damage to entity on fire or immune to fire."),
    DURALUMIN(2, false, ORDER_GENERAL, EnumMaterialPalette.DURALUMIN, EnumMaterialStats.DURALUMIN, TinkersReforgedModifiers.rock_solid, EnumFluid.DURALUMIN, "Overworld Metal material.", "Increases the durability by 1.5."),
    DURASTEEL(5, false, ORDER_END, EnumMaterialPalette.DURASTEEL, EnumMaterialStats.DURASTEEL, TinkersReforgedModifiers.adaptability, EnumFluid.DURASTEEL, "End Metal material.", "Get bonus damage based on the difference between max and current durability. Max Durability give 0 bonus damage."),
    ELECTRIC_COPPER(2, false, ORDER_GENERAL, EnumMaterialPalette.ELECTRIC_COPPER, EnumMaterialStats.ELECTRIC_COPPER, TinkersReforgedModifiers.excavation, EnumFluid.ELECTRIC_COPPER, "Overworld Metal material.", "Each Different mined block give more mining speed."),
    ENDER_BONE(2, true, ORDER_GENERAL, EnumMaterialPalette.ENDER_BONE, EnumMaterialStats.ENDER_BONE, TinkersReforgedModifiers.mush, "End Metal material.", "Increases all tool stats but halve durability in half."),
    EPIDOTE(2, false, ORDER_GENERAL, EnumMaterialPalette.EPIDOTE, EnumMaterialStats.EPIDOTE, "crystal", TinkersReforgedModifiers.seasoned, EnumFluid.EPIDOTE, "Overworld gem material.", "Mob Drops get teleported to your inventory but you get no experience."),
    ETRYX(5, false, ORDER_END, EnumMaterialPalette.ETRYX, EnumMaterialStats.ETRYX, TinkersReforgedModifiers.frozen_blade, EnumFluid.ETRYX, "End Metal material.", "Freeze the target for 5s after hitting them."),
    FEROBOLT(3, false, ORDER_GENERAL, EnumMaterialPalette.FEROBOLT, EnumMaterialStats.FEROBOLT, TinkersReforgedModifiers.wither_arrow, EnumFluid.FEROBOLT, "Overworld Bow Metal material.", "50% chance to inflict wither to the target."),
    HORNIUM(5, false, ORDER_GENERAL, EnumMaterialPalette.HORNIUM, EnumMaterialStats.HORNIUM, TinkersReforgedModifiers.extinguish, EnumFluid.HORNIUM, "Overworld Metal material.", "Clear fire from target then deal bonus damage to it based on the fire duration."),
    HUREAULITE(2, false, ORDER_GENERAL, EnumMaterialPalette.HUREAULITE, EnumMaterialStats.HUREAULITE, "crystal", TinkersReforgedModifiers.supernatural, EnumFluid.HUREAULITE, "Overworld gem material.", "Deal bonus magic damage to the target."),
    KEPU(4, false, ORDER_END, EnumMaterialPalette.KEPU, EnumMaterialStats.KEPU, TinkersReforgedModifiers.wither_virus, EnumFluid.KEPU, "End Metal material..", "Deal more damage if you have the wither effect active."),
    LAVIUM(3, false, ORDER_NETHER, EnumMaterialPalette.LAVIUM, EnumMaterialStats.LAVIUM, TinkersReforgedModifiers.hellfire, EnumFluid.LAVIUM, "Nether Metal material.", "Deal more damage to nether mobs."),
    MOSITE(3, false, ORDER_NETHER, EnumMaterialPalette.MOSITE, EnumMaterialStats.MOSITE, TinkersReforgedModifiers.biome_effect, EnumFluid.MOSITE, "Nether Metal material.", "Do more damage/mine faster based on the biomes temperature."),
    QIVIUM(3, false, ORDER_NETHER, EnumMaterialPalette.QIVIUM, EnumMaterialStats.QIVIUM, TinkersReforgedModifiers.mythical_push, EnumFluid.QIVIUM, "Nether Metal material.", "Break blocks faster in the nether."),
    RED_BERYL(2, false, ORDER_GENERAL, EnumMaterialPalette.RED_BERYL, EnumMaterialStats.RED_BERYL, "crystal", TinkersReforgedModifiers.headshot, EnumFluid.RED_BERYL, "Overworld gem material.", "Deal more damage to armored targets."),
    TIBERIUM(5, false, ORDER_END, EnumMaterialPalette.TIBERIUM, EnumMaterialStats.TIBERIUM, TinkersReforgedModifiers.gigantic, EnumFluid.TIBERIUM, "End Metal Material.", "Deal more damage to entities with more max health than you."),
    TITANIUM(4, false, ORDER_END, EnumMaterialPalette.TITANIUM, EnumMaterialStats.TITANIUM, TinkersReforgedModifiers.force_cannon, EnumFluid.TITANIUM, "End Metal Material.", "Deal more damage based on the target health.");

    public final MaterialId id;
    public final int tier;
    public final boolean craftable;
    public final int order;
    public final String fallback;
    public final EnumMaterialStats stats;
    public final EnumMaterialPalette palette;
    public final LazyModifier mod;
    public final EnumFluid fluid;
    public final String materialDesc;
    public final String modifierDesc;

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, LazyModifier mod, String materialDesc, String modifierDesc) {
        // default fallback is metal
        this(tier, craftable, order, palette, stats, "metal", mod, materialDesc, modifierDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, LazyModifier mod, EnumFluid fluid, String materialDesc, String modifierDesc) {
        // default fallback is metal
        this(tier, craftable, order, palette, stats, "metal", mod, fluid, materialDesc, modifierDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, String fallback, LazyModifier mod, String materialDesc, String modifierDesc) {
        this(tier, craftable, order, palette, stats, fallback, mod, null, materialDesc, modifierDesc);
    }

    EnumMaterial(int tier, boolean craftable, int order, EnumMaterialPalette palette, EnumMaterialStats stats, String fallback, LazyModifier mod, EnumFluid fluid, String materialDesc, String modifierDesc) {
        this.id = create(this.getName());
        this.craftable = craftable;
        this.order = order;
        this.stats = stats;
        this.palette = palette;
        this.fallback = fallback;
        this.tier = tier;
        this.mod = mod;
        this.fluid = fluid;
        this.materialDesc = materialDesc;
        this.modifierDesc = modifierDesc;
    }

    private static MaterialId create(String name) {
        return new MaterialId(new ResourceLocation(TinkersReforged.MOD_ID, name));
    }
}
