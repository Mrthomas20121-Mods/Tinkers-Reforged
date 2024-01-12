package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class HeadshotModifier extends Modifier {

    @Override
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {

        LivingEntity livingEntity = context.getLivingTarget();

        if(livingEntity != null) {
            int armorValue = livingEntity.getArmorValue();

            if(armorValue > 0) {
                return damage+baseDamage*0.1f;
            }
        }

        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
