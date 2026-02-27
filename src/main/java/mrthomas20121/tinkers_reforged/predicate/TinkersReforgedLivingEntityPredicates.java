package mrthomas20121.tinkers_reforged.predicate;

import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;

public class TinkersReforgedLivingEntityPredicates {

    public static LivingEntityPredicate LivingEntityAboveSeaLevelPredicate = LivingEntityPredicate.simple(entity -> entity.getY() > entity.level().getSeaLevel());
}
