package mrthomas20121.tinkers_reforged.modifiers;

import slimeknights.tconstruct.library.modifiers.ModifierAspect;

public class ModTerrestrialArtifact extends ModBonusDurability {

    public ModTerrestrialArtifact()
    {
        super("ref_terrestrial_artifact", 0xC8B278, 1000);

        addAspects(new ModifierAspect.SingleAspect(this), new ModifierAspect.DataAspect(this), ModifierAspect.freeModifier);
    }
}
