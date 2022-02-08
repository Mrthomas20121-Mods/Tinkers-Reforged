package mrthomas20121.tinkers_reforged.trait.qivium;

import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nonnull;
import java.util.Objects;

public class TraitFirestarter extends Modifier {

    public TraitFirestarter() {
        super(0xFF8F84);
    }

    @Override
    public int afterEntityHit(@Nonnull IModifierToolStack tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {
        LivingEntity target = Objects.requireNonNull(context.getLivingTarget());
        if(target.isOnFire()) {
            int fireTicks = target.getRemainingFireTicks();
            target.setRemainingFireTicks(fireTicks+fireTicks/2);
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
