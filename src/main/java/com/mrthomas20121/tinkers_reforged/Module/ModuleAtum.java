package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import com.teammetallurgy.atum.Atum;
import com.teammetallurgy.atum.init.AtumBlocks;
import com.teammetallurgy.atum.init.AtumItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAtum extends ModuleBase {

    public ModuleAtum() {
        Materials.mats.add(Materials.limestone);
        Materials.mats.add(Materials.khnumite);
    }
    public void preInit(FMLPreInitializationEvent e) {

        OreDictionary.registerOre("clothLinen", AtumItems.LINEN_CLOTH);

        if(Config.limestone) {

            TinkerRegistry.addMaterialStats(Materials.limestone,
                    new HeadMaterialStats(180, 3.1f, 2.2f, HarvestLevels.STONE),
                    new HandleMaterialStats(0.9f, 50),
                    new ExtraMaterialStats(30));
            Materials.limestone.addItem("stoneLimestone", 1, Material.VALUE_Ingot);
            Materials.limestone.setCraftable(true).setCastable(false);
            Materials.limestone.addTrait(TinkerTraits.cheapskate, MaterialTypes.HEAD);
            Materials.limestone.addTrait(TinkerTraits.cheap);
            MaterialIntegration limestonemi = new MaterialIntegration(Materials.limestone).setRepresentativeItem("stoneLimestone");
            TinkerRegistry.integrate(limestonemi).preInit();
        }

        if(Config.khnumite) {
            TinkerRegistry.addMaterialStats(Materials.khnumite,
                    new HeadMaterialStats(200, 3.4f, 3.1f, HarvestLevels.IRON),
                    new HandleMaterialStats(0.9f, 70),
                    new ExtraMaterialStats(50));
            Materials.khnumite.addItem("ingotKhnumite", 1, Material.VALUE_Ingot);
            Materials.khnumite.setCraftable(true).setCastable(false);
            Materials.khnumite.addTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
            Materials.khnumite.addTrait(TinkerTraits.stonebound);
            MaterialIntegration khnumitemi = new MaterialIntegration(Materials.khnumite).setRepresentativeItem("ingotKhnumite");
            TinkerRegistry.integrate(khnumitemi).preInit();
        }
    }
    public void init(FMLInitializationEvent e) { }

    public void postInit(FMLPostInitializationEvent e) {
        // compat to make limestone work
        removeOredict(new ItemStack(AtumBlocks.LIMESTONE), "stone");
    }
    private ItemStack removeOredict(ItemStack item, String oredict) {
        ItemStack result = ItemStack.EMPTY;
        for (ItemStack itemstack : OreDictionary.getOres(oredict)) {

            if(itemstack.getItem().getRegistryName().equals(item.getItem().getRegistryName())) {
                result = itemstack;
            }
        }
        if(!result.isEmpty()) {
            OreDictionary.getOres(oredict, false).remove(result);
        }
        return result;
    }
}
