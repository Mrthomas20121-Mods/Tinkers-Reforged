package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedPotions;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class ModifierSporeShot extends Modifier {

    @Override
    public int afterEntityHit(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float damageDealt) {
        if(context.getLivingTarget() != null) {
            LivingEntity target = context.getLivingTarget();
            if(target.hasEffect(TinkersReforgedPotions.Fungal.get())) {
                target.hurt(DamageSource.CACTUS, target.getHealth()*0.02f);
                target.removeEffect(TinkersReforgedPotions.Fungal.get());
            }
            else {
                target.addEffect(new MobEffectInstance(TinkersReforgedPotions.Fungal.get(), 150, level));
            }
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
