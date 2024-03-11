package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.modifier.*;
import mrthomas20121.tinkers_reforged.modifier.HeadshotModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

// Some modifier class name are not the same as the modifier name to keep compat with worlds running older version of tinkers reforged
public class TinkersReforgedModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersReforged.MOD_ID);

    // tools modifiers
    public static StaticModifier<LongRangeModifier> long_range = MODIFIERS.register("long_range", LongRangeModifier::new);
    public static StaticModifier<ResistorModifier> resistor = MODIFIERS.register("resistor", ResistorModifier::new);

    // traits
    public static StaticModifier<AdaptabilityModifier> adaptability = MODIFIERS.register("adaptability", AdaptabilityModifier::new);
    public static StaticModifier<BiomeEffectModifier> biome_effect = MODIFIERS.register("biome_effect", BiomeEffectModifier::new);
    public static StaticModifier<DebrisModifier> debris = MODIFIERS.register("debris", DebrisModifier::new);
    public static StaticModifier<ExcavationModifier> excavation = MODIFIERS.register("excavation", ExcavationModifier::new);
    public static StaticModifier<ExtinguishModifier> extinguish = MODIFIERS.register("extinguish", ExtinguishModifier::new);
    public static StaticModifier<FrozenBladeModifier> frozen_blade = MODIFIERS.register("frozen_blade", FrozenBladeModifier::new);
    public static StaticModifier<GiganticModifier> gigantic = MODIFIERS.register("gigantic", GiganticModifier::new);
    public static StaticModifier<HeadshotModifier> headshot = MODIFIERS.register("headshot", HeadshotModifier::new);
    public static StaticModifier<HellFireModifier> hellfire = MODIFIERS.register("hellfire", HellFireModifier::new);
    public static StaticModifier<HellishRepairModifier> hellish_repair = MODIFIERS.register("hellish_repair", HellishRepairModifier::new);
    public static StaticModifier<SlotMachineModifier> slot_machine = MODIFIERS.register("slot_machine", SlotMachineModifier::new);
    public static StaticModifier<OverheatedModifier> overheated = MODIFIERS.register("overheated", OverheatedModifier::new);
    public static StaticModifier<RockSolidModifier> rock_solid = MODIFIERS.register("rock_solid", RockSolidModifier::new);
    public static StaticModifier<SeasonedModifier> seasoned = MODIFIERS.register("seasoned", SeasonedModifier::new);
    public static StaticModifier<SlowForceModifier> slow_force = MODIFIERS.register("slow_force", SlowForceModifier::new);
    public static StaticModifier<SupernaturalModifier> supernatural = MODIFIERS.register("supernatural", SupernaturalModifier::new);
    public static StaticModifier<MushModifier> mush = MODIFIERS.register("mush", MushModifier::new);
    public static StaticModifier<DarkPoisonModifier> dark_poison = MODIFIERS.register("dark_poison", DarkPoisonModifier::new);
}
