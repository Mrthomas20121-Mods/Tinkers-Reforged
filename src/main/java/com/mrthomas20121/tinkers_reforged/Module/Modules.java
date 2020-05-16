package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.Config.ConfigModules;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Modules {

    public static final ModuleThermal thermal = new ModuleThermal();
    public static final ModuleNatureAura natureAura = new ModuleNatureAura();;
    public static final ModuleAe ae = new ModuleAe();
    public static final ModuleAA aa = new ModuleAA();
    public static final ModuleAstralSorcery astral = new ModuleAstralSorcery();
    public static final ModuleAtum atum = new ModuleAtum();
    public static final ModuleMysticalWorld mysticalWorld = new ModuleMysticalWorld();
    public static final ModuleRoots roots = new ModuleRoots();
    public static final ModuleExtremeReactor extreme = new ModuleExtremeReactor();
    public static final ModuleMekanism mekanism = new ModuleMekanism();
    public static final ModuleBlueSkies blueskies = new ModuleBlueSkies();
    public static final ModuleItems moduleItems = new ModuleItems();
    public static ModuleConArm conarm = null;
    // tool module
    public static final ModuleTools tools = new ModuleTools();

    public static void preInit(FMLPreInitializationEvent event) {

        moduleItems.preInit(event);

        if(Loader.isModLoaded("thermalfoundation") && ConfigModules.thermal) {
            thermal.preInit(event);
        }
        if(Loader.isModLoaded("naturesaura") && ConfigModules.naturesaura) {
            natureAura.preInit(event);
        }
        if(Loader.isModLoaded("appliedenergistics2") && ConfigModules.ae2) {
            ae.preInit(event);
        }
        if(Loader.isModLoaded("astralsorcery") && ConfigModules.astral) {
            astral.preInit(event);
        }
        if(Loader.isModLoaded("atum") && ConfigModules.atum) {
            atum.preInit(event);
        }
        if(Loader.isModLoaded("mysticalworld") && ConfigModules.mysticalworld) {
            mysticalWorld.preInit(event);
        }
        if(Loader.isModLoaded("roots") && ConfigModules.mysticalworld) {
            roots.preInit(event);
        }
        if(Loader.isModLoaded("bigreactors") && ConfigModules.extreme) {
            extreme.preInit(event);
        }
        if(Loader.isModLoaded("mekanism") && ConfigModules.mekanism) {
            mekanism.preInit(event);
        }
        if(Loader.isModLoaded("blue_skies") && ConfigModules.blue_skies) {
            blueskies.preInit(event);
        }

        if(Loader.isModLoaded("conarm")) {
            conarm = new ModuleConArm();
            conarm.preInit(event);
        }
    }

    public static void init(FMLInitializationEvent event) {
        moduleItems.init(event);
        Traits.preInit();

        if(Loader.isModLoaded("thermalfoundation") && ConfigModules.thermal) {
            thermal.init(event);
        }
        if(Loader.isModLoaded("naturesaura") && ConfigModules.naturesaura) {
            natureAura.init(event);
        }
        if(Loader.isModLoaded("appliedenergistics2") && ConfigModules.ae2) {
            ae.init(event);
        }
        if(Loader.isModLoaded("astralsorcery") && ConfigModules.astral) {
            astral.init(event);
        }
        if(Loader.isModLoaded("atum") && ConfigModules.atum) {
            atum.init(event);
        }
        if(Loader.isModLoaded("mysticalworld") && ConfigModules.mysticalworld) {
            mysticalWorld.init(event);
        }
        if(Loader.isModLoaded("bigreactors") && ConfigModules.extreme) {
            extreme.init(event);
        }
        if(Loader.isModLoaded("blue_skies")) {
            blueskies.init(event);
        }
    }

    public static void postInit(FMLPostInitializationEvent event) {
        if(Loader.isModLoaded("atum") && ConfigModules.atum) {
            atum.postInit(event);
        }
        moduleItems.postInit(event);
    }
}
