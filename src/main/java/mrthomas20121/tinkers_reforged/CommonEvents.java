package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedPotions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TinkersReforged.MOD_ID)
public class CommonEvents {

    // add potion
    @SubscribeEvent
    public static void deathEvent(LivingDeathEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();
        if(livingEntity.hasEffect(TinkersReforgedPotions.Fungal.get())) {
            List<? extends LivingEntity> entities = livingEntity.level.getNearbyEntities(livingEntity.getClass(), TargetingConditions.forNonCombat(), livingEntity, new AABB(livingEntity.blockPosition().below(), livingEntity.blockPosition().south(5).above(5).below(5).east(5).north(5).west(5)));
            entities.forEach(entity -> entity.addEffect(new MobEffectInstance(TinkersReforgedPotions.Fungal.get(), 150, 0)));
        }
    }
}
