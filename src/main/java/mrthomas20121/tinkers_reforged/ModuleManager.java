package mrthomas20121.tinkers_reforged;

import mrthomas20121.biolib.library.ModuleBase;
import mrthomas20121.biolib.util.ConarmUtil;
import mrthomas20121.tinkers_reforged.library.ModuleCore;
import mrthomas20121.tinkers_reforged.modules.actuallyadditions.ModuleAA;
import mrthomas20121.tinkers_reforged.modules.appliedenergistics2.ModuleAe2;
import mrthomas20121.tinkers_reforged.modules.astralsorcery.ModuleAS;
import mrthomas20121.tinkers_reforged.modules.atum.ModuleAtum;
import mrthomas20121.tinkers_reforged.modules.base_materials.ModuleBaseMaterials;
import mrthomas20121.tinkers_reforged.modules.biome_o_plenty.ModuleBop;
import mrthomas20121.tinkers_reforged.modules.blue_skies.ModuleBlueSkies;
import mrthomas20121.tinkers_reforged.modules.botania.ModuleBotania;
import mrthomas20121.tinkers_reforged.modules.cavern2.ModuleCavern2;
import mrthomas20121.tinkers_reforged.modules.darkutils.ModuleDarkUtils;
import mrthomas20121.tinkers_reforged.modules.environmental_tech.ModuleEnvTech;
import mrthomas20121.tinkers_reforged.modules.extreme_reactor.ModuleExtremeReactor;
import mrthomas20121.tinkers_reforged.modules.heat_and_climate.ModuleHeatAndClimate;
import mrthomas20121.tinkers_reforged.modules.mekanism.ModuleMekanism;
import mrthomas20121.tinkers_reforged.modules.natures_aura.ModuleNaturesAura;
import mrthomas20121.tinkers_reforged.modules.pixelmon.ModulePixelmon;
import mrthomas20121.tinkers_reforged.modules.project_red.ModuleProjectRed;
import mrthomas20121.tinkers_reforged.modules.refined_storage.ModuleRS;
import mrthomas20121.tinkers_reforged.modules.roots.ModuleRoots;
import mrthomas20121.tinkers_reforged.modules.thaumcraft.ModuleThaumcraft;
import mrthomas20121.tinkers_reforged.modules.thermal_foundation.ModuleThermal;
import mrthomas20121.tinkers_reforged.modules.tinkers_reforged.ModuleReforged;
import net.minecraft.util.ResourceLocation;
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
    private static ArrayList<ModuleCore> modules = new ArrayList<>();

    public static ArrayList<ModuleCore> getModules() {
        return modules;
    }

    public static void addModifier(Modifier modifier) {
        modifiers.add(modifier);
    }

    public void registerModule(ModuleCore module) {
        if(module.canLoad() && !modules.contains(module)) {
            modules.add(module);
        }
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        registerModule(new ModuleAA());
        registerModule(new ModuleAe2());
        registerModule(new ModuleAS());
        registerModule(new ModuleAtum());
        registerModule(new ModuleBaseMaterials());
        registerModule(new ModuleBlueSkies());
        registerModule(new ModuleBop());
        registerModule(new ModuleBotania());
        registerModule(new ModuleCavern2());
        registerModule(new ModuleDarkUtils());
        registerModule(new ModuleEnvTech());
        registerModule(new ModuleExtremeReactor());
        registerModule(new ModuleHeatAndClimate());
        registerModule(new ModuleMekanism());
        registerModule(new ModuleNaturesAura());
        registerModule(new ModulePixelmon());
        registerModule(new ModuleProjectRed());
        registerModule(new ModuleRS());
        registerModule(new ModuleRoots());
        registerModule(new ModuleThaumcraft());
        registerModule(new ModuleThermal());
        registerModule(new ModuleReforged());

        modules.forEach(module -> module.preInit(event));

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
        modules.forEach(module -> module.init(event));

        for(Modifier modifier: modifiers) {
            TinkersReforged.proxy.registerModifierModel(modifier, new ResourceLocation("models/item/modifiers/" + modifier.getIdentifier()));
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        modules.forEach(module -> module.postInit(event));
    }

    public static boolean isModLoaded(String moduleName) {
        return Loader.isModLoaded(moduleName);
    }
}
