package mrthomas20121.tinkers_reforged.modules.biome_o_plenty;

import biomesoplenty.api.item.BOPItems;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.ModuleManager;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.modifier.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModifiersBop implements ModuleBase {

    public static final ModTanzanite tanzanite = new ModTanzanite();
    public static final ModAmber amber = new ModAmber();
    public static final ModTopaz topaz = new ModTopaz();
    public static final ModMalachite malachite = new ModMalachite();
    public static final ModTerrestrialArtifact terrestrialArtifact = new ModTerrestrialArtifact();

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {

    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {

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
            terrestrialArtifact.addItem(BOPItems.terrestrial_artifact, 1, 1);
        }




        ModuleManager.addModifier(tanzanite);
        ModuleManager.addModifier(amber);
        ModuleManager.addModifier(topaz);
        ModuleManager.addModifier(malachite);
        ModuleManager.addModifier(terrestrialArtifact);
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
