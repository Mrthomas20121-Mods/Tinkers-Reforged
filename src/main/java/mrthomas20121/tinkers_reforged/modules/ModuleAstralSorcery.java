package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.trait.Traits;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAstralSorcery implements ModuleBase {


    public ModuleAstralSorcery() {
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {

        MaterialStats iron = new MaterialStats();
        iron.setHeadMaterialStats(200, 5.2f, 3.2f, HarvestLevels.DIAMOND);
        iron.setHandleMaterialStats(0.85f, 60);
        iron.setExtraMaterialStats(50);
        iron.setBowMaterialStats(0.5f, 1.5f, 7f);

        if(ConfigMaterials.starmetal)
        {
            Resources.starmetal.setOredict("AstralStarmetal");
            Resources.starmetal.addTrait(Traits.astral, MaterialTypes.HEAD);
            Resources.starmetal.addTrait(TinkerTraits.alien);
            Resources.starmetal.createMaterial(iron);

            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.starmetal, iron, 1f);
            }
            Resources.materials.add(Resources.starmetal);
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {

    }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}