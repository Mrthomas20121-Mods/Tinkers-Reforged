package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.common.OredictHelper;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
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
    }
    public void preInit(FMLPreInitializationEvent e) {

        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.limestone.getMaterial().getIdentifier())) {
            MaterialStats limestoneStats = new MaterialStats();
            limestoneStats.setHeadMaterialStats(180, 3.1f, 2.2f, HarvestLevels.STONE);
            limestoneStats.setHandleMaterialStats(0.9f, 50);
            limestoneStats.setExtraMaterialStats(40);
            limestoneStats.setArrowShaftMaterialStats(0.9f, 50);

            Resources.limestone.addTrait(TinkerTraits.cheapskate, MaterialTypes.HEAD);
            Resources.limestone.addTrait(TinkerTraits.cheap);
            Resources.limestone.addItems("limestone");
            Resources.limestone.createWoodMaterial(limestoneStats);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.limestone, limestoneStats, 0);
            }
            Resources.materials.add(Resources.limestone);
        }
        if (TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.khnumite.getMaterial().getIdentifier())) {

            MaterialStats khnumiteStats = new MaterialStats();
            khnumiteStats.setHeadMaterialStats(230, 3.5f, 2.9f, HarvestLevels.STONE);
            khnumiteStats.setHandleMaterialStats(0.9f, 80);
            khnumiteStats.setExtraMaterialStats(40);
            khnumiteStats.setArrowShaftMaterialStats(0.9f, 50);

            Resources.khnumite.addTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
            Resources.khnumite.addTrait(TinkerTraits.poisonous);
            Resources.khnumite.createMaterial(khnumiteStats);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.khnumite, khnumiteStats, 0);
            }
            Resources.materials.add(Resources.khnumite);
        }
    }
    public void init(FMLInitializationEvent e) { 
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.khnumite.getMaterial().getIdentifier())) {
            Resources.khnumite.getMaterial().setRepresentativeItem("ingotKhnumite");
        }
        if(TinkersReforgedConfig.SettingMaterials.containMaterials(Resources.limestone.getMaterial().getIdentifier()))
        {
            Resources.limestone.addItems(new ItemStack(AtumBlocks.LIMESTONE));
        }
    }

    public void postInit(FMLPostInitializationEvent e) {
        // compat to make limestone work
        OredictHelper.removeOredict(new ItemStack(AtumBlocks.LIMESTONE), "stone");
    }
}
