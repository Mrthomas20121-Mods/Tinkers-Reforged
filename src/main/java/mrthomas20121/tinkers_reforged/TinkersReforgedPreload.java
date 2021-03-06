package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.library.module.ModuleManager;
import mrthomas20121.tinkers_reforged.modules.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TinkersReforged.MODID+"_preload", name = "Tinkers' Reforged Preload", version = TinkersReforged.VERSION, dependencies = "required-before:tconstruct")
public class TinkersReforgedPreload {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        // load modules
        ModuleManager.addModule(Reference.aa, new MaterialsAA());
        ModuleManager.addModule(Reference.ae2, new MaterialsAe2());
        ModuleManager.addModule(Reference.as, new MaterialsAS());
        ModuleManager.addModule(Reference.atum, new MaterialsAtum());
        ModuleManager.addModule("tinkers_reforged", new MaterialsBaseMaterials());
        ModuleManager.addModule(Reference.bop, new ModifiersBop());
        ModuleManager.addModule(Reference.blue_skies, new MaterialsBlueSkies());
        ModuleManager.addModule(Reference.botania, new MaterialsBotania());
        ModuleManager.addModule(Reference.cavern2, new MaterialsCavern2());
        ModuleManager.addModule(Reference.reactor, new MaterialsExtremeReactor());
        // module not finished
        // ModuleManager.addModule(Reference.forestry, new MaterialsForestry());
        ModuleManager.addModule(Reference.darkutils, new ModifiersDarkUtils());
        ModuleManager.addModule(Reference.heat_climate, new MaterialsHeatAndClimate());
        ModuleManager.addModule(Reference.mekanism, new MaterialsMekanism());
        ModuleManager.addModule(Reference.naturesaura, new MaterialsNaturesAura());
        ModuleManager.addModule(Reference.pixelmon, new MaterialsPixelmon());
        ModuleManager.addModule(Reference.project_red, new MaterialsProjectRed());
        ModuleManager.addModule(Reference.refined_storage, new MaterialsRS());
        ModuleManager.addModule(Reference.roots, new MaterialsRoots());
        ModuleManager.addModule(Reference.thermalfoundation, new MaterialsThermal());
        ModuleManager.addModule(Reference.thaumcraft, new MaterialsThaumcraft());
        ModuleManager.addModule("tinkers_reforged", new MaterialsTinkersReforged());

        // earlyPreInit to load materials before tinkers to avoid issues.
        ModuleManager.earlyPreInit();
    }
}
