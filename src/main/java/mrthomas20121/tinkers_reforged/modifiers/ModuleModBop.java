package mrthomas20121.tinkers_reforged.modifiers;

import biomesoplenty.api.item.BOPItems;
import mrthomas20121.biolib.common.ModifierModuleBase;

public class ModuleModBop implements ModifierModuleBase {

    private ModTanzanite tanzanite = new ModTanzanite();
    private ModAmber amber = new ModAmber();
    private ModTopaz topaz = new ModTopaz();
    private ModMalachite malachite = new ModMalachite();
    private ModTerrestrialArtifact terrestrialArtifact = new ModTerrestrialArtifact();

    @Override
    public void init() {
        this.tanzanite.addItem("gemTanzanite");
        this.amber.addItem("gemAmber");
        this.topaz.addItem("gemTopaz");
        this.malachite.addItem("gemMalachite");
        this.terrestrialArtifact.addItem(BOPItems.terrestrial_artifact, 1, 1);
    }

    public ModTanzanite getTanzanite() {
        return this.tanzanite;
    }

    public ModAmber getAmber() {
        return this.amber;
    }

    public ModMalachite getMalachite() {
        return this.malachite;
    }

    public ModTopaz getTopaz() {
        return this.topaz;
    }

    public ModTerrestrialArtifact getTerrestrialArtifact() {
        return this.terrestrialArtifact;
    }
}
