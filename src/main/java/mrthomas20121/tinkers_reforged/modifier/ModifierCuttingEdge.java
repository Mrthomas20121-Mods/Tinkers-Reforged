package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class ModifierCuttingEdge extends Modifier {

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if(target instanceof Animal) {
            return damage+baseDamage*0.1f;
        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
