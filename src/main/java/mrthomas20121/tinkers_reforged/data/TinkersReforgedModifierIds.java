package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import slimeknights.tconstruct.library.modifiers.ModifierId;

public class TinkersReforgedModifierIds {

    // tool materials
    public static ModifierId OVERFRACTURE = create("overfracture");
    public static ModifierId IONIZE = create("ionize");
    public static ModifierId GROWTH = create("growth");

    public static ModifierId TRIAD = create("triad");
    public static ModifierId CLOSE_COMBAT = create("close_combat");
    public static ModifierId FLAMING = create("flaming");
    public static ModifierId SURFACE_RESOURCES = create("surface_resources");
    public static ModifierId SUBAQUATIC = create("subaquatic");
    public static ModifierId FRAIL = create("frail");
    public static ModifierId GEOGRAPHICAL = create("geographical");

    // armor
    public static ModifierId DECAY_IMMUNITY = create("decay_immunity");
    public static ModifierId SAFEGUARD = create("safeguard");
    public static ModifierId AGILITY = create("agility");
    public static ModifierId LAND_PROTECTION = create("land_protection");
    public static ModifierId HEALTH_UP = create("health_up");
    public static ModifierId FRICTION = create("friction");
    public static ModifierId LUNGFUL = create("lungful");
    public static ModifierId ROAST = create("roast");
    public static ModifierId SPACIAL = create("spacial");

    private static ModifierId create(String name) {
        return new ModifierId(TinkersReforged.MOD_ID, name);
    }
}
