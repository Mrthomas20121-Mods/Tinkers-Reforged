package mrthomas20121.tinkers_reforged.modifier.wip;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class GiganticModifier extends Modifier {

    private float calcBonusDamage(float targetMaxHealth, float playerHealth) {
        if(targetMaxHealth > playerHealth) {
            return targetMaxHealth-playerHealth*0.02f;
        }
        return 0;
    }

    @Override
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        if(context.getLivingTarget() != null) {
            return super.getEntityDamage(tool, level, context, baseDamage, damage)+calcBonusDamage(context.getLivingTarget().getMaxHealth(), context.getAttacker().getMaxHealth());
        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
