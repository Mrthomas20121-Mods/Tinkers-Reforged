package mrthomas20121.tinkers_reforged.modifier.wip;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class ExtinguishModifier extends Modifier {

    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {

        LivingEntity target = context.getLivingTarget();
        if(target != null && target.isOnFire()) {
            target.clearFire();
            target.hurt(DamageSource.GENERIC, damageDealt*(0.02f*level));
        }

        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
