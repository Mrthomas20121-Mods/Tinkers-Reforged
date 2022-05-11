package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.trait.*;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class TinkersReforgedModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersReforged.MOD_ID);

    public static StaticModifier<Modifier> qivium_firestarter = MODIFIERS.register("firestarter", ModifierFirestarter::new);

    public static StaticModifier<Modifier> lavium_aridzone = MODIFIERS.register("arid_zone", ModifierAridZone::new);

    public static StaticModifier<Modifier> electrical_copper_electro_web = MODIFIERS.register("electro_web", ModifierElectroWeb::new);

    public static StaticModifier<Modifier> duralumin_ultra_durable = MODIFIERS.register("ultra_durable", ModifierUltraDurable::new);

    public static StaticModifier<Modifier> gausum_titanic_damage = MODIFIERS.register("titanic_damage", ModifierTitanicDamage::new);
}
