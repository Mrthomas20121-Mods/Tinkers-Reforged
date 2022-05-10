package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.trait.*;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class TinkersReforgedModifiers {

    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersReforged.MOD_ID);

    public static StaticModifier<Modifier> qivium_firestarter = MODIFIERS.register("firestarter", TraitFirestarter::new);

    public static StaticModifier<Modifier> lavium_aridzone = MODIFIERS.register("arid_zone", ModifierAridZone::new);

    public static StaticModifier<Modifier> electrical_copper_electrostatic = MODIFIERS.register("electrostatic", ModifierElectrostatic::new);

    public static StaticModifier<Modifier> duralumin_ultra_durable = MODIFIERS.register("ultra_durable", ModifierUltraDurable::new);

    public static StaticModifier<Modifier> magical_shrink = MODIFIERS.register("magical_shrink", TraitMagicalShrink::new);
}
