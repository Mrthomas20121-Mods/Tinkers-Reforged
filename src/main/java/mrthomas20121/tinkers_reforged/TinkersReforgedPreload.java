package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.modules.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TinkersReforged.MODID+"_preload", name = "Tinkers' Reforged Preload", version = TinkersReforged.VERSION, dependencies = "required-before:tconstruct")
public class TinkersReforgedPreload {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        // load modules first then call earlyPreInit();
        TinkersReforged.manager.add(new MaterialsAA());
        TinkersReforged.manager.add(new MaterialsAe2());
        TinkersReforged.manager.add(new MaterialsAS());
        TinkersReforged.manager.add(new MaterialsAtum());
        TinkersReforged.manager.add(new MaterialsBaseMaterials());
        TinkersReforged.manager.add(new MaterialsBlueSkies());
        TinkersReforged.manager.add(new MaterialsBotania());
        TinkersReforged.manager.add(new MaterialsCavern2());
        TinkersReforged.manager.add(new MaterialsExtremeReactor());
        TinkersReforged.manager.add(new MaterialsForestry());
        TinkersReforged.manager.add(new MaterialsHeatAndClimate());
        TinkersReforged.manager.add(new MaterialsMekanism());
        TinkersReforged.manager.add(new MaterialsNaturesAura());
        TinkersReforged.manager.add(new MaterialsPixelmon());
        TinkersReforged.manager.add(new MaterialsProjectRed());
        TinkersReforged.manager.add(new MaterialsRoots());
        TinkersReforged.manager.add(new MaterialsRS());
        TinkersReforged.manager.add(new MaterialsThaumcraft());
        TinkersReforged.manager.add(new MaterialsThermal());
        TinkersReforged.manager.add(new MaterialsTinkersReforged());
        TinkersReforged.manager.add(new ModifiersBop());
        TinkersReforged.manager.add(new ModifiersDarkUtils());

        // preInit before tinkers to load some materials that are using the stone/wood oredict.
        TinkersReforged.manager.earlyPreInit();
    }
}
