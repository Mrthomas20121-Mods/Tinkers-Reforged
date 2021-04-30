package mrthomas20121.tinkers_reforged.compat;

import net.minecraft.item.ItemStack;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeManaInfusion;

public class BotaniaCompat {

    public static void addManaInfusionRecipe(ItemStack output, ItemStack input, int cost) {
        BotaniaAPI.manaInfusionRecipes.add(new RecipeManaInfusion(output, input, cost));

    }
}
