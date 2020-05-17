package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;
import de.ellpeck.naturesaura.items.ModItems;
import de.ellpeck.naturesaura.blocks.ModBlocks;
import net.minecraftforge.oredict.OreDictionary;

public class ModuleNatureAura extends ModuleBase {

    public RegistryLib infused_iron = new RegistryLib(Materials.infused_iron);
    public RegistryLib ancient_wood = new RegistryLib(Materials.ancient_wood);
    public RegistryLib ingot_of_the_sky = new RegistryLib(Materials.ingot_of_the_sky);

    public ModuleNatureAura() {
        ingot_of_the_sky.setCraftable(false).setCastable(true);
        ingot_of_the_sky.registerMaterialTrait(Traits.AURA_INFUSION, MaterialTypes.HEAD);
        ingot_of_the_sky.registerMaterialTrait(TinkerTraits.alien);
        ingot_of_the_sky.registerHeadStats(230, 6.3f, 4f, HarvestLevels.OBSIDIAN);
        ingot_of_the_sky.registerHandleStats(1f, 90);
        ingot_of_the_sky.registerExtraStats(75);
        ingot_of_the_sky.registerBowStats(1.0f, 1.7f, 3.5f);

        infused_iron.setCraftable(false).setCastable(true);
        infused_iron.registerMaterialTrait(Traits.AURA_INFUSION, MaterialTypes.HEAD);
        infused_iron.registerMaterialTrait(TinkerTraits.magnetic2);
        infused_iron.registerHeadStats(200, 6.3f, 4f, HarvestLevels.DIAMOND);
        infused_iron.registerHandleStats(0.9f, 90);
        infused_iron.registerExtraStats(70);
        infused_iron.registerBowStats(2, 1.5f, 7);

        ancient_wood.setCraftable(true).setCastable(false);
        ancient_wood.registerMaterialTrait(TinkerTraits.ecological);
        ancient_wood.registerHeadStats(100, 2.3f, 1.2f, HarvestLevels.STONE);
        ancient_wood.registerHandleStats(1.9f, 10);
        ancient_wood.registerExtraStats(-10);
        ancient_wood.registerBowStats(0.9f, 1.0f, 1);
        ancient_wood.registerFletchingStats(0.1f, 0.5f);


    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        if(Config.ingot_of_the_sky) {
            ingot_of_the_sky.setFluid(ModuleFluids.molten_of_the_sky);
            //ingot_of_the_sky.addCommonItems("Sky");
            ingot_of_the_sky.addIngotItem(ModItems.SKY_INGOT);
            ingot_of_the_sky.registerPreInit("Sky",ModuleFluids.molten_of_the_sky);
            Materials.mats.add(ingot_of_the_sky.getMat());
        }

        if(Config.infused_iron) {
            infused_iron.setFluid(ModuleFluids.infused_iron);
            infused_iron.addCommonItems("InfusedIron");
            infused_iron.addIngotItem(ModItems.INFUSED_IRON);
            infused_iron.addBlockItem(ModBlocks.INFUSED_IRON);
            infused_iron.registerPreInit("InfusedIron", ModuleFluids.infused_iron);
            Materials.mats.add(infused_iron.getMat());
        }

        if(Config.ancient_wood) {
            //ancient_wood.addCommonItems("plankAncient");
            ancient_wood.addPlankItem(ModBlocks.ANCIENT_PLANKS);
            ancient_wood.registerPreInit("plankAncient");
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
