package mrthomas20121.tinkers_reforged.Module;

import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.Config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;

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

    public MaterialBuilder infused_iron = new MaterialBuilder(Materials.infused_iron);
    public MaterialBuilder ancient_wood = new MaterialBuilder(Materials.ancient_wood);
    public MaterialBuilder ingot_of_the_sky = new MaterialBuilder(Materials.ingot_of_the_sky);

    public ModuleNatureAura() {
        ingot_of_the_sky.setCraftable(false).setCastable(true);
        ingot_of_the_sky.setTrait(Traits.AURA_INFUSION, MaterialTypes.HEAD);
        ingot_of_the_sky.setTrait(TinkerTraits.alien);
        ingot_of_the_sky.setHeadStats(230, 6.3f, 4f, HarvestLevels.OBSIDIAN);
        ingot_of_the_sky.setHandleStats(1f, 90);
        ingot_of_the_sky.setExtraStats(75);
        ingot_of_the_sky.setBowStats(1.0f, 1.7f, 3.5f);

        infused_iron.setCraftable(false).setCastable(true);
        infused_iron.setTrait(Traits.AURA_INFUSION, MaterialTypes.HEAD);
        infused_iron.setTrait(TinkerTraits.magnetic2);
        infused_iron.setHeadStats(200, 6.3f, 4f, HarvestLevels.DIAMOND);
        infused_iron.setHandleStats(0.9f, 90);
        infused_iron.setExtraStats(70);
        infused_iron.setBowStats(2, 1.5f, 7);

        ancient_wood.setCraftable(true).setCastable(false);
        ancient_wood.setTrait(TinkerTraits.ecological);
        ancient_wood.setHeadStats(100, 2.3f, 1.2f, HarvestLevels.STONE);
        ancient_wood.setHandleStats(1.9f, 10);
        ancient_wood.setExtraStats(-10);
        ancient_wood.setBowStats(0.9f, 1.0f, 1);
        ancient_wood.addFletchingStats(0.1f, 0.5f);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        if(Config.ingot_of_the_sky) {
            ingot_of_the_sky.setFluid(FluidRegistry.getFluid("molten_of_the_sky"));
            ingot_of_the_sky.addIngot(ModItems.SKY_INGOT);
            ingot_of_the_sky.preInit("Sky", FluidRegistry.getFluid("molten_of_the_sky"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(ingot_of_the_sky, 1f);
            }
            Materials.mats.add(ingot_of_the_sky.getMat());
        }
        if (Config.infused_iron) {
            infused_iron.setFluid(FluidRegistry.getFluid("infused_iron"));
            infused_iron.addCommonItems("InfusedIron");
            infused_iron.addIngot(ModItems.INFUSED_IRON);
            infused_iron.addBlock(ModBlocks.INFUSED_IRON);
            infused_iron.preInit("InfusedIron", FluidRegistry.getFluid("infused_iron"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(infused_iron, 0);
            }
            Materials.mats.add(infused_iron.getMat());
        }
        if (Config.ancient_wood) {
            // ancient_wood.addCommonItems("plankAncient");
            ancient_wood.addIngot(new ItemStack(ModBlocks.ANCIENT_PLANKS, 1));
            ancient_wood.preInit("plankAncient");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(ancient_wood, 0);
            }
            Materials.mats.add(ancient_wood.getMat());
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        OreDictionary.registerOre("ingotInfusedIron", ModItems.INFUSED_IRON);
        OreDictionary.registerOre("blockInfusedIron", ModBlocks.INFUSED_IRON);

        OreDictionary.registerOre("plankAncient", ModBlocks.ANCIENT_PLANKS);
        OreDictionary.registerOre("logAncient", ModBlocks.ANCIENT_LOG);
        
        OreDictionary.registerOre("ingotSky", ModItems.SKY_INGOT);

    }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}
