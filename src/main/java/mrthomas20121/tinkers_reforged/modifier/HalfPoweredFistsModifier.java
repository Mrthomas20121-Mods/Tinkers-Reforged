package mrthomas20121.tinkers_reforged.modifier;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;

public class HalfPoweredFistsModifier extends Modifier {

    public float bonusDmgCalculation(float currentDurability) {
        return currentDurability*0.01f;
    }

    @Override
    public void addToolStats(@Nonnull ToolRebuildContext context, int level, @Nonnull ModifierStatsBuilder builder) {
        builder.multiplier(ToolStats.ATTACK_DAMAGE, 0.5f);
    }

    @Override
    public int afterEntityHit(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {
        if(context.getLivingTarget() != null) {
            if(context.getLivingTarget().getLastDamageSource() != null) {
                context.getLivingTarget().hurt(context.getLivingTarget().getLastDamageSource(), damageDealt);
            }
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
