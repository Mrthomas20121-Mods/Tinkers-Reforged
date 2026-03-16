package mrthomas20121.tinkers_reforged.predicate;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;

public interface TinkersReforgedPredicates {

    /**
     * Predicate that match entity above the sea level
     */
    LivingEntityPredicate ABOVE_SEA_LEVEL = LivingEntityPredicate.simple(entity -> entity.getY() > entity.level().getSeaLevel());
    /**
     * Predicate that match baby entities
     */
    LivingEntityPredicate BABY = LivingEntityPredicate.simple(LivingEntity::isBaby);
}
