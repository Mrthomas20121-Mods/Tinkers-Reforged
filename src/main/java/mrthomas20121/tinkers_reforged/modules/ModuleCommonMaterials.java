package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleCommonMaterials implements ModuleBase {

    public ModuleCommonMaterials() {

    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        MaterialStats commonStats = new MaterialStats();
        commonStats.setHeadMaterialStats(500, 5.7f, 6.3f, HarvestLevels.OBSIDIAN);
        commonStats.setHandleMaterialStats(1f, 90);
        commonStats.setExtraMaterialStats(30);
        commonStats.setBowMaterialStats(2, 1.5f, 7);

        MaterialStats gemStats = new MaterialStats();
        gemStats.setHeadMaterialStats(300, 5f, 4f, HarvestLevels.DIAMOND);
        gemStats.setHandleMaterialStats(1.4f, 0);
        gemStats.setExtraMaterialStats(10);

        if(ConfigMaterials.platinum)
        {
            Resources.platinum.setTemp(2000);
            Resources.platinum.addTrait(TinkerTraits.dense);
            Resources.platinum.createMaterial(commonStats);
            Resources.materials.add(Resources.platinum);
        }
        if(ConfigMaterials.iridium)
        {
            Resources.iridium.setTemp(2446);
            Resources.iridium.addTrait(TinkerTraits.alien, MaterialTypes.HEAD);
            Resources.iridium.addTrait(TinkerTraits.dense);
            Resources.iridium.createMaterial(commonStats);

            Resources.materials.add(Resources.iridium);
        }
        if(ConfigMaterials.invar)
        {
            Resources.invar.setTemp(2000);
            Resources.invar.addTrait(TinkerTraits.hellish);
            Resources.invar.createMaterial(commonStats);
            Resources.materials.add(Resources.invar);
        }
        if(ConfigMaterials.aluminium)
        {
            Resources.aluminum.setTemp(1900);
            Resources.aluminum.addTrait(TinkerTraits.dense);
            Resources.aluminum.createMaterial(commonStats);
            Resources.materials.add(Resources.aluminum);
        }
        if(ConfigMaterials.titanium)
        {
            Resources.titanium.setTemp(2000);
            Resources.titanium.addTrait(TinkerTraits.lightweight);
            Resources.titanium.createMaterial(commonStats);
            Resources.materials.add(Resources.titanium);
        }
        if(ConfigMaterials.amethyst)
        {
            Resources.amethyst.setTemp(1500);
            Resources.amethyst.addTrait(TinkerTraits.sharp, MaterialTypes.HEAD);
            Resources.amethyst.addTrait(TinkerTraits.jagged);
            Resources.amethyst.createGemMaterial(gemStats);
            Resources.materials.add(Resources.amethyst);
        }
        if(ConfigMaterials.sapphire)
        {
            Resources.sapphire.setTemp(1500);
            Resources.sapphire.addTrait(TinkerTraits.sharp, MaterialTypes.HEAD);
            Resources.sapphire.addTrait(TinkerTraits.fractured);
            Resources.sapphire.createGemMaterial(gemStats);
            Resources.materials.add(Resources.sapphire);
        }
        if(ConfigMaterials.ruby)
        {
            Resources.ruby.setTemp(1500);
            Resources.ruby.addTrait(TinkerTraits.sharp, MaterialTypes.HEAD);
            Resources.ruby.addTrait(TinkerTraits.fractured);
            Resources.ruby.createGemMaterial(gemStats);
            Resources.materials.add(Resources.ruby);
        }
        if(ConfigMaterials.peridot)
        {
            Resources.peridot.setTemp(1500);
            Resources.peridot.addTrait(TinkerTraits.sharp, MaterialTypes.HEAD);
            Resources.peridot.addTrait(TinkerTraits.fractured);
            Resources.peridot.createGemMaterial(gemStats);
            Resources.materials.add(Resources.peridot);
        }

        if(Loader.isModLoaded("conarm"))
        {
            if(ConfigMaterials.titanium) armorUtils.setArmorStats(Resources.titanium, commonStats, 1);
            if(ConfigMaterials.invar) armorUtils.setArmorStats(Resources.invar,commonStats, 1);
            if(ConfigMaterials.platinum) armorUtils.setArmorStats(Resources.platinum, commonStats, 1);
            if(ConfigMaterials.iridium) armorUtils.setArmorStats(Resources.iridium, commonStats, 1);
            if(ConfigMaterials.aluminium) armorUtils.setArmorStats(Resources.aluminum, commonStats, 1);
            if(ConfigMaterials.amethyst) armorUtils.setArmorStats(Resources.amethyst, gemStats, 2);
            if(ConfigMaterials.ruby) armorUtils.setArmorStats(Resources.ruby, gemStats, 0);
            if(ConfigMaterials.sapphire) armorUtils.setArmorStats(Resources.sapphire, gemStats, 0);
            if(ConfigMaterials.peridot) armorUtils.setArmorStats(Resources.peridot, gemStats, 0);
        }
    }

    @Override
    public void init(FMLInitializationEvent e) {}
    @Override
    public void postInit(FMLPostInitializationEvent e) {}
}
