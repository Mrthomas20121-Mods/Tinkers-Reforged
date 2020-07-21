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

public class ModuleRoots implements ModuleBase {
    public MaterialBuilder runestone = new MaterialBuilder(Materials.runestone);

    public ModuleRoots() {
        runestone.setCraftable(true);
        runestone.setCastable(false);
        runestone.setHeadStats(200, 4f, 4f, HarvestLevels.STONE);
        runestone.setHandleStats(1f, 100);
        runestone.setExtraStats(-10);
        runestone.setTrait(TinkerTraits.cheap, MaterialTypes.HEAD);
        runestone.setTrait(TinkerTraits.cheapskate);
        if(Loader.isModLoaded("conarm"))
        {
            armorUtils.setArmorStats(runestone, 0);
        }
        Materials.mats.add(runestone.getMat());
    }

    public void preInit(FMLPreInitializationEvent e) {
        if(Config.runestone) {
            runestone.preInit("runestone");
        }
    }
    public void init(FMLInitializationEvent e) {
        runestone.setRepresentativeItem("runestone");
    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
