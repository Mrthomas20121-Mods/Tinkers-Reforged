package mrthomas20121.tinkers_reforged.api.hook;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.module.ModuleHook;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.function.Function;

public class TinkersReforgedModifierHooks {

    public static ModuleHook<RightClickModifierHook> RIGHT_CLICK = register("right_click", RightClickModifierHook.class, RightClickModifierHook.AllMerger::new, new RightClickModifierHook() {});

    /** Registers a new modifier hook */
    public static <T> ModuleHook<T> register(ResourceLocation name, Class<T> filter, @Nullable Function<Collection<T>,T> merger, T defaultInstance) {
        return ModifierHooks.LOADER.register(new ModuleHook<>(name, filter, merger, defaultInstance));
    }

    /** Registers a new unmergable modifier hook */
    public static <T> ModuleHook<T> register(ResourceLocation name, Class<T> filter, T defaultInstance) {
        return register(name, filter, null, defaultInstance);
    }

    /** Registers a new modifier hook under {@code tconstruct} */
    private static <T> ModuleHook<T> register(String name, Class<T> filter, @Nullable Function<Collection<T>,T> merger, T defaultInstance) {
        return register(TinkersReforged.getResource(name), filter, merger, defaultInstance);
    }

    /** Registers a new modifier hook under {@code tconstruct}  that cannot merge */
    @SuppressWarnings("SameParameterValue")
    private static <T> ModuleHook<T> register(String name, Class<T> filter, T defaultInstance) {
        return register(name, filter, null, defaultInstance);
    }
}
