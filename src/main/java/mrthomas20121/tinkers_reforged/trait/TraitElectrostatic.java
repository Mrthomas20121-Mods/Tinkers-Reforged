package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.Random;

public class TraitElectrostatic extends Modifier {

    public TraitElectrostatic() {
        super(0x0);
    }

    @Override
    public int afterEntityHit(@Nonnull IModifierToolStack tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {
        Random rand = context.getAttacker().getRandom();
        if(rand.nextInt(100) >= 50) {
            LivingEntity livingEntity = Objects.requireNonNull(context.getLivingTarget());
            DamageSource source = DamageSource.CACTUS;
            livingEntity.hurt(source.setScalesWithDifficulty(), livingEntity.getHealth()*0.3f);
        }
        return 0;
    }
}
