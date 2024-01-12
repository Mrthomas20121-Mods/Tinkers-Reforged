package mrthomas20121.tinkers_reforged.modifier.wip;

import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class StillModifier extends Modifier {

    @Override
    public void addToolStats(ToolRebuildContext context, int level, @NotNull ModifierStatsBuilder builder) {
        ToolStats.MINING_SPEED.add(builder, 2);
        ToolStats.ATTACK_DAMAGE.add(builder, 2);
        ToolStats.ACCURACY.multiply(builder, 1.1f);
        ToolStats.ATTACK_SPEED.multiply(builder, 1.1f);
        ToolStats.DRAW_SPEED.multiply(builder, 1.1f);
        ToolStats.DURABILITY.multiply(builder, 1.5f);
    }
}
