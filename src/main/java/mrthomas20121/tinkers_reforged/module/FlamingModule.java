package mrthomas20121.tinkers_reforged.module;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ToolDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public record FlamingModule(LevelingInt consumed) implements ModifierModule, ToolDamageModifierHook {

    public static final RecordLoadable<FlamingModule> LOADER = RecordLoadable.create(
            LevelingInt.LOADABLE.requiredField("consumed", FlamingModule::consumed),
            FlamingModule::new);

    private static final List<ModuleHook<?>> DEFAULT_HOOKS = HookProvider.defaultHooks(ModifierHooks.TOOL_DAMAGE);

    @Override
    public RecordLoadable<? extends ModifierModule> getLoader() {
        return LOADER;
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }

    @Override
    public int onDamageTool(IToolStackView tool, ModifierEntry modifier, int amount, @Nullable LivingEntity holder) {
        return 0;
    }

    @Override
    public int onDamageTool(IToolStackView tool, ModifierEntry modifier, int amount, @Nullable LivingEntity holder, @Nullable ItemStack stack) {
        if(holder != null) {
            if(holder.isOnFire() && amount > 1) {
                int value = consumed.compute(modifier.getEffectiveLevel());
                if(amount >= value) {
                    return amount-value;
                }
            }
        }
        return amount;
    }
}
