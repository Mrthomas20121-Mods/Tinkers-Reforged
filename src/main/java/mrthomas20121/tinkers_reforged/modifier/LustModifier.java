package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class LustModifier extends AdvancedModifier {

    @Override
    public void onEntityDeath(IToolStackView tool, LivingEntity entity, Player attacker, DamageSource source) {
        if(!attacker.level.isClientSide) {
            int level = tool.getModifierLevel(this.getId());
            attacker.getFoodData().eat(level, 3.5f*level);
        }
    }
}
