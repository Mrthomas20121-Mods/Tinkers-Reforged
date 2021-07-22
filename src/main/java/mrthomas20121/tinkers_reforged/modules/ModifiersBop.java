package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import mrthomas20121.tinkers_reforged.library.ModuleBase;
import mrthomas20121.tinkers_reforged.trait.modifier.*;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.List;

public class ModifiersBop extends ModuleBase {

    private final ModTanzanite tanzanite = new ModTanzanite();
    private final ModAmber amber = new ModAmber();
    private final ModTopaz topaz = new ModTopaz();
    private final ModMalachite malachite = new ModMalachite();
    private final ModTerrestrialArtifact terrestrialArtifact = new ModTerrestrialArtifact();

    public ModifiersBop() {
        super(new ResourceLocation(Reference.bop, "module"));
    }

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.biomeoplenty;
    }

    @Override
    public void preInit() {

    }

    @Override
    public void registerModifiers(List<Modifier> modifiers) {
        if(TinkersReforgedConfig.SettingMaterials.modifiers.tanzanite) {
            tanzanite.addItem("gemTanzanite");
            modifiers.add(tanzanite);
        }
        if(TinkersReforgedConfig.SettingMaterials.modifiers.amber) {
            amber.addItem("gemAmber");
            modifiers.add(amber);
        }
        if(TinkersReforgedConfig.SettingMaterials.modifiers.topaz) {
            topaz.addItem("gemTopaz");
            modifiers.add(topaz);
        }
        if(TinkersReforgedConfig.SettingMaterials.modifiers.malachite) {
            malachite.addItem("gemMalachite");
            modifiers.add(malachite);
        }
        if(TinkersReforgedConfig.SettingMaterials.modifiers.terrestrial_artifact) {
            terrestrialArtifact.addItem(ForgeUtils.getItem(Reference.bop, "terrestrial_artifact"), 1, 1);
            modifiers.add(terrestrialArtifact);
        }
    }
}
