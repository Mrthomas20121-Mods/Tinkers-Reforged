package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;
import de.ellpeck.naturesaura.items.ModItems;
import de.ellpeck.naturesaura.blocks.ModBlocks;
import net.minecraftforge.oredict.OreDictionary;

public class ModuleNatureAura extends ModuleBase {

    public ModuleNatureAura() {
        Materials.mats.add(Materials.infused_iron);
    }
    public static ItemStack stack(Item item) {
        return new ItemStack(item, 1);
    }
    public static ItemStack stack(Block block) {
        return new ItemStack(block, 1);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        if(Config.infused_iron) {
            TinkerRegistry.addMaterialStats(Materials.infused_iron,
                    new HeadMaterialStats(220, 6.3f, 3.8f, HarvestLevels.IRON),
                    new HandleMaterialStats(0.9f, 90),
                    new ExtraMaterialStats(70),
                    new BowMaterialStats(1.0f, 1.5f, 3.0f));

            Materials.infused_iron.setRepresentativeItem(ModBlocks.INFUSED_IRON);
            Materials.infused_iron.addItem(ModItems.INFUSED_IRON, 1, Material.VALUE_Ingot);
            Materials.infused_iron.addItem(ModBlocks.INFUSED_IRON, Material.VALUE_Block);
            Materials.infused_iron.setCraftable(true).setCastable(false);
            Materials.infused_iron.addTrait(Traits.infusing, MaterialTypes.HEAD);
            Materials.infused_iron.addTrait(TinkerTraits.magnetic2, MaterialTypes.HEAD);
            Materials.infused_iron.addTrait(TinkerTraits.magnetic);
            MaterialIntegration infused_iron_mi = new MaterialIntegration(Materials.infused_iron);
            TinkerRegistry.integrate(infused_iron_mi).preInit();
        }

        if(Config.ancient_wood) {
            TinkerRegistry.addMaterialStats(Materials.ancient_wood,
                    new HeadMaterialStats(50, 2.3f, 1.2f, HarvestLevels.STONE),
                    new HandleMaterialStats(1.9f, 50),
                    new ExtraMaterialStats(-10),
                    new FletchingMaterialStats(0.1f, 0.5f));

            Materials.ancient_wood.setRepresentativeItem(stack(ModBlocks.ANCIENT_PLANKS));
            Materials.ancient_wood.addItem(stack(ModBlocks.ANCIENT_PLANKS),1,  Material.VALUE_Ingot);
            Materials.ancient_wood.addItem(stack(ModBlocks.ANCIENT_LOG),1, Material.VALUE_Ingot* 4);
            Materials.ancient_wood.addItem(ModBlocks.ANCIENT_SLAB, Material.VALUE_Ingot/2);
            Materials.ancient_wood.setCraftable(true).setCastable(false);
            Materials.ancient_wood.addTrait(TinkerTraits.ecological);
            Materials.ancient_wood.addTrait(Traits.infusing,  MaterialTypes.HEAD);
            MaterialIntegration ancient_wood_mi = new MaterialIntegration(Materials.ancient_wood);
            TinkerRegistry.integrate(ancient_wood_mi).preInit();
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}
