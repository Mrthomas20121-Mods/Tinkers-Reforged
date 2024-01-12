package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class AdvancedModifier extends Modifier {

    public void onEntityDeath(IToolStackView tool, LivingEntity entity, Player attacker, DamageSource source) {}

    public void onPlayerAttack(IToolStackView tool, LivingEntity target, Player attacker, DamageSource source) {}
}
