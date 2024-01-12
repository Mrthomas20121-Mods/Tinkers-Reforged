package mrthomas20121.tinkers_reforged.modifier.wip;

import net.minecraft.world.damagesource.DamageSource;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class SorceryModifier extends Modifier {

    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {

        if(context.getLivingTarget() != null && damageDealt > 0) {
            context.getLivingTarget().hurt(DamageSource.indirectMagic(context.getLivingTarget(), context.getAttacker()), 2+level);

            return 2+level;
        }

        return 0;
    }
}
