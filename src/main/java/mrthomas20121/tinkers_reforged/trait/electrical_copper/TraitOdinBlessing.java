package mrthomas20121.tinkers_reforged.trait.electrical_copper;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.stat.IToolStat;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;

import javax.annotation.Nonnull;
import java.util.Set;

public class TraitOdinBlessing extends Modifier {

    public TraitOdinBlessing() {
        super(0xE0B475);
    }

    @Override
    public void addToolStats(@Nonnull ToolRebuildContext context, int level, @Nonnull ModifierStatsBuilder builder) {
        Set<IToolStat<?>> stats = context.getStats().getContainedStats();
        stats.forEach(iToolStat -> {
            iToolStat.applyBonus(builder, 1.5f);
        });
        super.addToolStats(context, level, builder);
    }
}
