package mrthomas20121.tinkers_reforged.modifier.wip;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class HellishRepairModifier extends Modifier {

    @Override
    public float beforeEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damage, float baseKnockback, float knockback) {
        if(context.getLivingTarget() != null) {
            if(context.getLivingTarget().isOnFire()) {
                ToolDamageUtil.repair(tool, 5+2*level);
            }
        }
        return super.beforeEntityHit(tool, level, context, damage, baseKnockback, knockback);
    }
}
