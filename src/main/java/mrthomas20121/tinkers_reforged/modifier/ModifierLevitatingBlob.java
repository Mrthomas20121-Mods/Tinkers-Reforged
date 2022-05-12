package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ShulkerBullet;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class ModifierLevitatingBlob extends Modifier {

    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        if(target != null) {
            Player player = context.getPlayerAttacker();
            if(player != null) {
                target.level.addFreshEntity(new ShulkerBullet(target.level, player, target, player.getDirection().getAxis()));
            }
        }
        return super.afterEntityHit(tool, level, context, damageDealt);
    }
}
