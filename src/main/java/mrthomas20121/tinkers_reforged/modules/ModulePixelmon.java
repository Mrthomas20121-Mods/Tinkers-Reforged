package mrthomas20121.tinkers_reforged.modules;

import com.pixelmonmod.pixelmon.config.PixelmonBlocks;
import com.pixelmonmod.pixelmon.config.PixelmonItems;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import mrthomas20121.tinkers_reforged.trait.Traits;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModulePixelmon implements ModuleBase {

    @Override
    public void preInit(FMLPreInitializationEvent fmlPreInitializationEvent) {
        MaterialStats fireWaterStats = new MaterialStats();
        fireWaterStats.setHeadMaterialStats(340, 5, 4, HarvestLevels.IRON);
        fireWaterStats.setHandleMaterialStats(0.9f, 50);
        fireWaterStats.setExtraMaterialStats(10);
        fireWaterStats.setBowMaterialStats(3.2f, 3.2f, 5);

        MaterialStats otherStats = new MaterialStats();
        otherStats.setHeadMaterialStats(300, 2, 1, HarvestLevels.IRON);
        otherStats.setHandleMaterialStats(0.9f, 30);
        otherStats.setExtraMaterialStats(10);
        otherStats.setBowMaterialStats(7, 5, 2);

        MaterialStats leafStats = new MaterialStats();
        leafStats.setHeadMaterialStats(300, 4, 3, HarvestLevels.IRON);
        leafStats.setHandleMaterialStats(0.9f, 50);
        leafStats.setExtraMaterialStats(10);
        leafStats.setBowMaterialStats(3, 5, 4);

        if(ConfigMaterials.firestone)
        {
            Resources.fire.setTemp(500);
            Resources.fire.addTrait(Traits.traitBackfire);
            Resources.fire.createGemMaterial(fireWaterStats);
        }
        if(ConfigMaterials.waterstone)
        {
            Resources.water.setTemp(500);
            Resources.water.addTrait(TinkerTraits.aquadynamic);
            Resources.water.createGemMaterial(fireWaterStats);
        }
        if(ConfigMaterials.leafstone)
        {
            Resources.leaf.setTemp(500);
            Resources.leaf.addTrait(Traits.traitLeafblower);
            Resources.leaf.createGemMaterial(leafStats);
        }
        if(ConfigMaterials.thunderstone)
        {
            Resources.thunder.setTemp(750);
            Resources.thunder.addTrait(Traits.traitRod);
            Resources.thunder.createGemMaterial(otherStats);
        }
        if(ConfigMaterials.sunstone)
        {
            Resources.sun.setTemp(200);
            Resources.sun.addTrait(Traits.light);
            Resources.sun.createGemMaterial(otherStats);
        }
        if(ConfigMaterials.dawnstone)
        {
            Resources.dawn.setTemp(500);
            Resources.dawn.addTrait(Traits.life_steal);
            Resources.dawn.createGemMaterial(otherStats);
        }
        if(ConfigMaterials.duskstone)
        {
            Resources.dusk.setTemp(500);
            Resources.dusk.addTrait(TinkerTraits.poisonous);
            Resources.dusk.createGemMaterial(otherStats);
        }
        if(ConfigMaterials.crystal)
        {
            Resources.crystal.setTemp(230);
            Resources.crystal.addTrait(TinkerTraits.sharp, MaterialTypes.HEAD);
            Resources.crystal.addTrait(TinkerTraits.jagged);
            Resources.crystal.createGemMaterial(leafStats);
        }
    }

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {

        OreDictionary.registerOre("oreWaterstone", PixelmonBlocks.waterStoneOre);
        OreDictionary.registerOre("gemWaterstone", PixelmonItems.waterStone);
        OreDictionary.registerOre("nuggetWaterstone", PixelmonItems.waterStoneShard);

        OreDictionary.registerOre("oreFirestone", PixelmonBlocks.fireStoneOre);
        OreDictionary.registerOre("gemFirestone", PixelmonItems.fireStone);
        OreDictionary.registerOre("nuggetFirestone", PixelmonItems.fireStoneShard);

        OreDictionary.registerOre("oreLeafstone", PixelmonBlocks.leafStoneOre);
        OreDictionary.registerOre("gemLeafstone", PixelmonItems.leafStone);
        OreDictionary.registerOre("nuggetLeafstone", PixelmonItems.leafStoneShard);

        OreDictionary.registerOre("oreThunderstone", PixelmonBlocks.thunderStoneOre);
        OreDictionary.registerOre("gemThunderstone", PixelmonItems.thunderStone);
        OreDictionary.registerOre("nuggetThunderstone", PixelmonItems.thunderStoneShard);

        OreDictionary.registerOre("oreSunstone", PixelmonBlocks.sunStoneOre);
        OreDictionary.registerOre("gemSunstone", PixelmonItems.sunStone);
        OreDictionary.registerOre("nuggetSunstone", PixelmonItems.sunStoneShard);

        OreDictionary.registerOre("gemDawnstone", PixelmonItems.dawnStone);
        OreDictionary.registerOre("nuggetDawnstone", PixelmonItems.dawnStoneShard);

        OreDictionary.registerOre("gemDuskstone", PixelmonItems.duskStone);
        OreDictionary.registerOre("nuggetDuskstone", PixelmonItems.duskStoneShard);

    }

    @Override
    public void postInit(FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
