package mrthomas20121.tinkers_reforged.util;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.modifiers.ModifierHook;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.function.Function;

public class TinkersReforgedHooks {

    public static ModifierHook<EntityLootModifierHook> ENTITY_LOOT_MODIFIER = register("entity_loot_modifier", EntityLootModifierHook.class, EntityLootModifierHook.SUM_MERGER, EntityLootModifierHook.DEFAULT);


    /** Registers a new modifier hook under {@code tinkers_reforged} */
    private static <T> ModifierHook<T> register(String name, Class<T> filter, @Nullable Function<Collection<T>,T> merger, T defaultInstance) {
        return ModifierHooks.register(new ResourceLocation(TinkersReforged.MOD_ID, name), filter, defaultInstance, merger);
    }

    /** Registers a new modifier hook under {@code tinkers_reforged}  that cannot merge */
    private static <T> ModifierHook<T> register(String name, Class<T> filter, T defaultInstance) {
        return register(name, filter, null, defaultInstance);
    }
}
