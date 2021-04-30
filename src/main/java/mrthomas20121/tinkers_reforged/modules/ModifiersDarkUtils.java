package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import mrthomas20121.tinkers_reforged.library.module.ModuleManager;
import mrthomas20121.tinkers_reforged.library.module.ModuleReforgedBase;
import mrthomas20121.tinkers_reforged.trait.modifier.ModShulkerPearl;

public class ModifiersDarkUtils extends ModuleReforgedBase {

    public static ModShulkerPearl shulkerPearl = new ModShulkerPearl();

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.dark_utils;
    }

    @Override
    public void preInit() {

    }

    @Override
    public void init() {

        if(TinkersReforgedConfig.SettingMaterials.modifiers.shulker_pearl) {
            shulkerPearl.addItem(ForgeUtils.getItem(Reference.darkutils, "shulker_pearl"));
            ModuleManager.modifiers.add(shulkerPearl);
        }
    }
}
