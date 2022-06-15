package mrthomas20121.tinkers_reforged.effect;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
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
            target.hurt(DamageSource.ANVIL.setScalesWithDifficulty(), 0.9F*(level+1));

            if (target.level instanceof ServerLevel) {
                addParticlesAroundSelf(ParticleTypes.ELECTRIC_SPARK, target);
            }
        }
    }

    protected void addParticlesAroundSelf(ParticleOptions particle, LivingEntity target) {
        for(int i = 0; i < 5; ++i) {
            double d0 = target.getRandom().nextGaussian() * 0.02D;
            double d1 = target.getRandom().nextGaussian() * 0.02D;
            double d2 = target.getRandom().nextGaussian() * 0.02D;
            ((ServerLevel) target.level).sendParticles(particle, target.getRandomX(1.0D), target.getRandomY(), target.getRandomZ(1.0D), 1, d0, d1, d2, 0.0D);
        }
    }
}
