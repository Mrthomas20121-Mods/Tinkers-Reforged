package mrthomas20121.tinkers_reforged.modifier;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class HellishRepairModifier extends Modifier implements MeleeHitModifierHook {

    public HellishRepairModifier() {
        this.registerHooks(new ModifierHookMap.Builder().addHook(this, TinkerHooks.MELEE_HIT));
    }

    @Override
    public float beforeMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damage, float baseKnockback, float knockback) {
        if(context.getLivingTarget() != null) {
            if(context.getLivingTarget().isOnFire()) {
                ToolDamageUtil.repair(tool, 5+2*modifier.getLevel());
            }
        }
        return MeleeHitModifierHook.super.beforeMeleeHit(tool, modifier, context, damage, baseKnockback, knockback);
    }
}
