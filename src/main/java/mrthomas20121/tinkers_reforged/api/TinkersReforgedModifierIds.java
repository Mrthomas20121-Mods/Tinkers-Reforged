package mrthomas20121.tinkers_reforged.api;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class TinkersReforgedModifierIds {

    // tool materials
    // slimebronze
    public static ModifierId OVERFRACTURE = create("overfracture");

    // thallium
    public static ModifierId IONIZE = create("ionize");

    public static ModifierId ATTACK_FRENZY = create("attack_frenzy");
    public static ModifierId MINING_FRENZY = create("mining_frenzy");

    public static ModifierId ENDER_THROW = create("ender_throw");
    public static ModifierId TRIAD = create("triad");
    public static ModifierId TINY_BUT_POWERFUL = create("tiny_but_powerful");
    public static ModifierId FIERY_FAVOR = create("fiery_favor");
    public static ModifierId FORTUNATE_HEIGHT = create("fortunate_height");

    // armor
    public static ModifierId LANDING_PAD = create("landing_pad");
    public static ModifierId SAFEGUARD = create("safeguard");

    private static ModifierId create(String name) {
        return new ModifierId(TinkersReforged.MOD_ID, name);
    }
}
