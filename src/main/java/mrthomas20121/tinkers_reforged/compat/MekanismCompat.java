package mrthomas20121.tinkers_reforged.compat;

import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.infuse.InfuseType;
import mekanism.common.recipe.RecipeHandler;
import net.minecraft.item.ItemStack;

public class MekanismCompat {

    public static void addInfusionRecipe(String infusion, int amount, ItemStack input, ItemStack output) {
        InfuseType type = InfuseRegistry.get(infusion);
        RecipeHandler.addMetallurgicInfuserRecipe(type, 10, input, output);
    }

    public static void addOsmiumCompressorRecipe(ItemStack input, ItemStack output) {
        RecipeHandler.addOsmiumCompressorRecipe(input, output);
    }
}
