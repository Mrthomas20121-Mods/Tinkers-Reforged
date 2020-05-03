package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.Config.Config;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Modules {

    public static final ModuleThermal thermal = new ModuleThermal();
    public static final ModuleNatureAura natureAura = new ModuleNatureAura();
    public static final ModuleAe ae = new ModuleAe();
    public static final ModuleAstralSorcery astral = new ModuleAstralSorcery();
    public static final ModuleAtum atum = new ModuleAtum();
    public static final ModuleMysticalWorld mysticalWorld = new ModuleMysticalWorld();
    public static final ModuleRoots roots = new ModuleRoots();
    public static ModuleConArm conarm = null;
    public static final ModuleExtremeReactor extreme = new ModuleExtremeReactor();
    public static final ModuleItems moduleItems = new ModuleItems();
    // tool module
    public static final ModuleTools tools = new ModuleTools();

    public static void preInit(FMLPreInitializationEvent event) {

        moduleItems.preInit(event);

        if(Loader.isModLoaded("thermalfoundation") && Config.thermal) {
            thermal.preInit(event);
        }
        if(Loader.isModLoaded("naturesaura") && Config.naturesaura) {
            natureAura.preInit(event);
        }
        if(Loader.isModLoaded("appliedenergistics2") && Config.ae2) {
            ae.preInit(event);
        }
        if(Loader.isModLoaded("astralsorcery") && Config.astral) {
            astral.preInit(event);
        }
        if(Loader.isModLoaded("atum") && Config.atum) {
            atum.preInit(event);
        }
        if(Loader.isModLoaded("mysticalworld") && Config.mysticalworld) {
            mysticalWorld.preInit(event);
        }

        if(Loader.isModLoaded("roots") && Config.mysticalworld) {
            roots.preInit(event);
        }
        if(Loader.isModLoaded("bigreactors") && Config.extreme) {
            extreme.preInit(event);
        }

        
        if (Loader.isModLoaded("conarm")) {
            conarm = new ModuleConArm();
            conarm.preInit(event);
        }
    }

    public static void init(FMLInitializationEvent event) {
        moduleItems.init(event);

        if(Loader.isModLoaded("thermalfoundation") && Config.thermal) {
            thermal.init(event);
        }
        if(Loader.isModLoaded("naturesaura") && Config.naturesaura) {
            natureAura.init(event);
        }
        if(Loader.isModLoaded("appliedenergistics2") && Config.ae2) {
            ae.init(event);
        }
        if(Loader.isModLoaded("astralsorcery") && Config.astral) {
            astral.init(event);
        }
        if(Loader.isModLoaded("atum") && Config.atum) {
            atum.init(event);
        }
        if(Loader.isModLoaded("mysticalworld") && Config.mysticalworld) {
            mysticalWorld.init(event);
        }
        if(Loader.isModLoaded("bigreactors") && Config.extreme) {
            extreme.init(event);
        }

        if (Loader.isModLoaded("conarm")) {
            conarm.init(event);
        }
    }

    public static void postInit(FMLPostInitializationEvent event) {
        if(Loader.isModLoaded("atum") && Config.atum) {
            Modules.atum.postInit(event);
        }
    }
}
