package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import mrthomas20121.tinkers_reforged.library.ModuleBase;
import mrthomas20121.tinkers_reforged.trait.modifier.ModShulkerPearl;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.List;

public class ModifiersDarkUtils extends ModuleBase {

    private final ModShulkerPearl shulkerPearl = new ModShulkerPearl();

    public ModifiersDarkUtils() {
        super(new ResourceLocation(Reference.darkutils, "module"));
    }

    @Override
    public boolean canLoad() {
        return TinkersReforgedConfig.SettingMaterials.modules.dark_utils;
    }

    @Override
    public void preInit() {

    }

    @Override
    public void registerModifiers(List<Modifier> modifiers) {
        if(TinkersReforgedConfig.SettingMaterials.modifiers.shulker_pearl) {
            shulkerPearl.addItem(ForgeUtils.getItem(Reference.darkutils, "shulker_pearl"));
            modifiers.add(shulkerPearl);
        }
    }
}
