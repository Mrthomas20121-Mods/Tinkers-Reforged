package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.tools.Tools;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Modules {

    public static final ModuleThermal thermal = new ModuleThermal();
    public static final ModuleNatureAura natureAura = new ModuleNatureAura();
    public static final ModuleAe ae = new ModuleAe();
    public static ModuleAA aa = null;
    public static final ModuleBase astral = new ModuleAstralSorcery();
    public static ModuleAtum atum = null;
    public static final ModuleBotania botania = new ModuleBotania();
    public static ModuleBlueSkies blueskies = null;
    public static final ModuleCavern cavernII = new ModuleCavern();
    public static final ModuleCommonMaterials common_materials_module = new ModuleCommonMaterials();
    public static final ModuleRoots roots = new ModuleRoots();
    public static final ModuleExtremeReactor extreme = new ModuleExtremeReactor();
    public static final ModuleMekanism mekanism = new ModuleMekanism();
    public static ModulePixelmon pixelmon_reforged = null;
    public static ModuleThaumcraft thaumcraft = null;
    public static final ModuleProjectRedCore project_red_core = new ModuleProjectRedCore();
    public static final ModuleItems moduleItems = new ModuleItems();
    // tool module
    public static final Tools tools = new Tools();

    public static void preInit(FMLPreInitializationEvent event) {
        moduleItems.preInit(event);
        common_materials_module.preInit(event);

        if(isLoaded("actuallyadditions")) {
            aa = new ModuleAA();
            aa.preInit(event);
        }
        if(isLoaded("appliedenergistics2")) {
            ae.preInit(event);
        }
        if(isLoaded("astralsorcery")) {
            astral.preInit(event);
        }
        if(isLoaded("atum")) {
            atum = new ModuleAtum();
            atum.preInit(event);
        }
        if(isLoaded("blue_skies")) {
            blueskies = new ModuleBlueSkies();
            blueskies.preInit(event);
        }
        if(isLoaded("botania"))
        {
            botania.preInit(event);
        }
        if(isLoaded("cavern"))
        {
            cavernII.preInit(event);
        }
        if(isLoaded("bigreactors")) {
            extreme.preInit(event);
        }
        if(isLoaded("mekanism")) {
            mekanism.preInit(event);
        }
        if(isLoaded("naturesaura")) {
            natureAura.preInit(event);
        }
        if(isLoaded("pixelmon")) {
            pixelmon_reforged = new ModulePixelmon();
            pixelmon_reforged.preInit(event);
        }
        if(isLoaded("projectred-core")) {
            project_red_core.preInit(event);
        }
        if(isLoaded("roots")) {
            roots.preInit(event);
        }
        if(isLoaded("thaumcraft")) {
            thaumcraft = new ModuleThaumcraft();
            thaumcraft.preInit(event);
        }
        if(isLoaded("thermalfoundation")) {
            thermal.preInit(event);
        }
    }

    public static void init(FMLInitializationEvent event) {
        moduleItems.init(event);
        common_materials_module.init(event);

        if(isLoaded("actuallyadditions")) {
            aa.init(event);
        }
        if(isLoaded("appliedenergistics2")) {
            ae.init(event);
        }
        if(isLoaded("astralsorcery")) {
            astral.init(event);
        }
        if(isLoaded("atum")) {
            atum.init(event);
        }
        if(isLoaded("blue_skies")) {
            blueskies.init(event);
        }
        if(isLoaded("botania"))
        {
            botania.init(event);
        }
        if(isLoaded("cavern"))
        {
            cavernII.init(event);
        }
        if(isLoaded("bigreactors")) {
            extreme.init(event);
        }
        if(isLoaded("mekanism")) {
            mekanism.init(event);
        }
        if(isLoaded("naturesaura")) {
            natureAura.init(event);
        }
        if(isLoaded("pixelmon")) {
            pixelmon_reforged.init(event);
        }
        if(isLoaded("projectred-core")) {
            project_red_core.init(event);
        }
        if(isLoaded("roots")) {
            roots.init(event);
        }
        if(isLoaded("thaumcraft")) {
            thaumcraft.init(event);
        }
        if(isLoaded("thermalfoundation")) {
            thermal.init(event);
        }
    }

    public static void postInit(FMLPostInitializationEvent event) {
        if(isLoaded("atum")) {
            atum.postInit(event);
        }
        moduleItems.postInit(event);
    }

    public static boolean isLoaded(String modid)
    {
        return Loader.isModLoaded(modid) && !TinkersReforgedConfig.SettingMaterials.containModules(modid);
    }
}
