package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class ModifierTitanicDamage extends Modifier {

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        Player player = context.getPlayerAttacker();
        if(target != null && player != null) {
            if(target.getMaxHealth() > player.getMaxHealth()) {
                float hp = ((target.getMaxHealth()-player.getMaxHealth())/0.09f)*(level*0.01f);
                return damage+hp;
            }
        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
