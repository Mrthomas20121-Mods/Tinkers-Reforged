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
    public int afterEntityHit(@Nonnull IModifierToolStack tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {
        if(context.getLivingTarget() != null && context.getLivingTarget().isOnFire()) {
            context.getAttacker().setSecondsOnFire(5*level);
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
