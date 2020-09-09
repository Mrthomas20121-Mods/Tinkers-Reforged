package mrthomas20121.tinkers_reforged.modules;

import mrthomas20121.biolib.common.MaterialBuilder;
import mrthomas20121.biolib.common.ModuleBase;
import mrthomas20121.biolib.util.armorUtils;
import mrthomas20121.tinkers_reforged.config.Config;
import mrthomas20121.tinkers_reforged.Traits.Traits;

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
        Resources.ingot_of_the_sky.builder.setTrait(Traits.AURA_INFUSION, MaterialTypes.HEAD);
        Resources.ingot_of_the_sky.builder.setTrait(TinkerTraits.alien);
        Resources.ingot_of_the_sky.builder.setHeadStats(230, 6.3f, 4f, HarvestLevels.OBSIDIAN);
        Resources.ingot_of_the_sky.builder.setHandleStats(1f, 90);
        Resources.ingot_of_the_sky.builder.setExtraStats(75);
        Resources.ingot_of_the_sky.builder.setBowStats(1.0f, 1.7f, 3.5f);

        Resources.infused_iron.builder.setTrait(Traits.AURA_INFUSION, MaterialTypes.HEAD);
        Resources.infused_iron.builder.setTrait(TinkerTraits.magnetic2);
        Resources.infused_iron.builder.setHeadStats(200, 6.3f, 4f, HarvestLevels.DIAMOND);
        Resources.infused_iron.builder.setHandleStats(0.9f, 90);
        Resources.infused_iron.builder.setExtraStats(70);
        Resources.infused_iron.builder.setBowStats(2, 1.5f, 7);

        Resources.ancient_wood.builder.setTrait(TinkerTraits.ecological);
        Resources.ancient_wood.builder.setHeadStats(100, 2.3f, 1.2f, HarvestLevels.STONE);
        Resources.ancient_wood.builder.setHandleStats(1.9f, 10);
        Resources.ancient_wood.builder.setExtraStats(-10);
        Resources.ancient_wood.builder.setBowStats(0.9f, 1.0f, 1);
        Resources.ancient_wood.builder.addFletchingStats(0.1f, 0.5f);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        Resources.ingot_of_the_sky.registerFluid();
        Resources.infused_iron.registerFluid();

        if(ConfigMaterials.material_of_the_sky) {
            Resources.ingot_of_the_sky.builder.addIngot(ModItems.SKY_INGOT);
            Resources.ingot_of_the_sky.builder.preInit("Sky", FluidRegistry.getFluid("molten_of_the_sky"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.ingot_of_the_sky.builder, 1f);
            }
            Resources.materials.add(Resources.ingot_of_the_sky);
        }
        if (ConfigMaterials.infused_iron) {
            Resources.infused_iron.builder.addCommonItems("InfusedIron");
            Resources.infused_iron.builder.addIngot(ModItems.INFUSED_IRON);
            Resources.infused_iron.builder.addBlock(ModBlocks.INFUSED_IRON);
            Resources.infused_iron.builder.preInit("InfusedIron", FluidRegistry.getFluid("infused_iron"));
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.infused_iron.builder, 0);
            }
            Resources.materials.add(Resources.infused_iron);
        }
        if (ConfigMaterials.ancient_wood) {
            // ancient_wood.addCommonItems("plankAncient");
            Resources.ancient_wood.builder.addIngot(new ItemStack(ModBlocks.ANCIENT_PLANKS, 1));
            Resources.ancient_wood.builder.preInit("plankAncient");
            if(Loader.isModLoaded("conarm"))
            {
                armorUtils.setArmorStats(Resources.ancient_wood.builder, 0);
            }
            Resources.materials.add(Resources.ancient_wood);
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
