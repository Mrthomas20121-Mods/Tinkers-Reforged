package mrthomas20121.tinkers_reforged.module;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.LootingModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.context.LootingContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public record RoaringModule(LevelingInt consumed) implements ModifierModule, LootingModifierHook {

    public static final RecordLoadable<RoaringModule> LOADER = RecordLoadable.create(
            LevelingInt.LOADABLE.requiredField("consumed", RoaringModule::consumed),
            RoaringModule::new);

    private static final List<ModuleHook<?>> DEFAULT_HOOKS = HookProvider.defaultHooks(ModifierHooks.WEAPON_LOOTING);

    @Override
    public RecordLoadable<? extends ModifierModule> getLoader() {
        return LOADER;
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }

    @Override
    public int updateLooting(IToolStackView tool, ModifierEntry modifier, LootingContext context, int looting) {
        LivingEntity holder = context.getHolder();
        if(holder.isOnFire()) {
            if(looting > 0 && looting < 4) {
                return looting+consumed.compute(modifier.getEffectiveLevel());
            }
            else {
                return consumed.compute(modifier.getEffectiveLevel());
            }
        }
        return looting;
    }
}
