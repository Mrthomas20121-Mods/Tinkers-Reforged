package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class TitanicDamageModifier extends Modifier {

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        Player player = context.getPlayerAttacker();
        if(target != null && player != null) {
            if(target.getMaxHealth() > player.getMaxHealth()) {
                float hp = target.getMaxHealth()*(0.1f*level);

                // this if statement make sure the damage is not too high.
                if((level == 1 && target.getMaxHealth() - player.getMaxHealth() <= 100) || target.getMaxHealth() - player.getMaxHealth() <= 25) {
                    return damage+hp;
                }
                return hp;
            }
        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
