package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
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

    public ModuleAtum() {
        Resources.limestone.builder.setTrait(TinkerTraits.cheapskate, MaterialTypes.HEAD);
        Resources.limestone.builder.setTrait(TinkerTraits.cheap);
        Resources.limestone.builder.setHeadStats(180, 3.1f, 2.2f, HarvestLevels.STONE);
        Resources.limestone.builder.setHandleStats(0.9f, 50);
        Resources.limestone.builder.setExtraStats(30);

        Resources.khnumite.builder.setTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
        Resources.khnumite.builder.setTrait(TinkerTraits.poisonous);
        Resources.khnumite.builder.setHeadStats(200, 3.4f, 3.1f, HarvestLevels.IRON);
        Resources.khnumite.builder.setHandleStats(0.9f, 70);
        Resources.khnumite.builder.setExtraStats(50);
    }
    public void preInit(FMLPreInitializationEvent e) {
        if(ConfigMaterials.limestone) {
            Resources.limestone.builder.addIngot("stoneLimestone");
            Resources.limestone.builder.preInit("stoneLimestone");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.limestone.builder, 0);
            }
            Resources.materials.add(Resources.limestone);
        }
        if (ConfigMaterials.khnumite) {
            Resources.khnumite.builder.addIngot("ingotKhnumite");
            Resources.khnumite.builder.preInit("Khnumite");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.khnumite.builder, 0);
            }
            Resources.materials.add(Resources.khnumite);
        }
    }
    public void init(FMLInitializationEvent e) { 
        if(ConfigMaterials.khnumite) {
            Resources.khnumite.builder.setRepresentativeItem("ingotKhnumite");
        }
    }

    public void postInit(FMLPostInitializationEvent e) {
        // compat to make limestone work
        OredictHelper.removeOredict(new ItemStack(AtumBlocks.LIMESTONE), "stone");
    }
}
