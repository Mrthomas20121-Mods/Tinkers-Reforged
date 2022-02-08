package mrthomas20121.tinkers_reforged.trait.electrical_copper;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Random;

public class TraitElectricDamage extends Modifier {

    public TraitElectricDamage() {
        super(0xE0B475);
    }

    @Override
    public int afterEntityHit(@Nonnull IModifierToolStack tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {
        Random rand = context.getAttacker().getRandom();
        if(rand.nextInt(100) >= 50) {
            LivingEntity livingEntity = Objects.requireNonNull(context.getAttacker());
            DamageSource source = DamageSource.CACTUS;
            livingEntity.hurt(source.setScalesWithDifficulty(), rand.nextInt((int) (livingEntity.getHealth()/2)));
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
