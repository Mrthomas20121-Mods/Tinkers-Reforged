package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class CollapsedModifier extends Modifier {

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity livingEntity = context.getAttacker();
        if(livingEntity.getHealth() < livingEntity.getMaxHealth()) {
            return damage*(damage*0.015f*level);
        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
