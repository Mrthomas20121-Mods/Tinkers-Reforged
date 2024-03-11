package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class ExtinguishModifier extends Modifier implements MeleeHitModifierHook {

    public ExtinguishModifier() {
        this.registerHooks(new ModifierHookMap.Builder().addHook(this, TinkerHooks.MELEE_HIT));
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        if(target != null && target.isOnFire()) {
            target.clearFire();
            target.hurt(DamageSource.GENERIC, damageDealt*(0.02f*modifier.getLevel()));
        }
    }
}
