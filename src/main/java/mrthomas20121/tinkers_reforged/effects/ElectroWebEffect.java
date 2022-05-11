package mrthomas20121.tinkers_reforged.effects;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.tools.modifiers.effect.NoMilkEffect;

import javax.annotation.Nonnull;

public class ElectroWebEffect extends NoMilkEffect {

    public ElectroWebEffect() {
        super(MobEffectCategory.HARMFUL, 0xE0B475, true);
    }

    @Override
    public boolean isDurationEffectTick(int tick, int level) {
        return tick > 0 && tick % 20 == 0;
    }

    @Override
    public void applyEffectTick(@Nonnull LivingEntity target, int level) {
        if(target.getHealth() > 1.0f) {
            if(!target.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600));
            }
            target.hurt(DamageSource.ANVIL.setScalesWithDifficulty(), 0.9F*(level+1));

            if (target.level instanceof ServerLevel) {
                ((ServerLevel)target.level).sendParticles(ParticleTypes.ELECTRIC_SPARK, target.getX(), target.getY(0.5), target.getZ(), 1, 0.1, 0, 0.1, 0.2);
            }
        }
    }
}
