package mrthomas20121.tinkers_reforged.effect;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.tools.modifiers.effect.NoMilkEffect;

import javax.annotation.Nonnull;

public class EffectFungal extends NoMilkEffect {

    public EffectFungal() {
        super(MobEffectCategory.HARMFUL, 0xC53439, true);
    }

    @Override
    public boolean isDurationEffectTick(int tick, int level) {
        return tick > 0 && tick % 20 == 0;
    }

    @Override
    public void applyEffectTick(@Nonnull LivingEntity target, int level) {
        if (target.level instanceof ServerLevel) {
            addParticlesAroundSelf(ParticleTypes.ASH, target);
            addParticlesAroundSelf(ParticleTypes.SPORE_BLOSSOM_AIR, target);
            addParticlesAroundSelf(ParticleTypes.CRIMSON_SPORE, target);
            addParticlesAroundSelf(ParticleTypes.WARPED_SPORE, target);
        }
    }

    protected void addParticlesAroundSelf(ParticleOptions particle, LivingEntity target) {
        for(int i = 0; i < 5; ++i) {
            double d0 = target.getRandom().nextGaussian() * 0.02D;
            double d1 = target.getRandom().nextGaussian() * 0.02D;
            double d2 = target.getRandom().nextGaussian() * 0.02D;
            ((ServerLevel) target.level).sendParticles(particle, target.getRandomX(1.0d), target.getRandomY(), target.getRandomZ(1.0D), 1, d0, d1, d2, 0.0D);
        }
    }
}