package mrthomas20121.tinkers_reforged.modifier.wip;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class BurdensomeModifier extends Modifier {

    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {
        ToolStats.ATTACK_SPEED.multiply(builder, 0.5f);
    }

    @Override
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        if(context.getLivingTarget() != null) {
            return super.getEntityDamage(tool, level, context, baseDamage, damage)+context.getLivingTarget().getHealth()*0.01f;
        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
