package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.trait.*;
import mrthomas20121.tinkers_reforged.trait.electrical_copper.*;
import mrthomas20121.tinkers_reforged.trait.duralumin.*;
import mrthomas20121.tinkers_reforged.trait.lavium.*;
import mrthomas20121.tinkers_reforged.trait.qivium.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class TinkersReforgedModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersReforged.MOD_ID);

    // trait
    public static StaticModifier<Modifier> qivium_fireplace = MODIFIERS.register("fireplace", TraitFireplace::new);
    public static StaticModifier<Modifier> qivium_firestarter = MODIFIERS.register("firestarter", TraitFirestarter::new);
    public static StaticModifier<Modifier> qivium_sunfire_blessing = MODIFIERS.register("sunfire_blessing", TraitSunfireBlessing::new);

    public static StaticModifier<Modifier> lavium_ground_speed = MODIFIERS.register("ground_speed", TraitGroundSpeed::new);
    public static StaticModifier<Modifier> lavium_surface_curse = MODIFIERS.register("surface_curse", TraitSurfaceCurse::new);
    public static StaticModifier<Modifier> lavium_miner_blessing = MODIFIERS.register("miner_blessing", TraitMinerBlessing::new);

    public static StaticModifier<Modifier> electrical_copper_electrostatic = MODIFIERS.register("electrostatic", TraitElectrostatic::new);
    public static StaticModifier<Modifier> electrical_copper_odin_blessing = MODIFIERS.register("odin_blessing", TraitOdinBlessing::new);
    public static StaticModifier<Modifier> electrical_copper_electric_damage = MODIFIERS.register("electric_damage", TraitElectricDamage::new);

    public static StaticModifier<Modifier> duralumin_ultra_durable = MODIFIERS.register("ultra_durable", TraitUltraDurable::new);
    public static StaticModifier<Modifier> duralumin_overused = MODIFIERS.register("overused", TraitOverused::new);
    public static StaticModifier<Modifier> duralumin_heat_transfer = MODIFIERS.register("heat_transfer", TraitHeatTransfer::new);

    public static StaticModifier<Modifier> magical_shrink = MODIFIERS.register("magical_shrink", TraitMagicalShrink::new);
}
