package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.effect.MobEffectInstance;
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
            float dmg = attacker.getActiveEffects().size();
            for(MobEffectInstance instance : attacker.getActiveEffects()) {
                dmg = dmg+0.15f*instance.getAmplifier();
            }
            return damage+dmg;
        }

        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
