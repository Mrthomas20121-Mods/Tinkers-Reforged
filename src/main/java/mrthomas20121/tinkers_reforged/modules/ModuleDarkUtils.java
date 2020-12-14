package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.trait.modifier.ModShulkerPearl;
import net.darkhax.darkutils.features.shulkerpearl.FeatureShulkerPearlItem;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModuleDarkUtils implements ModuleBase {

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {

    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {

        ModShulkerPearl shulkerPearl = new ModShulkerPearl();
        shulkerPearl.addItem(FeatureShulkerPearlItem.itemShulkerPearl);
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
