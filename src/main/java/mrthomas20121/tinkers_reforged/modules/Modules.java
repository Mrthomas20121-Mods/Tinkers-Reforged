package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.tinkers_reforged.config.ConfigModule;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Modules {

    public static final ModuleThermal thermal = new ModuleThermal();
    public static final ModuleNatureAura natureAura = new ModuleNatureAura();
    public static final ModuleAe ae = new ModuleAe();
    public static ModuleAA aa = null;
    public static final ModuleAstralSorcery astral = new ModuleAstralSorcery();
    public static ModuleAtum atum = null;
    public static final ModuleBotania botania = new ModuleBotania();
    public static ModuleBlueSkies blueskies = null;
    public static final ModuleCavern cavernII = new ModuleCavern();
    public static final ModuleCommonMaterials common_materials_module = new ModuleCommonMaterials();
    public static final ModuleRoots roots = new ModuleRoots();
    public static final ModuleExtremeReactor extreme = new ModuleExtremeReactor();
    public static final ModuleMekanism mekanism = new ModuleMekanism();
    public static ModulePixelmon pixelmon_reforged = null;
    public static final ModuleProjectRedCore project_red_core = new ModuleProjectRedCore();
    public static final ModuleItems moduleItems = new ModuleItems();
    // tool module
    public static final ModuleTools tools = new ModuleTools();

    public static void preInit(FMLPreInitializationEvent event) {
        moduleItems.preInit(event);
        common_materials_module.preInit(event);

        if(Loader.isModLoaded("actuallyadditions") && ConfigModule.actuallyadditions) {
            aa = new ModuleAA();
            aa.preInit(event);
        }
        if(Loader.isModLoaded("appliedenergistics2") && ConfigModule.appliedenergistics) {
            ae.preInit(event);
        }
        if(Loader.isModLoaded("astralsorcery") && ConfigModule.astralsorcery) {
            astral.preInit(event);
        }
        if(Loader.isModLoaded("atum") && ConfigModule.atum) {
            atum = new ModuleAtum();
            atum.preInit(event);
        }
        if(Loader.isModLoaded("bigreactors") && ConfigModule.bigreactors) {
            extreme.preInit(event);
        }
        if(Loader.isModLoaded("blue_skies") && ConfigModule.blueskies) {
            blueskies = new ModuleBlueSkies();
            blueskies.preInit(event);
        }
        if(Loader.isModLoaded("botania") && ConfigModule.botania)
        {
            botania.preInit(event);
        }
        if(Loader.isModLoaded("cavern") && ConfigModule.cavernII)
        {
            cavernII.preInit(event);
        }
        if(Loader.isModLoaded("mekanism") && ConfigModule.mekanism) {
            mekanism.preInit(event);
        }
        if(Loader.isModLoaded("naturesaura") && ConfigModule.naturesaura) {
            natureAura.preInit(event);
        }
        if(Loader.isModLoaded("pixelmon") && ConfigModule.pixelmon_reforged) {
            pixelmon_reforged = new ModulePixelmon();
            pixelmon_reforged.preInit(event);
        }
        if(Loader.isModLoaded("projectred-core") && ConfigModule.projectred_core) {
            project_red_core.preInit(event);
        }
        if(Loader.isModLoaded("roots") && ConfigModule.roots) {
            roots.preInit(event);
        }
        if(Loader.isModLoaded("thermalfoundation") && ConfigModule.thermalfoundation) {
            thermal.preInit(event);
        }
    }

    public static void init(FMLInitializationEvent event) {
        moduleItems.init(event);
        common_materials_module.init(event);

        if(Loader.isModLoaded("actuallyadditions") && ConfigModule.actuallyadditions) {
            aa.init(event);
        }
        if(Loader.isModLoaded("appliedenergistics2") && ConfigModule.appliedenergistics) {
            ae.init(event);
        }
        if(Loader.isModLoaded("astralsorcery") && ConfigModule.astralsorcery) {
            astral.init(event);
        }
        if(Loader.isModLoaded("atum") && ConfigModule.atum) {
            atum.init(event);
        }
        if(Loader.isModLoaded("bigreactors") && ConfigModule.bigreactors) {
            extreme.init(event);
        }
        if(Loader.isModLoaded("blue_skies") && ConfigModule.blueskies) {
            blueskies.init(event);
        }
        if(Loader.isModLoaded("botania") && ConfigModule.botania) {
            botania.init(event);
        }
        if(Loader.isModLoaded("naturesaura") && ConfigModule.thermalfoundation) {
            natureAura.init(event);
        }
        if(Loader.isModLoaded("pixelmon") && ConfigModule.pixelmon_reforged) {
            pixelmon_reforged.init(event);
        }
        if(Loader.isModLoaded("roots") && ConfigModule.roots) {
            roots.init(event);
        }
        if(Loader.isModLoaded("thermalfoundation") && ConfigModule.thermalfoundation) {
            thermal.init(event);
        }
    }

    public static void postInit(FMLPostInitializationEvent event) {
        if(Loader.isModLoaded("atum") && ConfigModule.atum) {
            atum.postInit(event);
        }
        moduleItems.postInit(event);
    }
}
