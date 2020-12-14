package mrthomas20121.tinkers_reforged;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.modules.*;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModuleManager implements ModuleBase {

    ModuleAA moduleAA;
    ModuleAe2 moduleAe2;
    ModuleAS moduleAS;
    ModuleAtum moduleAtum;
    ModuleBlueSkies moduleBlueSkies;
    ModuleBop moduleBop;
    ModuleBotania moduleBotania;
    ModuleCavern2 moduleCavern2;
    ModuleDarkUtils moduleDarkUtils;
    ModuleEnvTech moduleEnvTech;
    ModuleExtremeReactor moduleExtremeReactor;
    ModuleMekanism moduleMekanism;
    ModuleNaturesAura moduleNaturesAura;
    ModulePixelmon modulePixelmon;
    ModuleProjectRed moduleProjectRed;
    ModuleRoots moduleRoots;
    ModuleRS moduleRS;
    ModuleThaumcraft moduleThaumcraft;
    ModuleThermal moduleThermal;
    ModuleTinkersReforged moduleTinkersReforged;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        if(isModLoaded("actuallyadditions")) {
            moduleAA = new ModuleAA();
            moduleAA.preInit(event);
        }
        if(isModLoaded("appliedenergistics2")) {
            moduleAe2 = new ModuleAe2();
            moduleAe2.preInit(event);
        }
        if(isModLoaded("astralsorcery")) {
            moduleAS = new ModuleAS();
            moduleAS.preInit(event);
        }
        if(isModLoaded("atum")) {
            moduleAtum = new ModuleAtum();
            moduleAtum.preInit(event);
        }
        if(isModLoaded("blue_skies")) {
            moduleBlueSkies = new ModuleBlueSkies();
            moduleBlueSkies.preInit(event);
        }
        if(isModLoaded("biomesoplenty")) {
            moduleBop = new ModuleBop();
            moduleBop.preInit(event);
        }
        if(isModLoaded("botania")) {
            moduleBotania = new ModuleBotania();
            moduleBotania.preInit(event);
        }
        if(isModLoaded("cavern")) {
            moduleCavern2 = new ModuleCavern2();
            moduleCavern2.preInit(event);
        }
        if(isModLoaded("darkutils")) {
            moduleDarkUtils = new ModuleDarkUtils();
            moduleDarkUtils.preInit(event);
        }
        if(isModLoaded("environmentaltech")) {
            moduleEnvTech = new ModuleEnvTech();
            moduleEnvTech.preInit(event);
        }
        if(isModLoaded("bigreactors")) {
            moduleExtremeReactor = new ModuleExtremeReactor();
            moduleExtremeReactor.preInit(event);
        }
        if(isModLoaded("mekanism")) {
            moduleMekanism = new ModuleMekanism();
            moduleMekanism.preInit(event);
        }
        if(isModLoaded("naturesaura")) {
            moduleNaturesAura = new ModuleNaturesAura();
            moduleNaturesAura.preInit(event);
        }
        if(isModLoaded("projectred-core")) {
            moduleProjectRed = new ModuleProjectRed();
            moduleProjectRed.preInit(event);
        }
        if(isModLoaded("pixelmon")) {
            modulePixelmon = new ModulePixelmon();
            modulePixelmon.preInit(event);
        }
        if(isModLoaded("roots")) {
            moduleRoots = new ModuleRoots();
            moduleRoots.preInit(event);
        }
        if(isModLoaded("refinedstorage")) {
            moduleRS = new ModuleRS();
            moduleRS.preInit(event);
        }
        if(isModLoaded("thaumcraft")) {
            moduleThaumcraft = new ModuleThaumcraft();
            moduleThaumcraft.preInit(event);
        }
        if(isModLoaded("thermalexpansion")) {
            moduleThermal = new ModuleThermal();
            moduleThermal.preInit(event);
        }
        if(isModLoaded("tinkersreforged")) {
            moduleTinkersReforged = new ModuleTinkersReforged();
            moduleTinkersReforged.preInit(event);
        }
    }

    @Override
    public void init(FMLInitializationEvent event) {
        if(isModLoaded("actuallyadditions")) {
            moduleAA.init(event);
        }
        if(isModLoaded("appliedenergistics2")) {
            moduleAe2.init(event);
        }
        if(isModLoaded("astralsorcery")) {
            moduleAS.init(event);
        }
        if(isModLoaded("atum")) {
            moduleAtum.init(event);
        }
        if(isModLoaded("blue_skies")) {
            moduleBlueSkies.init(event);
        }
        if(isModLoaded("biomesoplenty")) {
            moduleBop.init(event);
        }
        if(isModLoaded("botania")) {
            moduleBotania.init(event);
        }
        if(isModLoaded("cavern")) {
            moduleCavern2.init(event);
        }
        if(isModLoaded("darkutils")) {
            moduleDarkUtils.init(event);
        }
        if(isModLoaded("environmentaltech")) {
            moduleEnvTech.init(event);
        }
        if(isModLoaded("bigreactors")) {
            moduleExtremeReactor.init(event);
        }
        if(isModLoaded("mekanism")) {
            moduleMekanism.init(event);
        }
        if(isModLoaded("naturesaura")) {
            moduleNaturesAura.init(event);
        }
        if(isModLoaded("projectred-core")) {
            moduleProjectRed.init(event);
        }
        if(isModLoaded("pixelmon")) {
            modulePixelmon.init(event);
        }
        if(isModLoaded("roots")) {
            moduleRoots.init(event);
        }
        if(isModLoaded("refinedstorage")) {
            moduleRS = new ModuleRS();
            moduleRS.init(event);
        }
        if(isModLoaded("thaumcraft")) {
            moduleThaumcraft.init(event);
        }
        if(isModLoaded("thermalexpansion")) {
            moduleThermal.init(event);
        }
        if(isModLoaded("tinkersreforged")) {
            moduleTinkersReforged.init(event);
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        if(isModLoaded("actuallyadditions")) {
            moduleAA.postInit(event);
        }
        if(isModLoaded("appliedenergistics2")) {
            moduleAe2.postInit(event);
        }
        if(isModLoaded("astralsorcery")) {
            moduleAS.postInit(event);
        }
        if(isModLoaded("atum")) {
            moduleAtum.postInit(event);
        }
        if(isModLoaded("blue_skies")) {
            moduleBlueSkies.postInit(event);
        }
        if(isModLoaded("biomesoplenty")) {
            moduleBop.postInit(event);
        }
        if(isModLoaded("botania")) {
            moduleBotania.postInit(event);
        }
        if(isModLoaded("cavern")) {
            moduleCavern2.postInit(event);
        }
        if(isModLoaded("darkutils")) {
            moduleDarkUtils.postInit(event);
        }
        if(isModLoaded("environmentaltech")) {
            moduleEnvTech.postInit(event);
        }
        if(isModLoaded("bigreactors")) {
            moduleExtremeReactor.postInit(event);
        }
        if(isModLoaded("mekanism")) {
            moduleMekanism.postInit(event);
        }
        if(isModLoaded("naturesaura")) {
            moduleNaturesAura.postInit(event);
        }
        if(isModLoaded("projectred-core")) {
            moduleProjectRed.postInit(event);
        }
        if(isModLoaded("pixelmon")) {
            modulePixelmon.postInit(event);
        }
        if(isModLoaded("roots")) {
            moduleRoots.postInit(event);
        }
        if(isModLoaded("refinedstorage")) {
            moduleRS = new ModuleRS();
            moduleRS.postInit(event);
        }
        if(isModLoaded("thaumcraft")) {
            moduleThaumcraft.postInit(event);
        }
        if(isModLoaded("thermalexpansion")) {
            moduleThermal.postInit(event);
        }
        if(isModLoaded("tinkersreforged")) {
            moduleTinkersReforged.postInit(event);
        }
    }

    public boolean isModLoaded(String moduleName) {
        return TinkersReforgedConfig.SettingMaterials.containModules(moduleName) && Loader.isModLoaded(moduleName);
    }
}
