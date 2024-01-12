package mrthomas20121.tinkers_reforged.modifier.wip;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class OverheatedModifier extends Modifier {

    @Override
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        float bonusDamage = 0;

        if(context.getLivingTarget() != null) {
            LivingEntity target = context.getLivingTarget();
            if(target.isOnFire() || target.fireImmune()) {
                bonusDamage = 1.5f*level;
            }
        }

        return super.getEntityDamage(tool, level, context, baseDamage, damage)+bonusDamage;
    }
}
