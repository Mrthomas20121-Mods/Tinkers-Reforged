package mrthomas20121.tinkers_reforged.module;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public record TriadModule(LevelingInt consumed) implements ModifierModule, MeleeDamageModifierHook {

    public static final RecordLoadable<TriadModule> LOADER = RecordLoadable.create(
            LevelingInt.LOADABLE.requiredField("consumed", TriadModule::consumed),
            TriadModule::new);

    private static final List<ModuleHook<?>> DEFAULT_HOOKS = HookProvider.defaultHooks(ModifierHooks.MELEE_DAMAGE);

    @Override
    public RecordLoadable<? extends ModifierModule> getLoader() {
        return LOADER;
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {

        if(context.getLivingTarget() != null) {
            // get extra damage from modifiers
            float bonusDamage = damage-baseDamage;
            LivingEntity entity = context.getLivingTarget();
            float level = modifier.getEffectiveLevel();
            int target = this.consumed.compute(level);
            float dmg = target+entity.getMaxHealth();
            return (0.2f*dmg)+bonusDamage;
        }

        return damage;
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }
}
