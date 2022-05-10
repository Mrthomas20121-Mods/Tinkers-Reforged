package mrthomas20121.tinkers_reforged.trait;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;

public class TraitMagicalShrink extends Modifier {

    @Override
    public void addToolStats(@Nonnull ToolRebuildContext context, int level, @Nonnull ModifierStatsBuilder builder) {
        ToolStats.ATTACK_DAMAGE.multiply(builder, 0.6d/level);
        ToolStats.ATTACK_SPEED.multiply(builder, 1.99d*level);
    }
}
