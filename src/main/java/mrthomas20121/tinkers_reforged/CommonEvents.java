package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedPotions;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TinkersReforged.MOD_ID)
public class CommonEvents {

    @SubscribeEvent
    public static void deathEvent(LivingDeathEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();
        if(livingEntity.hasEffect(TinkersReforgedPotions.FUNGAL.get())) {
            int amplifier = livingEntity.getEffect(TinkersReforgedPotions.FUNGAL.get()).getAmplifier();
            List<? extends LivingEntity> entities = livingEntity.level.getNearbyEntities(livingEntity.getClass(), TargetingConditions.forCombat().range(10+0.1f*amplifier).ignoreLineOfSight(), livingEntity, new AABB(livingEntity.blockPosition(), livingEntity.blockPosition().offset(5, 5, 5)));
            entities.forEach(entity -> entity.hurt(DamageSource.indirectMobAttack(livingEntity, null), 10+0.1f*amplifier));
        }
    }
}
