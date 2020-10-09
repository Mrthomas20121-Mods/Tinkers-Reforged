package mrthomas20121.tinkers_reforged.modifiers;

import mrthomas20121.biolib.common.ModifierModuleBase;
import net.darkhax.darkutils.features.shulkerpearl.FeatureShulkerPearlItem;

public class ModuleModDarkUtils implements ModifierModuleBase {

    private ModShulkerPearl shulkerPearl = new ModShulkerPearl();

    @Override
    public void init() {
        shulkerPearl.addItem(FeatureShulkerPearlItem.itemShulkerPearl);
    }
}
