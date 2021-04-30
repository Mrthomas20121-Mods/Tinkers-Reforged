package mrthomas20121.tinkers_reforged.compat;

import de.ellpeck.naturesaura.api.NaturesAuraAPI;
import de.ellpeck.naturesaura.api.recipes.AltarRecipe;
import de.ellpeck.naturesaura.api.recipes.OfferingRecipe;
import mrthomas20121.tinkers_reforged.Reference;
import mrthomas20121.tinkers_reforged.config.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.library.ForgeUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class NaturesAuraCompat {

    public static void addAltarRecipe(ResourceLocation name, ItemStack input, ItemStack output) {
        NaturesAuraAPI.ALTAR_RECIPES.put(name, new AltarRecipe(name, Ingredient.fromStacks(input), output, Ingredient.EMPTY, TinkersReforgedConfig.SettingGeneral.mods.infusedIron.aura_cost, TinkersReforgedConfig.SettingGeneral.mods.infusedIron.time));
    }
    public static void addOfferingRecipe(ResourceLocation name, ItemStack input, ItemStack output) {
        NaturesAuraAPI.OFFERING_RECIPES.put(name, new OfferingRecipe(name, Ingredient.fromStacks(input), Ingredient.fromItem(ForgeUtils.getItem(Reference.naturesaura, "calling_spirit")), output));
    }
}
