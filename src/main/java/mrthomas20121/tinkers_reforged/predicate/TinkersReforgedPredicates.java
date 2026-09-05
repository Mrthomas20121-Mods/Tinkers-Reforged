package mrthomas20121.tinkers_reforged.predicate;

import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;

public interface TinkersReforgedPredicates {

    /**
     * Predicate that match entity in a nether biome
     */
    LivingEntityPredicate IS_NETHER_BIOME = LivingEntityPredicate.simple(entity -> entity.level().getBiome(entity.blockPosition()).is(BiomeTags.IS_NETHER));

    /**
     * Predicate that match entity above the sea level
     */
    LivingEntityPredicate BELOW_ZERO = LivingEntityPredicate.simple(entity -> entity.getY() < 0f);

    /**
     * Predicate that match entity not at max health
     */
    LivingEntityPredicate NOT_MAX_HEALTH = LivingEntityPredicate.simple(entity -> entity.getHealth() < entity.getMaxHealth());

    /**
     * Predicate that match entity not in the overworld
     */
    LivingEntityPredicate IS_NOT_IN_THE_OVERWORLD = LivingEntityPredicate.simple(livingEntity -> {
        ResourceKey<DimensionType> dimensionTypeResourceKey = livingEntity.level().dimensionTypeId();
        return !dimensionTypeResourceKey.equals(BuiltinDimensionTypes.OVERWORLD) || !dimensionTypeResourceKey.equals(BuiltinDimensionTypes.OVERWORLD_CAVES);
    });
}
