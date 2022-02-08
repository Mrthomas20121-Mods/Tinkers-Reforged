package mrthomas20121.tinkers_reforged.trait.aluminum;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;

public class TraitMetalic extends Modifier {

    public TraitMetalic() {
        super(0xD6E1E4);
    }

    @Override
    public void addToolStats(@Nonnull ToolRebuildContext context, int level, @Nonnull ModifierStatsBuilder builder) {
        ToolStats.DURABILITY.multiply(builder, 0.3f);
        ToolStats.ATTACK_DAMAGE.multiply(builder, 1.5f);
        ToolStats.MINING_SPEED.multiply(builder, 1.5f);
    }
}
