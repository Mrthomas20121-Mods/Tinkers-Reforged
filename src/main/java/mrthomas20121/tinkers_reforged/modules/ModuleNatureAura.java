package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.objects.material.MaterialStats;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.trait.Traits;

import mrthomas20121.tinkers_reforged.config.ConfigMaterials;
import mrthomas20121.tinkers_reforged.resources.Resources;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;
import de.ellpeck.naturesaura.items.ModItems;
import de.ellpeck.naturesaura.blocks.ModBlocks;
import net.minecraftforge.oredict.OreDictionary;

public class ModuleNatureAura implements ModuleBase {


    public ModuleNatureAura() {
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        if(ConfigMaterials.material_of_the_sky) {

            MaterialStats sky = new MaterialStats();
            sky.setHeadMaterialStats(204, 6.05f, 4.20f, HarvestLevels.DIAMOND);
            sky.setHandleMaterialStats(1f, 60);
            sky.setExtraMaterialStats(50);
            sky.setBowMaterialStats(0.9f, 1.9f, 7.9f);

            Resources.ingot_of_the_sky.setTemp(500);
            Resources.ingot_of_the_sky.addTrait(Traits.AURA_INFUSION, MaterialTypes.HEAD);
            Resources.ingot_of_the_sky.addTrait(TinkerTraits.alien);
            Resources.ingot_of_the_sky.createMaterial(sky);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.ingot_of_the_sky,sky, 1f);
            }
            Resources.materials.add(Resources.ingot_of_the_sky);
        }
        if (ConfigMaterials.infused_iron) {
            MaterialStats iron = new MaterialStats();
            iron.setHeadMaterialStats(204, 6.00f, 4.00f, HarvestLevels.DIAMOND);
            iron.setHandleMaterialStats(0.85f, 60);
            iron.setExtraMaterialStats(50);
            iron.setBowMaterialStats(0.5f, 1.5f, 7f);

            Resources.infused_iron.setTemp(500);
            Resources.infused_iron.addTrait(Traits.AURA_INFUSION, MaterialTypes.HEAD);
            Resources.infused_iron.addTrait(TinkerTraits.magnetic2);
            Resources.infused_iron.createMaterial(iron);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.infused_iron, iron, 0);
            }
            Resources.materials.add(Resources.infused_iron);
        }
        if (ConfigMaterials.ancient_wood) {
            MaterialStats ancient_wood_stats = new MaterialStats();
            ancient_wood_stats.setHeadMaterialStats(100, 2.3f, 1.2f, HarvestLevels.STONE);
            ancient_wood_stats.setBowStringMaterialStats(1.5f);
            ancient_wood_stats.setArrowShaftMaterialStats(1.5f, 2);
            ancient_wood_stats.setBowMaterialStats(1.2f, 0.5f, 19f);

            Resources.ancient_wood.addTrait(TinkerTraits.ecological);
            Resources.ancient_wood.getMaterial().addItem(new ItemStack(ModBlocks.ANCIENT_PLANKS, 1), 1, 144);
            Resources.ancient_wood.addWood(new ItemStack(ModBlocks.ANCIENT_PLANKS), new ItemStack(ModBlocks.ANCIENT_LOG));
            Resources.ancient_wood.createWoodMaterial(ancient_wood_stats);
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.ancient_wood, ancient_wood_stats, 0);
            }
            Resources.materials.add(Resources.ancient_wood);
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        OreDictionary.registerOre("ingotInfusedIron", ModItems.INFUSED_IRON);
        OreDictionary.registerOre("blockInfusedIron", ModBlocks.INFUSED_IRON);
        
        OreDictionary.registerOre("ingotSky", ModItems.SKY_INGOT);

    }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}
