package mrthomas20121.tinkers_reforged.Module;

import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Config.Config;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleMysticalWorld implements ModuleBase {

    public MaterialBuilder amethyst = new MaterialBuilder(Materials.amethyst);

    public ModuleMysticalWorld() {
        amethyst.setCraftable(true).setCastable(false);
        amethyst.setTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
        amethyst.setTrait(TinkerTraits.sharp);
        amethyst.setHeadStats(300, 6f, 5f, HarvestLevels.DIAMOND);
        amethyst.setHandleStats(1, 200);
        amethyst.setExtraStats(30);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.amethyst) {
            amethyst.addGem("Amethyst");
            amethyst.preInit("Amethyst");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(amethyst, 0);
            }
            Materials.mats.add(amethyst.getMat());
        }
    }

    @Override
    public void init(FMLInitializationEvent e) {
        if (Config.amethyst) {
            amethyst.addGem("Amethyst");
            amethyst.setRepresentativeItem("gemAmethyst");
        }
     }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}
