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
    BOMIN(3, false, ORDER_NETHER, EnumMaterialPalette.BOMIN, EnumMaterialStats.BOMIN, TinkersReforgedModifiers.overheated, EnumFluid.BOMIN, "", "Deal more damage to entity on fire or immune to fire."),
    DURALUMIN(2, false, ORDER_GENERAL, EnumMaterialPalette.DURALUMIN, EnumMaterialStats.DURALUMIN, TinkersReforgedModifiers.rock_solid, EnumFluid.DURALUMIN, "a mix of aluminum and copper", "Increases the durability by 1.5."),
    DURASTEEL(5, false, ORDER_END, EnumMaterialPalette.DURASTEEL, EnumMaterialStats.DURASTEEL, TinkersReforgedModifiers.adaptability, EnumFluid.DURASTEEL, "", "Get bonus damage based on the difference between max and current durability. Max Durability give 0 bonus damage."),
    ELECTRIC_COPPER(2, false, ORDER_GENERAL, EnumMaterialPalette.ELECTRIC_COPPER, EnumMaterialStats.ELECTRIC_COPPER, TinkersReforgedModifiers.excavation, EnumFluid.ELECTRICAL_COPPER, "a mix of copper and clay", ""),
    ENDER_BONE(2, true, ORDER_GENERAL, EnumMaterialPalette.ENDER_BONE, EnumMaterialStats.ENDER_BONE, TinkersReforgedModifiers.mush, "liquid ender on bone", "Increases all tool stats but halve durability in half."),
    EPIDOTE(2, false, ORDER_GENERAL, EnumMaterialPalette.EPIDOTE, EnumMaterialStats.EPIDOTE, "crystal", TinkersReforgedModifiers.seasoned, EnumFluid.EPIDOTE, "Overworld gem material.", "Mob Drops get teleported to your inventory but you get no experience."),
    ETRYX(5, false, ORDER_END, EnumMaterialPalette.ETRYX, EnumMaterialStats.ETRYX, TinkersReforgedModifiers.frozen_blade, EnumFluid.ETRYX, "", "Freeze the target for 5s after hitting them."),
    FEROBOLT(3, false, ORDER_NETHER, EnumMaterialPalette.FEROBOLT, EnumMaterialStats.FEROBOLT, TinkersReforgedModifiers.dark_poison, EnumFluid.FEROBOLT, "Bow Material.", "50% chance to inflict wither to the target."),
    HORNIUM(5, false, ORDER_END, EnumMaterialPalette.HORNIUM, EnumMaterialStats.HORNIUM, TinkersReforgedModifiers.slot_machine, EnumFluid.HORNIUM, "a mix of .", "Get a free upgrade and ability for each level of this modifier."),
    HUREAULITE(2, false, ORDER_GENERAL, EnumMaterialPalette.HUREAULITE, EnumMaterialStats.HUREAULITE, "crystal", TinkersReforgedModifiers.supernatural, EnumFluid.HUREAULITE, "Overworld gem material.", "Deal bonus magic damage to the target."),
    KEPU(4, false, ORDER_END, EnumMaterialPalette.KEPU, EnumMaterialStats.KEPU, TinkersReforgedModifiers.extinguish, EnumFluid.KEPU, "End ore.", "Clear fire from target then deal bonus damage to it based on the fire duration."),
    LAVIUM(3, false, ORDER_NETHER, EnumMaterialPalette.LAVIUM, EnumMaterialStats.LAVIUM, TinkersReforgedModifiers.hellfire, EnumFluid.LAVIUM, "a mix of Cobalt, Blazing Blood and Liquid Souls", "Deal more damage to nether mobs."),
    MOSITE(3, false, ORDER_NETHER, EnumMaterialPalette.MOSITE, EnumMaterialStats.MOSITE, TinkersReforgedModifiers.biome_effect, EnumFluid.MOSITE, "", "Do more damage/mine faster based on the biomes temperature."),
    QIVIUM(3, false, ORDER_NETHER, EnumMaterialPalette.QIVIUM, EnumMaterialStats.QIVIUM, TinkersReforgedModifiers.debris, EnumFluid.QIVIUM, "", "Mine faster if you have the netherite upgrade"),
    RED_BERYL(2, false, ORDER_GENERAL, EnumMaterialPalette.RED_BERYL, EnumMaterialStats.RED_BERYL, "crystal", TinkersReforgedModifiers.headshot, EnumFluid.RED_BERYL, "Overworld gem material.", "Deal more damage to armored targets."),
    TIBERIUM(5, false, ORDER_END, EnumMaterialPalette.TIBERIUM, EnumMaterialStats.TIBERIUM, TinkersReforgedModifiers.gigantic, EnumFluid.TIBERIUM, "", "Deal more damage to entities with more max health than you."),
    TITANIUM(4, false, ORDER_END, EnumMaterialPalette.TITANIUM, EnumMaterialStats.TITANIUM, TinkersReforgedModifiers.slow_force, EnumFluid.TITANIUM, "End ore.", "");

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
