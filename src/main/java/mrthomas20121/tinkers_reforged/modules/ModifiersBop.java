package mrthomas20121.tinkers_reforged.modules;

import biomesoplenty.api.item.BOPItems;
import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import mrthomas20121.tinkers_reforged.trait.modifier.*;

public class ModifiersBop extends ModuleReforgedBase {

    public static final ModTanzanite tanzanite = new ModTanzanite();
    public static final ModAmber amber = new ModAmber();
    public static final ModTopaz topaz = new ModTopaz();
    public static final ModMalachite malachite = new ModMalachite();
    public static final ModTerrestrialArtifact terrestrialArtifact = new ModTerrestrialArtifact();

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.biomeoplenty;
    }

    @Override
    public void preInit() {

    }

    @Override
    public void init() {

        if(TinkersReforgedConfig.SettingMaterials.modifiers.tanzanite) {
            tanzanite.addItem("gemTanzanite");
        }
        if(TinkersReforgedConfig.SettingMaterials.modifiers.amber) {
            amber.addItem("gemAmber");
        }
        if(TinkersReforgedConfig.SettingMaterials.modifiers.topaz) {
            topaz.addItem("gemTopaz");
        }
        if(TinkersReforgedConfig.SettingMaterials.modifiers.malachite) {
            malachite.addItem("gemMalachite");
        }
        if(TinkersReforgedConfig.SettingMaterials.modifiers.terrestrial_artifact) {
            terrestrialArtifact.addItem(ForgeUtils.getItem(Reference.bop, "terrestrial_artifact"), 1, 1);
        }
    }
}
