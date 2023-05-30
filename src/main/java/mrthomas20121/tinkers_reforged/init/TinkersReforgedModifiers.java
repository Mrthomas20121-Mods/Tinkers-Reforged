package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.modifier.*;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

// Some modifier class name are not the same as the modifier name to keep compat with worlds running older version of tinkers reforged
public class TinkersReforgedModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersReforged.MOD_ID);

    public static StaticModifier<Modifier> felsteel_fel_debris = MODIFIERS.register("fel_debris", FelDebrisModifier::new);

    public static StaticModifier<Modifier> qivium_anti_armor = MODIFIERS.register("blazing_fire", AntiArmorModifier::new);

    public static StaticModifier<Modifier> lavium_aridzone = MODIFIERS.register("arid_zone", AridZoneModifier::new);

    public static StaticModifier<Modifier> electrical_copper_electrostatic = MODIFIERS.register("electro_web", ElectrostaticModifier::new);

    public static StaticModifier<Modifier> duralumin_ultra_durable = MODIFIERS.register("ultra_durable", UltraDurableModifier::new);

    public static StaticModifier<Modifier> gausum_titanic_damage = MODIFIERS.register("titanic_damage", TitanicDamageModifier::new);

    public static StaticModifier<Modifier> chorus_metal_requiem = MODIFIERS.register("levitating_blob", RequiemModifier::new);

    public static StaticModifier<Modifier> ender_upgrade = MODIFIERS.register("damage_lock", EnderUpgradeModifier::new);

    public static StaticModifier<Modifier> durasteel_adapting = MODIFIERS.register("adapting", AdaptatingModifier::new);

    public static StaticModifier<Modifier> cutting_edge = MODIFIERS.register("cutting_edge", CuttingEdgeModifier::new);

    public static StaticModifier<Modifier> giant_cells = MODIFIERS.register("giant_cells", GiantCellsModifier::new);

    public static StaticModifier<Modifier> terra = MODIFIERS.register("terra", TerraModifier::new);

    public static StaticModifier<Modifier> spore_shot = MODIFIERS.register("spore_shot", SporeShotModifier::new);

    public static StaticModifier<Modifier> collapsed = MODIFIERS.register("collapsed", CollapsedModifier::new);

    public static StaticModifier<Modifier> crystallized_punch = MODIFIERS.register("crystallized_punch", CrystallizedPunchModifier::new);

    public static StaticModifier<Modifier> rare_earth = MODIFIERS.register("rare_earth", RareEarthModifier::new);

    public static StaticModifier<Modifier> effective_boost = MODIFIERS.register("effective_boost", EffectiveBoostModifier::new);

    public static StaticModifier<Modifier> water_power = MODIFIERS.register("wet_lattice", WaterPowerModifier::new);

    public static StaticModifier<Modifier> wet_soil = MODIFIERS.register("dry_lattice", WetSoilModifier::new);

    public static StaticModifier<Modifier> blazing_copper_spark = MODIFIERS.register("spark", SparkModifier::new);

    public static StaticModifier<Modifier> aluminum_rotective_mantle = MODIFIERS.register("protective_mantle", ProtectiveMantleModifier::new);

    public static StaticModifier<Modifier> magma_steel_unbending = MODIFIERS.register("unbending", UnbendingModifier::new);

    public static StaticModifier<Modifier> cyber_steel_swift_eye = MODIFIERS.register("swift_eye", SwiftEyeModifier::new);

    public static StaticModifier<Modifier> tenacity = MODIFIERS.register("tenacity", TenacityModifier::new);

    public static StaticModifier<Modifier> half_powered_fists = MODIFIERS.register("half_powered_fists", HalfPoweredFistsModifier::new);
}
