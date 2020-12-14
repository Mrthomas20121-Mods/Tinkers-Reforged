package mrthomas20121.tinkers_reforged.trait.modifier;

import slimeknights.tconstruct.library.modifiers.ModifierAspect;

public class ModAmber extends ModBonusDurability {

    public ModAmber()
    {
        super("ref_amber", 0xFFB226, 550);

        addAspects(new ModifierAspect.SingleAspect(this), new ModifierAspect.DataAspect(this), ModifierAspect.freeModifier);
    }
}
