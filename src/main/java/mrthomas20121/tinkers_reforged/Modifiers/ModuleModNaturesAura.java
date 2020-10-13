package mrthomas20121.tinkers_reforged.modifiers;

import mrthomas20121.biolib.common.ModifierModuleBase;
import de.ellpeck.naturesaura.items.ModItems;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import slimeknights.mantle.util.RecipeMatch;

public class ModuleModNaturesAura implements ModifierModuleBase {

    private TokenMod tokenMod = new TokenMod();
    @Override
    public void init() {
        tokenMod.addRecipeMatch(new RecipeMatch.ItemCombination(1, new ItemStack(ModItems.TOKEN_EUPHORIA), new ItemStack(ModItems.TOKEN_TERROR), new ItemStack(ModItems.TOKEN_RAGE), new ItemStack(ModItems.TOKEN_GRIEF)));
        TinkersReforged.proxy.registerModifierModel(tokenMod,
                new ResourceLocation(TinkersReforged.MODID, "models/item/modifiers/" + tokenMod.getIdentifier()));
    }

    public TokenMod getTokenMod() {
        return tokenMod;
    }
}
