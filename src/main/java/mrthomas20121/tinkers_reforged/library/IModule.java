package mrthomas20121.tinkers_reforged.library;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.List;

public interface IModule {

    ResourceLocation getRegistryName();

    void registerAlloys(List<String> alloys);

    void registerModifiers(List<Modifier> modifiers);

    void registerRecipes(IForgeRegistry<IRecipe> r);

    void earlyPreInit();

    void preInit();

    void init();

    void postInit();

    boolean canLoad();
}
