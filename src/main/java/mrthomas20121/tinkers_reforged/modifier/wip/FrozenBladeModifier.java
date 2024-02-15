package mrthomas20121.tinkers_reforged.modifier.wip;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedPotions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class FrozenBladeModifier extends Modifier {

    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {

        LivingEntity target = context.getLivingTarget();
        if(target != null) {
            target.addEffect(new MobEffectInstance(TinkersReforgedPotions.FROZEN.get()));
        }

        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
