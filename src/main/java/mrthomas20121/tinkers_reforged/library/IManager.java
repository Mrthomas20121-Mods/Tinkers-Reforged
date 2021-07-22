package mrthomas20121.tinkers_reforged.library;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.LinkedList;

public abstract class IManager<T> {

    protected final LinkedList<T> value = new LinkedList<>();
    private final ResourceLocation registryName;

    public IManager(ResourceLocation registryName) {
        this.registryName = registryName;
    }

    public IManager(String registryName) {
        this(new ResourceLocation(registryName));
    }

    public ResourceLocation getRegistryName() {
        return registryName;
    }

    public abstract boolean isLoaded(T value);

    public abstract void add(T value);

    public abstract T get(int i);

    public abstract void earlyPreInit();

    public abstract void preInit();

    public abstract void init();

    public abstract void postInit();

    public abstract void registerBlocks(RegistryEvent.Register<Block> event);
    public abstract void registerItems(RegistryEvent.Register<Item> event);
    public abstract void registerRecipes(IForgeRegistry<IRecipe> r);
}
