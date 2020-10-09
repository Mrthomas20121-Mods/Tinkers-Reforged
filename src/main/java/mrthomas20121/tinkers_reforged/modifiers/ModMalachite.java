package mrthomas20121.tinkers_reforged.modifiers;

import slimeknights.tconstruct.library.modifiers.ModifierAspect;

public class ModMalachite extends ModBonusDurability {

    public ModMalachite()
    {
        super("ref_malachite", 0x23AB79);

        addAspects(new ModifierAspect.SingleAspect(this), new ModifierAspect.DataAspect(this), ModifierAspect.freeModifier);
    }
}
