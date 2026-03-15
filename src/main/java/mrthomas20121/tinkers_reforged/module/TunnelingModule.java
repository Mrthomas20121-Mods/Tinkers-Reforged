package mrthomas20121.tinkers_reforged.module;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedContext;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.definition.module.build.ToolStatsHook;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import java.util.List;

public record TunnelingModule(LevelingInt consumed) implements ModifierModule, ToolStatsModifierHook, BreakSpeedModifierHook, MeleeHitModifierHook, TooltipModifierHook {

    public static final RecordLoadable<TunnelingModule> LOADER = RecordLoadable.create(
            LevelingInt.LOADABLE.requiredField("consumed", TunnelingModule::consumed),
            TunnelingModule::new);

    public static ResourceLocation KEY = TinkersReforged.getResource("extra_mining_speed");

    private static final List<ModuleHook<?>> DEFAULT_HOOKS = HookProvider.defaultHooks(ModifierHooks.TOOL_STATS, ModifierHooks.BREAK_SPEED, ModifierHooks.MELEE_HIT, ModifierHooks.TOOLTIP);

    @Override
    public RecordLoadable<? extends ModifierModule> getLoader() {
        return LOADER;
    }

    @Override
    public void onBreakSpeed(IToolStackView tool, ModifierEntry modifier, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {

    }

    @Override
    public float modifyBreakSpeed(IToolStackView tool, ModifierEntry modifier, BreakSpeedContext context, float speed) {
        if(tool.getPersistentData().contains(KEY)) {
            float amount = tool.getPersistentData().getFloat(KEY);
            if(speed > 0 && amount >= 1000) {
                float level = modifier.getEffectiveLevel();
                int target = this.consumed.compute(level);
                return speed+target;
            }
        }
        return speed;
    }

    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {

        if(tool.getPersistentData().contains(KEY)) {
            float amount = tool.getPersistentData().getFloat(KEY);
            if(damage > 0 && amount >= 1000) {
                float level = modifier.getEffectiveLevel();
                int target = this.consumed.compute(level);
                return damage+target;
            }
        }

        return damage;
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {

        if(tool.getPersistentData().contains(KEY)) {
            float amount = tool.getPersistentData().getFloat(KEY);
            if(damageDealt > 0 && amount < 1000) {
                tool.getPersistentData().putFloat(KEY, amount+damageDealt);
            }
        }
        else {
            tool.getPersistentData().putFloat(KEY, damageDealt);
        }
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }

    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        float level = modifier.getEffectiveLevel();
        if (tooltipKey == TooltipKey.SHIFT) {
            if(tool.getPersistentData().contains(KEY)) {
                if(tool.getPersistentData().getFloat(KEY) >= 1000) {
                    int target = this.consumed.compute(level);
                    TooltipModifierHook.addStatBoost(tool, modifier.getModifier(), ToolStats.MINING_SPEED, TinkerTags.Items.HARVEST, target, tooltip);
                }
            }
        }
    }

    @Override
    public void addToolStats(IToolContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        ToolStats.MINING_SPEED.add(builder, 1f);
    }
}
