package mrthomas20121.tinkers_reforged.api;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class TinkersReforgedModifierIds {

    // slimebronze
    public static ModifierId OVERFRACTURE = create("overfracture");

    // thallium
    public static ModifierId IONIZE = create("ionize");

    public static ModifierId ATTACK_FRENZY = create("attack_frenzy");
    public static ModifierId MINING_FRENZY = create("mining_frenzy");

    private static ModifierId create(String name) {
        return new ModifierId(TinkersReforged.MOD_ID, name);
    }
}
