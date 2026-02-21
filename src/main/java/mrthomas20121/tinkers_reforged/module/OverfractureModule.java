package mrthomas20121.tinkers_reforged.module;

import net.minecraft.core.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedContext;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.modifiers.modules.capacity.OverslimeModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public record OverfractureModule(LevelingInt consumed) implements ModifierModule, BreakSpeedModifierHook {

    private static final List<ModuleHook<?>> DEFAULT_HOOKS = HookProvider.defaultHooks(ModifierHooks.BREAK_SPEED);

    public static final RecordLoadable<OverfractureModule> LOADER = RecordLoadable.create(
            LevelingInt.LOADABLE.requiredField("consumed", OverfractureModule::consumed),
            OverfractureModule::new);

    @Override
    public RecordLoadable<? extends ModifierModule> getLoader() {
        return LOADER;
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }

    @Override
    public void onBreakSpeed(IToolStackView tool, ModifierEntry modifier, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {

    }

    @Override
    public float modifyBreakSpeed(IToolStackView tool, ModifierEntry modifier, BreakSpeedContext context, float speed) {

        if(!context.isEffective()) {
            int overslime = OverslimeModule.INSTANCE.getAmount(tool);
            if(overslime > 0) {
                float level = modifier.getEffectiveLevel();
                int target = this.consumed.compute(level);
                int consumed = Math.min(overslime, target);
                speed+=target;
                OverslimeModule.INSTANCE.removeAmount(tool, consumed);
            }
        }

        return speed;
    }
}
