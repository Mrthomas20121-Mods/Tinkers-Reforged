package mrthomas20121.tinkers_reforged.compat;

import hellfirepvp.astralsorcery.common.crafting.infusion.InfusionRecipeRegistry;
import hellfirepvp.astralsorcery.common.crafting.infusion.recipes.BasicInfusionRecipe;
import net.minecraft.item.ItemStack;

public class ASCompat {

    // move recipes to another class to not get errors when the mod is not loaded
    public static void addInfusionRecipe(ItemStack input1, ItemStack input2) {
        InfusionRecipeRegistry.recipes.add(new BasicInfusionRecipe(input1, input2));
    }
}
