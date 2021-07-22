package mrthomas20121.tinkers_reforged.library;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.List;

public abstract class ModuleBase implements IModule {

    private final ResourceLocation registryName;

    public ModuleBase(ResourceLocation registryName) {
        this.registryName = registryName;
    }

    @Override
    public ResourceLocation getRegistryName() {
        return registryName;
    }

    @Override
    public void registerAlloys(List<String> alloys) { }

    @Override
    public void earlyPreInit() { }

    @Override
    public void preInit() { }

    @Override
    public void init() { }

    @Override
    public void postInit() { }

    @Override
    public void registerModifiers(List<Modifier> modifiers) { }

    @Override
    public void registerRecipes(IForgeRegistry<IRecipe> r) { }
}
