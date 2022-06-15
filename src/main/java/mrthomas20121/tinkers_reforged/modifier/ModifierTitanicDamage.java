package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class ModifierTitanicDamage extends NoLevelsModifier {

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        Player player = context.getPlayerAttacker();
        if(target != null && player != null) {
            if(target.getMaxHealth() > player.getMaxHealth()) {
                float hp = target.getMaxHealth()*0.1f;
                return damage+hp;
            }
        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
