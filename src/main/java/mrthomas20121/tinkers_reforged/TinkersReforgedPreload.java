package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.library.module.ModuleManager;
import mrthomas20121.tinkers_reforged.modules.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TinkersReforged.MODID+"_preload", version = TinkersReforged.VERSION, dependencies = "required-before:tconstruct")
public class TinkersReforgedPreload {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        // load modules
        ModuleManager.addModule(TinkersReforged.MODID, new MaterialsTinkersReforged());
        ModuleManager.addModule(Reference.aa, new MaterialsAA());
        ModuleManager.addModule(Reference.ae2, new MaterialsAe2());
        ModuleManager.addModule(Reference.as, new MaterialsAS());
        ModuleManager.addModule(Reference.atum, new MaterialsAtum());
        ModuleManager.addModule(TinkersReforged.MODID, new MaterialsBaseMaterials());
        ModuleManager.addModule(Reference.bop, new ModifiersBop());
        ModuleManager.addModule(Reference.blue_skies, new MaterialsBlueSkies());
        ModuleManager.addModule(Reference.botania, new MaterialsBotania());
        ModuleManager.addModule(Reference.cavern2, new MaterialsCavern2());
        ModuleManager.addModule(Reference.forestry, new MaterialsForestry());
        ModuleManager.addModule(Reference.darkutils, new ModifiersDarkUtils());
        ModuleManager.addModule(Reference.project_red, new MaterialsProjectRed());
        ModuleManager.addModule(Reference.roots, new MaterialsRoots());
        ModuleManager.addModule(Reference.thermalfoundation, new MaterialsThermal());
        ModuleManager.addModule(Reference.thaumcraft, new MaterialsThaumcraft());

        // earlyPreInit to load materials before tinkers to avoid issues.
        ModuleManager.earlyPreInit();
    }
}
