package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class ModifierBlazingFire extends Modifier {

    public ModifierBlazingFire() {
        super();
    }

    @Override
    public int afterEntityHit(@Nonnull IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        if(target != null && target.isOnFire()) {
            int fireTicks = target.getRemainingFireTicks();
            target.setRemainingFireTicks(fireTicks+(int)(fireTicks*0.2f*level));
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
