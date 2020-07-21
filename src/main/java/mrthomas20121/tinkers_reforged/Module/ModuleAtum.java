package mrthomas20121.tinkers_reforged.Module;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Config.Config;
import com.teammetallurgy.atum.init.AtumBlocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAtum implements ModuleBase {
    public MaterialBuilder limestone = new MaterialBuilder(Materials.limestone);
    public MaterialBuilder khnumite = new MaterialBuilder(Materials.khnumite);
    
    public ModuleAtum() {
        limestone.setCraftable(true).setCastable(false);
        limestone.setTrait(TinkerTraits.cheapskate, MaterialTypes.HEAD);
        limestone.setTrait(TinkerTraits.cheap);
        limestone.setHeadStats(180, 3.1f, 2.2f, HarvestLevels.STONE);
        limestone.setHandleStats(0.9f, 50);
        limestone.setExtraStats(30);

        khnumite.setCraftable(true).setCastable(false);
        khnumite.setTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
        khnumite.setTrait(TinkerTraits.poisonous);
        khnumite.setHeadStats(200, 3.4f, 3.1f, HarvestLevels.IRON);
        khnumite.setHandleStats(0.9f, 70);
        khnumite.setExtraStats(50);
    }
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.limestone) {
            limestone.addIngot("stoneLimestone");
            limestone.preInit("stoneLimestone");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(limestone, 0);
            }
        }
        if (Config.khnumite) {
            khnumite.addIngot("ingotKhnumite");
            khnumite.preInit("Khnumite");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(khnumite, 0);
            }
        }
    }
    public void init(FMLInitializationEvent e) { 
        if(Config.khnumite) {
            khnumite.setRepresentativeItem("ingotKhnumite");
        }
    }

    public void postInit(FMLPostInitializationEvent e) {
        // compat to make limestone work
        OredictHelper.removeOredict(new ItemStack(AtumBlocks.LIMESTONE), "stone");
    }
}
