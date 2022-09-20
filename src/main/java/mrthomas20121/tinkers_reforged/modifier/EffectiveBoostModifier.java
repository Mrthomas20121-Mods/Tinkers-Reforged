package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class EffectiveBoostModifier extends Modifier {

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {

        LivingEntity attacker = context.getAttacker();
        if(!attacker.getActiveEffectsMap().isEmpty()) {
            return damage+attacker.getActiveEffects().size()*0.05f;
        }

        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
