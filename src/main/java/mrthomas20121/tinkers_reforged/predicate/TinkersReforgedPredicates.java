package mrthomas20121.tinkers_reforged.predicate;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;

public interface TinkersReforgedPredicates {

    /**
     * Predicate that match entity above the sea level
     */
    LivingEntityPredicate ABOVE_SEA_LEVEL = LivingEntityPredicate.simple(entity -> entity.getY() > entity.level().getSeaLevel());

    /**
     * Predicate that match entity not in the overworld
     */
    LivingEntityPredicate IS_NOT_IN_THE_OVERWORLD = LivingEntityPredicate.simple(livingEntity -> {
        ResourceKey<DimensionType> dimensionTypeResourceKey = livingEntity.level().dimensionTypeId();
        return !dimensionTypeResourceKey.equals(BuiltinDimensionTypes.OVERWORLD) || !dimensionTypeResourceKey.equals(BuiltinDimensionTypes.OVERWORLD_CAVES);
    });
}
