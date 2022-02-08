package mrthomas20121.tinkers_reforged.trait.qivium;

import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nonnull;
import java.util.Objects;

public class TraitFireplace extends Modifier {

    public TraitFireplace() {
        super(0xFF8F84);
    }

    @Override
    public float getEntityDamage(@Nonnull IModifierToolStack tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity entity = Objects.requireNonNull(context.getLivingTarget());
        LivingEntity attacker = context.getAttacker();

        if(entity.isOnFire()) {
            return damage+(entity.getHealth()*0.013f);
        }

        return damage;
    }
}
