package com.mrthomas20121.libs;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;

import static slimeknights.tconstruct.smeltery.TinkerSmeltery.*;

public class SmelteryUtils {
    public static void RegisterGemCasting(String ore, Fluid fluid) {
      ItemStack result = OredictHelper.getOre("gem"+ore);
      if(!result.equals(ItemStack.EMPTY)) {
        TinkerRegistry.registerTableCasting(result, castGem, fluid, Material.VALUE_Gem);
      }
    }
}