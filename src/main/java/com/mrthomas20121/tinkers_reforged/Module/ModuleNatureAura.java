package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
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

public class ModuleNatureAura extends ModuleBase {


    public ModuleNatureAura() {
        Materials.mats.add(Materials.infused_iron);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        if(Config.infused_iron) {
            TinkerRegistry.addMaterialStats(Materials.infused_iron,
                    new HeadMaterialStats(100, 6.3f, 4.2f, HarvestLevels.IRON),
                    new HandleMaterialStats(0.9f, 90),
                    new ExtraMaterialStats(70),
                    new BowMaterialStats(1.0f, 1.5f, 3.0f));

            ResourceLocation infused = new ResourceLocation("naturesaura:infused_iron");
            Item infusedIron = ForgeRegistries.ITEMS.getValue(infused);

            Materials.infused_iron.addItem(infusedIron, 1, Material.VALUE_Ingot);
            Materials.infused_iron.setCraftable(true).setCastable(false);
            Materials.infused_iron.addTrait(TinkerTraits.magnetic2, MaterialTypes.HEAD);
            Materials.infused_iron.addTrait(TinkerTraits.unnatural);
            MaterialIntegration infused_iron_mi = new MaterialIntegration(Materials.infused_iron).setRepresentativeItem("ingotInfusedIron");
            TinkerRegistry.integrate(infused_iron_mi).preInit();
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        if(Config.infused_iron) {
            ResourceLocation infused = new ResourceLocation("naturesaura:infused_iron");
            Item infusedIron = ForgeRegistries.ITEMS.getValue(infused);
            Materials.infused_iron.addItem(infusedIron, 1, Material.VALUE_Ingot);
        }
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }
    @Override
    public void clientPostInit() { }
}
