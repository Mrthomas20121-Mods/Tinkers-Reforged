package mrthomas20121.tinkers_reforged.compat;

import epicsquid.roots.init.ModRecipes;
import epicsquid.roots.recipe.FeyCraftingRecipe;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.tinkering.MaterialItem;
import slimeknights.tconstruct.tools.TinkerMaterials;

public class RootsCompat {

    public static void addRunestoneFeyCrafting(String registry_name, ItemStack output, ItemStack input) {
        FeyCraftingRecipe recipe = new FeyCraftingRecipe(output);
        recipe.addIngredients(
                new ItemStack(Items.DYE, 1, 4),
               input,
                new ItemStack(Blocks.STONE, 1),
                new ItemStack(Blocks.STONE, 1),
                new ItemStack(Blocks.STONE, 1)
        );
        ModRecipes.addFeyCraftingRecipe(new ResourceLocation(TinkersReforged.MODID, registry_name), recipe);

    }
}
