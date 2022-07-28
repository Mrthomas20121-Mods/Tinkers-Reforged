package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedPotions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class ElectroWebModifier extends Modifier {

    @Override
    public int afterEntityHit(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {
        LivingEntity entity = context.getLivingTarget();
        if(damageDealt > 0 && entity != null) {
            if(!entity.hasEffect(TinkersReforgedPotions.ElectroWeb.get())) {
                entity.addEffect(new MobEffectInstance(TinkersReforgedPotions.ElectroWeb.get(), 600, level, false, true));
            }
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
