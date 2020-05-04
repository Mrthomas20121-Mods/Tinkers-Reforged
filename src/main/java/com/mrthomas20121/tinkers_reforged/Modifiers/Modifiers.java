package com.mrthomas20121.tinkers_reforged.Modifiers;

import c4.conarm.lib.utils.RecipeMatchHolder;
import com.teammetallurgy.atum.init.AtumItems;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;

public class Modifiers {

    public static ModCloth cloth = new ModCloth();

    public static void init(FMLInitializationEvent e) {
        if(Loader.isModLoaded("atum")) {
            RecipeMatchHolder.addItem(Modifiers.cloth, AtumItems.WANDERER_HELMET);
            //cloth.addItem("clothLinen", 5, 5);
            //cloth.addItem(AtumItems.LINEN_CLOTH, 5, 5);
            //TinkerRegistry.registerModifier(Modifiers.cloth);
        }
    }
}
