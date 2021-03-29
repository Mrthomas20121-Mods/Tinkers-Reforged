package mrthomas20121.tinkers_reforged.modules.environmental_tech;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.ModuleManager;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.trait.modifier.ModDigging;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModifiersEnvTech implements ModuleBase {

    public static final ModDigging digging = new ModDigging();

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {

    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {

        if(TinkersReforgedConfig.SettingMaterials.modifiers.digging) {
            digging.addItem("blockLitherite");
            digging.addItem("blockErodium");
            digging.addItem("blockKyronite");
            digging.addItem("blockPladium");
            digging.addItem("blockIonite");
        }

        ModuleManager.addModifier(digging);
    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
