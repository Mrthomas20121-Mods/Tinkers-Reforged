package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

// deal more damage to entity with more max health than you
public class GargantuanForce extends Modifier {

    @Override
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        Player player = context.getPlayerAttacker();
        if(target != null && player != null) {
            if(target.getMaxHealth() > player.getMaxHealth()) {
                return damage+damage*0.1f;
            }
        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
