package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Objects;

public class ModifierFirestarter extends Modifier {

    public ModifierFirestarter() {
        super();
    }

    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = Objects.requireNonNull(context.getLivingTarget());
        if(target.isOnFire()) {
            int fireTicks = target.getRemainingFireTicks();
            target.setRemainingFireTicks(fireTicks+fireTicks/2);
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
