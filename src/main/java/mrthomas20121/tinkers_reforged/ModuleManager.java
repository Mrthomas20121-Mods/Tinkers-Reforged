package mrthomas20121.tinkers_reforged;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.biolib.util.ConarmUtil;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.modules.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.utils.HarvestLevels;

import java.util.ArrayList;

public class ModuleManager implements ModuleBase {

    private static ModuleManager instance = new ModuleManager();
    public static ModuleManager get() {
        return instance;
    }

    private static ArrayList<Modifier> modifiers = new ArrayList<>();

    public static void addModifier(Modifier modifier) {
        modifiers.add(modifier);
    }

    public ModuleAA moduleAA;
    public ModuleAe2 moduleAe2;
    public ModuleAS moduleAS;
    public ModuleAtum moduleAtum;
    public ModuleBlueSkies moduleBlueSkies;
    public ModuleBop moduleBop;
    public ModuleBotania moduleBotania;
    public ModuleCavern2 moduleCavern2;
    public ModuleDarkUtils moduleDarkUtils;
    public ModuleEnvTech moduleEnvTech;
    public ModuleExtremeReactor moduleExtremeReactor;
    public ModuleHeatAndClimate moduleHeatAndClimate;
    public ModuleMekanism moduleMekanism;
    public ModuleNaturesAura moduleNaturesAura;
    public ModulePixelmon modulePixelmon;
    public ModuleProjectRed moduleProjectRed;
    public ModuleRoots moduleRoots;
    public ModuleRS moduleRS;
    public ModuleThaumcraft moduleThaumcraft;
    public ModuleThermal moduleThermal;
    public ModuleTinkersReforged moduleTinkersReforged;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        if(isModLoaded("actuallyadditions") && TinkersReforgedConfig.SettingMaterials.modules.actuallyadditions) {
            moduleAA = new ModuleAA();
            moduleAA.preInit(event);
        }
        if(isModLoaded("appliedenergistics2") && TinkersReforgedConfig.SettingMaterials.modules.appliedenergistics2) {
            moduleAe2 = new ModuleAe2();
            moduleAe2.preInit(event);
        }
        if(isModLoaded("astralsorcery") && TinkersReforgedConfig.SettingMaterials.modules.astralsorcery) {
            moduleAS = new ModuleAS();
            moduleAS.preInit(event);
        }
        if(isModLoaded("atum")&& TinkersReforgedConfig.SettingMaterials.modules.atum) {
            moduleAtum = new ModuleAtum();
            moduleAtum.preInit(event);
        }
        if(isModLoaded("blue_skies") && TinkersReforgedConfig.SettingMaterials.modules.blue_skies) {
            moduleBlueSkies = new ModuleBlueSkies();
            moduleBlueSkies.preInit(event);
        }
        if(isModLoaded("biomesoplenty") && TinkersReforgedConfig.SettingMaterials.modules.biomeoplenty) {
            moduleBop = new ModuleBop();
            moduleBop.preInit(event);
        }
        if(isModLoaded("botania") && TinkersReforgedConfig.SettingMaterials.modules.botania) {
            moduleBotania = new ModuleBotania();
            moduleBotania.preInit(event);
        }
        if(isModLoaded("cavern") && TinkersReforgedConfig.SettingMaterials.modules.cavern2) {
            moduleCavern2 = new ModuleCavern2();
            moduleCavern2.preInit(event);
        }
        if(isModLoaded("darkutils") && TinkersReforgedConfig.SettingMaterials.modules.dark_utils) {
            moduleDarkUtils = new ModuleDarkUtils();
            moduleDarkUtils.preInit(event);
        }
        if(isModLoaded("environmentaltech") && TinkersReforgedConfig.SettingMaterials.modules.environmentaltech) {
            moduleEnvTech = new ModuleEnvTech();
            moduleEnvTech.preInit(event);
        }
        if(isModLoaded("bigreactors") && TinkersReforgedConfig.SettingMaterials.modules.extreme_reactor) {
            moduleExtremeReactor = new ModuleExtremeReactor();
            moduleExtremeReactor.preInit(event);
        }
        if(isModLoaded("dcs_climate") && TinkersReforgedConfig.SettingMaterials.modules.heat_and_climate)  {
            moduleHeatAndClimate = new ModuleHeatAndClimate();
            moduleHeatAndClimate.preInit(event);
        }
        if(isModLoaded("mekanism") && TinkersReforgedConfig.SettingMaterials.modules.mekanism) {
            moduleMekanism = new ModuleMekanism();
            moduleMekanism.preInit(event);
        }
        if(isModLoaded("naturesaura") && TinkersReforgedConfig.SettingMaterials.modules.naturesaura) {
            moduleNaturesAura = new ModuleNaturesAura();
            moduleNaturesAura.preInit(event);
        }
        if(isModLoaded("projectred-core") && TinkersReforgedConfig.SettingMaterials.modules.project_red) {
            moduleProjectRed = new ModuleProjectRed();
            moduleProjectRed.preInit(event);
        }
        if(isModLoaded("pixelmon") && TinkersReforgedConfig.SettingMaterials.modules.pixelmon) {
            modulePixelmon = new ModulePixelmon();
            modulePixelmon.preInit(event);
        }
        if(isModLoaded("roots") && TinkersReforgedConfig.SettingMaterials.modules.roots) {
            moduleRoots = new ModuleRoots();
            moduleRoots.preInit(event);
        }
        if(isModLoaded("refinedstorage") && TinkersReforgedConfig.SettingMaterials.modules.refined_storage) {
            moduleRS = new ModuleRS();
            moduleRS.preInit(event);
        }
        if(isModLoaded("thaumcraft") && TinkersReforgedConfig.SettingMaterials.modules.thaumcraft) {
            moduleThaumcraft = new ModuleThaumcraft();
            moduleThaumcraft.preInit(event);
        }
        if(isModLoaded("thermalexpansion") && TinkersReforgedConfig.SettingMaterials.modules.thermal) {
            moduleThermal = new ModuleThermal();
            moduleThermal.preInit(event);
        }
        if(isModLoaded("tinkers_reforged") && TinkersReforgedConfig.SettingMaterials.modules.tinkers_reforged) {
            moduleTinkersReforged = new ModuleTinkersReforged();
            moduleTinkersReforged.preInit(event);
        }
        if(isModLoaded("conarm")) {
            for(Material material: TinkerRegistry.getAllMaterials()) {
                if(material.getIdentifier().contains("ref_")) {
                    ModContainer modContainer = TinkerRegistry.getTrace(material);
                    if(isModLoaded(modContainer.getModId())) {
                        HeadMaterialStats head = material.getStats("head");
                        if(head != null) ConarmUtil.addArmorMat(material, head.harvestLevel> HarvestLevels.COBALT ? 2: (head.harvestLevel>HarvestLevels.DIAMOND ? 1 : 0));
                    }
                }
            }
        }
    }

    @Override
    public void init(FMLInitializationEvent event) {
        if(isModLoaded("actuallyadditions") && TinkersReforgedConfig.SettingMaterials.modules.actuallyadditions) {
            moduleAA.init(event);
        }
        if(isModLoaded("appliedenergistics2") && TinkersReforgedConfig.SettingMaterials.modules.appliedenergistics2) {
            moduleAe2.init(event);
        }
        if(isModLoaded("astralsorcery") && TinkersReforgedConfig.SettingMaterials.modules.astralsorcery) {
            moduleAS.init(event);
        }
        if(isModLoaded("atum") && TinkersReforgedConfig.SettingMaterials.modules.atum) {
            moduleAtum.init(event);
        }
        if(isModLoaded("blue_skies") && TinkersReforgedConfig.SettingMaterials.modules.blue_skies) {
            moduleBlueSkies.init(event);
        }
        if(isModLoaded("biomesoplenty") && TinkersReforgedConfig.SettingMaterials.modules.biomeoplenty) {
            moduleBop.init(event);
        }
        if(isModLoaded("botania") && TinkersReforgedConfig.SettingMaterials.modules.botania) {
            moduleBotania.init(event);
        }
        if(isModLoaded("cavern") && TinkersReforgedConfig.SettingMaterials.modules.cavern2) {
            moduleCavern2.init(event);
        }
        if(isModLoaded("darkutils") && TinkersReforgedConfig.SettingMaterials.modules.dark_utils) {
            moduleDarkUtils.init(event);
        }
        if(isModLoaded("environmentaltech") && TinkersReforgedConfig.SettingMaterials.modules.environmentaltech) {
            moduleEnvTech.init(event);
        }
        if(isModLoaded("bigreactors") && TinkersReforgedConfig.SettingMaterials.modules.extreme_reactor) {
            moduleExtremeReactor.init(event);
        }
        if(isModLoaded("dcs_climate") && TinkersReforgedConfig.SettingMaterials.modules.heat_and_climate)  {
            moduleHeatAndClimate.init(event);
        }
        if(isModLoaded("mekanism") && TinkersReforgedConfig.SettingMaterials.modules.mekanism) {
            moduleMekanism.init(event);
        }
        if(isModLoaded("naturesaura") && TinkersReforgedConfig.SettingMaterials.modules.naturesaura) {
            moduleNaturesAura.init(event);
        }
        if(isModLoaded("projectred-core") && TinkersReforgedConfig.SettingMaterials.modules.project_red) {
            moduleProjectRed.init(event);
        }
        if(isModLoaded("pixelmon") && TinkersReforgedConfig.SettingMaterials.modules.pixelmon) {
            modulePixelmon.init(event);
        }
        if(isModLoaded("roots") && TinkersReforgedConfig.SettingMaterials.modules.roots) {
            moduleRoots.init(event);
        }
        if(isModLoaded("refinedstorage") && TinkersReforgedConfig.SettingMaterials.modules.refined_storage) {
            moduleRS.init(event);
        }
        if(isModLoaded("thaumcraft") && TinkersReforgedConfig.SettingMaterials.modules.thaumcraft) {
            moduleThaumcraft.init(event);
        }
        if(isModLoaded("thermalexpansion") && TinkersReforgedConfig.SettingMaterials.modules.thermal) {
            moduleThermal.init(event);
        }
        if(isModLoaded("tinkers_reforged") && TinkersReforgedConfig.SettingMaterials.modules.tinkers_reforged) {
            moduleTinkersReforged.init(event);
        }

        for(Modifier modifier: modifiers) {
            TinkersReforged.proxy.registerModifierModel(modifier, new ResourceLocation("models/item/modifiers/" + modifier.getIdentifier()));
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        if(isModLoaded("actuallyadditions") && TinkersReforgedConfig.SettingMaterials.modules.actuallyadditions) {
            moduleAA.postInit(event);
        }
        if(isModLoaded("appliedenergistics2") && TinkersReforgedConfig.SettingMaterials.modules.appliedenergistics2) {
            moduleAe2.postInit(event);
        }
        if(isModLoaded("astralsorcery") && TinkersReforgedConfig.SettingMaterials.modules.atum) {
            moduleAS.postInit(event);
        }
        if(isModLoaded("atum") && TinkersReforgedConfig.SettingMaterials.modules.atum) {
            moduleAtum.postInit(event);
        }
        if(isModLoaded("blue_skies") && TinkersReforgedConfig.SettingMaterials.modules.blue_skies) {
            moduleBlueSkies.postInit(event);
        }
        if(isModLoaded("biomesoplenty") && TinkersReforgedConfig.SettingMaterials.modules.biomeoplenty) {
            moduleBop.postInit(event);
        }
        if(isModLoaded("botania") && TinkersReforgedConfig.SettingMaterials.modules.botania) {
            moduleBotania.postInit(event);
        }
        if(isModLoaded("cavern") && TinkersReforgedConfig.SettingMaterials.modules.cavern2) {
            moduleCavern2.postInit(event);
        }
        if(isModLoaded("darkutils") && TinkersReforgedConfig.SettingMaterials.modules.dark_utils) {
            moduleDarkUtils.postInit(event);
        }
        if(isModLoaded("environmentaltech") && TinkersReforgedConfig.SettingMaterials.modules.environmentaltech) {
            moduleEnvTech.postInit(event);
        }
        if(isModLoaded("bigreactors") && TinkersReforgedConfig.SettingMaterials.modules.extreme_reactor) {
            moduleExtremeReactor.postInit(event);
        }
        if(isModLoaded("dcs_climate") && TinkersReforgedConfig.SettingMaterials.modules.heat_and_climate)  {
            moduleHeatAndClimate.postInit(event);
        }
        if(isModLoaded("mekanism") && TinkersReforgedConfig.SettingMaterials.modules.mekanism) {
            moduleMekanism.postInit(event);
        }
        if(isModLoaded("naturesaura") && TinkersReforgedConfig.SettingMaterials.modules.naturesaura) {
            moduleNaturesAura.postInit(event);
        }
        if(isModLoaded("projectred-core") && TinkersReforgedConfig.SettingMaterials.modules.project_red) {
            moduleProjectRed.postInit(event);
        }
        if(isModLoaded("pixelmon") && TinkersReforgedConfig.SettingMaterials.modules.pixelmon) {
            modulePixelmon.postInit(event);
        }
        if(isModLoaded("roots") && TinkersReforgedConfig.SettingMaterials.modules.roots) {
            moduleRoots.postInit(event);
        }
        if(isModLoaded("refinedstorage") && TinkersReforgedConfig.SettingMaterials.modules.refined_storage) {
            moduleRS.postInit(event);
        }
        if(isModLoaded("thaumcraft") && TinkersReforgedConfig.SettingMaterials.modules.thaumcraft) {
            moduleThaumcraft.postInit(event);
        }
        if(isModLoaded("thermalexpansion") && TinkersReforgedConfig.SettingMaterials.modules.thermal) {
            moduleThermal.postInit(event);
        }
        if(isModLoaded("tinkersreforged") && TinkersReforgedConfig.SettingMaterials.modules.tinkers_reforged) {
            moduleTinkersReforged.postInit(event);
        }
    }

    public static boolean isModLoaded(String moduleName) {
        return Loader.isModLoaded(moduleName);
    }
}
