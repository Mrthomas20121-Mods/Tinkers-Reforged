package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.OredictHelper;
import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.teammetallurgy.atum.init.AtumBlocks;
import com.teammetallurgy.atum.init.AtumItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

public class ModuleAtum extends ModuleBase {
    public RegistryLib limestone = new RegistryLib(Materials.limestone);
    public RegistryLib khnumite = new RegistryLib(Materials.khnumite);
    
    public ModuleAtum() {
        limestone.setCraftable(true).setCastable(false);
        limestone.registerMaterialTrait(TinkerTraits.cheapskate, MaterialTypes.HEAD);
        limestone.registerMaterialTrait(TinkerTraits.cheap);
        limestone.registerHeadStats(180, 3.1f, 2.2f, HarvestLevels.STONE);
        limestone.registerHandleStats(0.9f, 50);
        limestone.registerExtraStats(30);

        khnumite.setCraftable(true).setCastable(false);
        khnumite.registerMaterialTrait(TinkerTraits.jagged, MaterialTypes.HEAD);
        khnumite.registerMaterialTrait(TinkerTraits.poisonous);
        khnumite.registerHeadStats(200, 3.4f, 3.1f, HarvestLevels.IRON);
        khnumite.registerHandleStats(0.9f, 70);
        khnumite.registerExtraStats(50);
    }
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.limestone) {
            limestone.addIngotItem("stoneLimestone");
            limestone.preInit("stoneLimestone");
        }
        if(Config.khnumite) {
            khnumite.addIngotItem("ingotKhnumite");
            khnumite.preInit("Khnumite");
        }
    }
    public void init(FMLInitializationEvent e) { 
        OreDictionary.registerOre("clothLinen", AtumItems.LINEN_CLOTH);
    }

    public void postInit(FMLPostInitializationEvent e) {
        // compat to make limestone work
        OredictHelper.removeOredict(new ItemStack(AtumBlocks.LIMESTONE), "stone");
    }
}
