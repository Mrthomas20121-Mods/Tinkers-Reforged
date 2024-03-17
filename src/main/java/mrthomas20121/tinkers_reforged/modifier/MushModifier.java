package mrthomas20121.tinkers_reforged.modifier;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ToolStatsModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class MushModifier extends Modifier implements ToolStatsModifierHook {

    public MushModifier() {
        this.registerHooks(ModifierHookMap.builder().addHook(this, TinkerHooks.TOOL_STATS));
    }

    @Override
    public void addToolStats(ToolRebuildContext context, ModifierEntry modifier, ModifierStatsBuilder builder) {
        ToolStats.MINING_SPEED.add(builder, 2);
        ToolStats.ATTACK_DAMAGE.add(builder, 2);
        ToolStats.ACCURACY.multiply(builder, 1.1f);
        ToolStats.ATTACK_SPEED.multiply(builder, 1.1f);
        ToolStats.DRAW_SPEED.multiply(builder, 1.1f);
        ToolStats.DURABILITY.multiply(builder, 0.5f);
    }
}
