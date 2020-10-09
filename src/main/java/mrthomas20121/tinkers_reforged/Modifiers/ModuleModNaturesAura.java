package mrthomas20121.tinkers_reforged.modifiers;

import mrthomas20121.biolib.common.ModifierModuleBase;
import de.ellpeck.naturesaura.items.ModItems;
import net.minecraft.item.ItemStack;
import slimeknights.mantle.util.RecipeMatch;

public class ModuleModNaturesAura implements ModifierModuleBase {

    private TokenMod tokenMod = new TokenMod();
    @Override
    public void init() {
        tokenMod.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(ModItems.TOKEN_EUPHORIA), new ItemStack(ModItems.TOKEN_TERROR), new ItemStack(ModItems.TOKEN_RAGE), new ItemStack(ModItems.TOKEN_GRIEF)));
    }

    public TokenMod getTokenMod() {
        return tokenMod;
    }
}
