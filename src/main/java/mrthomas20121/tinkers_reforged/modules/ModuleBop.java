package mrthomas20121.tinkers_reforged.modules;

import biomesoplenty.api.item.BOPItems;
import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.ModuleManager;
import mrthomas20121.tinkers_reforged.trait.modifier.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModuleBop implements ModuleBase {

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {

    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {

        ModTanzanite tanzanite = new ModTanzanite();
        ModAmber amber = new ModAmber();
        ModTopaz topaz = new ModTopaz();
        ModMalachite malachite = new ModMalachite();
        ModTerrestrialArtifact terrestrialArtifact = new ModTerrestrialArtifact();

        tanzanite.addItem("gemTanzanite");
        amber.addItem("gemAmber");
        topaz.addItem("gemTopaz");
        malachite.addItem("gemMalachite");
        terrestrialArtifact.addItem(BOPItems.terrestrial_artifact, 1, 1);

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
