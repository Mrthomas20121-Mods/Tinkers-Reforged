package mrthomas20121.tinkers_reforged.modifiers;

import slimeknights.tconstruct.library.modifiers.ModifierAspect;

public class ModTanzanite extends ModBonusDurability {
    public ModTanzanite()
    {
        super("ref_tanzanite", 0xF59760, 700);

        addAspects(new ModifierAspect.SingleAspect(this), new ModifierAspect.DataAspect(this), ModifierAspect.freeModifier);
    }
}
