package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class AntiArmorModifier extends Modifier {

    public AntiArmorModifier() {
        super();
    }

    @Override
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {

        if(context.getLivingTarget() != null) {
            LivingEntity target = context.getLivingTarget();
            float percentage = target.getArmorCoverPercentage();
            if(percentage > 0) {
                float calc = percentage/2;
                return damage+calc;
            }
        }

        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
