package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.modifier.*;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class TinkersReforgedModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersReforged.MOD_ID);

    public static StaticModifier<Modifier> felsteel_fel_debris = MODIFIERS.register("fel_debris", ModifierFelDebris::new);

    public static StaticModifier<Modifier> qivium_blazing_fire = MODIFIERS.register("blazing_fire", ModifierBlazingFire::new);

    public static StaticModifier<Modifier> lavium_aridzone = MODIFIERS.register("arid_zone", ModifierAridZone::new);

    public static StaticModifier<Modifier> electrical_copper_electro_web = MODIFIERS.register("electro_web", ModifierElectroWeb::new);

    public static StaticModifier<Modifier> duralumin_ultra_durable = MODIFIERS.register("ultra_durable", ModifierUltraDurable::new);

    public static StaticModifier<Modifier> gausum_titanic_damage = MODIFIERS.register("titanic_damage", ModifierTitanicDamage::new);

    public static StaticModifier<Modifier> chorus_metal_levitating_blob = MODIFIERS.register("levitating_blob", ModifierLevitatingBlob::new);

    public static StaticModifier<Modifier> kepu_damage_lock = MODIFIERS.register("damage_lock", ModifierDamageLock::new);
}
