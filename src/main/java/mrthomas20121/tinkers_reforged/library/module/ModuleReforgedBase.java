package mrthomas20121.tinkers_reforged.library.module;

import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public abstract class ModuleReforgedBase {

    public abstract void preInit();

    public abstract void init();

    public void postInit() {

    }

    public abstract boolean canLoad();

    public void registerItems(IForgeRegistry<Item> r) {

    }

    public void registerRecipes(IForgeRegistry<IRecipe> r) {

    }

    public void registerModels() {

    }
}
