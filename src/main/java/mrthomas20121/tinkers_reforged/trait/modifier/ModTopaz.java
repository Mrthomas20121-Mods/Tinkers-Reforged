package mrthomas20121.tinkers_reforged.trait.modifier;

import slimeknights.tconstruct.library.modifiers.ModifierAspect;

public class ModTopaz extends ModBonusDurability {

    public ModTopaz()
    {
        super("ref_topaz", 0xF59760, 400);

        addAspects(new ModifierAspect.SingleAspect(this), new ModifierAspect.DataAspect(this), ModifierAspect.freeModifier);
    }
}
