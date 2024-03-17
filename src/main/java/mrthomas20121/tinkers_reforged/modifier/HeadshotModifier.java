package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class HeadshotModifier extends Modifier implements MeleeDamageModifierHook {

    public HeadshotModifier() {
        this.registerHooks(ModifierHookMap.builder().addHook(this, TinkerHooks.MELEE_DAMAGE));
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        if(context.getLivingTarget() != null) {
            LivingEntity target = context.getLivingTarget();

            if(target.getArmorValue() > 0) {
                return damage+target.getArmorValue()/2f;
            }
        }
        return damage;
    }
}
