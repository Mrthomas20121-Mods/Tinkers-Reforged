package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.damagesource.DamageSource;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class SupernaturalModifier extends Modifier implements MeleeHitModifierHook {

    public SupernaturalModifier() {
        this.registerHooks(new ModifierHookMap.Builder().addHook(this, TinkerHooks.MELEE_HIT));
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if(context.getLivingTarget() != null && damageDealt > 0 && tool.getModifierLevel(modifier.getModifier()) > 0) {
            context.getLivingTarget().hurt(DamageSource.indirectMagic(context.getLivingTarget(), context.getAttacker()), 2f+modifier.getLevel());
        }
    }
}
