package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.modifier.*;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class TinkersReforgedModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersReforged.MOD_ID);

    public static StaticModifier<Modifier> felsteel_fel_debris = MODIFIERS.register("fel_debris", FelDebrisModifier::new);

    // changed the name but i'm keeping the modifier name the same to not make existing worlds have issues.
    public static StaticModifier<Modifier> qivium_blazing_fire = MODIFIERS.register("blazing_fire", BurningCapacitorModifier::new);

    public static StaticModifier<Modifier> lavium_aridzone = MODIFIERS.register("arid_zone", AridZoneModifier::new);

    public static StaticModifier<Modifier> electrical_copper_electro_web = MODIFIERS.register("electro_web", ElectroWebModifier::new);

    public static StaticModifier<Modifier> duralumin_ultra_durable = MODIFIERS.register("ultra_durable", UltraDurableModifier::new);

    public static StaticModifier<Modifier> gausum_titanic_damage = MODIFIERS.register("titanic_damage", TitanicDamageModifier::new);

    public static StaticModifier<Modifier> chorus_metal_levitating_blob = MODIFIERS.register("levitating_blob", LevitatingBlobModifier::new);

    public static StaticModifier<Modifier> kepu_damage_lock = MODIFIERS.register("damage_lock", EnderTaintModifier::new);

    public static StaticModifier<Modifier> durasteel_adapting = MODIFIERS.register("adapting", AdaptatingModifier::new);

    public static StaticModifier<Modifier> cutting_edge = MODIFIERS.register("cutting_edge", CuttingEdgeModifier::new);

    public static StaticModifier<Modifier> giant_cells = MODIFIERS.register("giant_cells", GiantCellsModifier::new);

    public static StaticModifier<Modifier> terra = MODIFIERS.register("terra", TerraModifier::new);

    public static StaticModifier<Modifier> spore_shot = MODIFIERS.register("spore_shot", SporeShotModifier::new);

    public static StaticModifier<Modifier> collapsed = MODIFIERS.register("collapsed", CollapsedModifier::new);

    public static StaticModifier<Modifier> crystallized_punch = MODIFIERS.register("crystallized_punch", CrystallizedPunchModifier::new);

    public static StaticModifier<Modifier> rare_earth = MODIFIERS.register("rare_earth", RareEarthModifier::new);

    public static StaticModifier<Modifier> effective_boost = MODIFIERS.register("effective_boost", EffectiveBoostModifier::new);

    public static StaticModifier<Modifier> wet_lattice = MODIFIERS.register("wet_lattice", WetLatticeModifier::new);

    public static StaticModifier<Modifier> dry_lattice = MODIFIERS.register("dry_lattice", DryLatticeModifier::new);

    public static StaticModifier<Modifier> blazing_copper_spark = MODIFIERS.register("spark", SparkModifier::new);

    public static StaticModifier<Modifier> aluminum_rotective_mantle = MODIFIERS.register("protective_mantle", ProtectiveMantleModifier::new);

    public static StaticModifier<Modifier> magma_steel_unbending = MODIFIERS.register("unbending", UnbendingModifier::new);

    public static StaticModifier<Modifier> cyber_steel_swift_eye = MODIFIERS.register("swift_eye", SwiftEyeModifier::new);

    public static StaticModifier<Modifier> tenacity = MODIFIERS.register("tenacity", TenacityModifier::new);

    public static StaticModifier<Modifier> half_powered_fists = MODIFIERS.register("half_powered_fists", HalfPoweredFistsModifier::new);
}
