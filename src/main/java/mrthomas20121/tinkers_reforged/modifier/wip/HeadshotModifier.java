package mrthomas20121.tinkers_reforged.modifier.wip;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class HeadshotModifier extends Modifier {

    @Override
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {

        if(context.getLivingTarget() != null) {
            LivingEntity target = context.getLivingTarget();

            if(target.getArmorValue() > 0) {
                return super.getEntityDamage(tool, level, context, baseDamage, damage)+target.getArmorValue()*0.9f;
            }
        }

        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
