package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;
import de.ellpeck.naturesaura.items.ModItems;
import de.ellpeck.naturesaura.blocks.ModBlocks;
import net.minecraftforge.oredict.OreDictionary;

public class ModuleNatureAura extends ModuleBase {

    public RegistryLib infused_iron = new RegistryLib(Materials.infused_iron);
    public ModuleNatureAura() {
        Materials.mats.add(Materials.infused_iron);
        infused_iron.setCastable(false);
        infused_iron.setCastable(true);
        infused_iron.registerMaterialTrait(Traits.AURA_INFUSION, MaterialTypes.HEAD);
        infused_iron.registerMaterialTrait(TinkerTraits.magnetic2);
        infused_iron.registerHeadStats(200, 6.3f, 4f, HarvestLevels.IRON);
        infused_iron.registerHandleStats(0.9f, 90);
        infused_iron.registerExtraStats(70);
        infused_iron.registerBowStats(1.0f, 1.5f, 3);
    }

    public static ItemStack stack(Block block) {
        return new ItemStack(block, 1);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        if(Config.infused_iron) {

            // compat to make it work
            OreDictionary.registerOre("ingotInfusedIron", ModItems.INFUSED_IRON);
            OreDictionary.registerOre("blockInfusedIron", ModBlocks.INFUSED_IRON);
            FluidRegistry.registerFluid(ModuleFluids.infused_iron);
            FluidRegistry.addBucketForFluid(ModuleFluids.infused_iron);
            infused_iron.setFluid(ModuleFluids.infused_iron);
            infused_iron.addCommonItems("InfusedIron");
            infused_iron.registerPreInit("InfusedIron", ModuleFluids.infused_iron);
        }

        if(Config.ancient_wood) {
            // compat to make it work
            OreDictionary.registerOre("plankAncient", ModBlocks.ANCIENT_PLANKS);
            OreDictionary.registerOre("logAncient", ModBlocks.ANCIENT_LOG);

            TinkerRegistry.addMaterialStats(Materials.ancient_wood,
                    new HeadMaterialStats(50, 2.3f, 1.2f, HarvestLevels.STONE),
                    new HandleMaterialStats(1.9f, 50),
                    new ExtraMaterialStats(-10),
                    new FletchingMaterialStats(0.1f, 0.5f));

            Materials.ancient_wood.addItem(stack(ModBlocks.ANCIENT_PLANKS),1,  Material.VALUE_Ingot);
            Materials.ancient_wood.addItem(stack(ModBlocks.ANCIENT_LOG),1, Material.VALUE_Ingot* 4);
            Materials.ancient_wood.addItem(ModBlocks.ANCIENT_SLAB, Material.VALUE_Ingot/2);
            Materials.ancient_wood.setCraftable(true).setCastable(false);
            Materials.ancient_wood.addTrait(TinkerTraits.ecological);
            MaterialIntegration ancient_wood_mi = new MaterialIntegration(Materials.ancient_wood).setRepresentativeItem("plankAncient");
            TinkerRegistry.integrate(ancient_wood_mi).preInit();
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        this.registerDefaultMelting("InfusedIron", ModuleFluids.infused_iron);
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}
