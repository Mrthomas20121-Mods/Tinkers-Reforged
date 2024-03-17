package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class WitherVirusModifier extends Modifier implements MeleeDamageModifierHook {

    public WitherVirusModifier() {
        this.registerHooks(ModifierHookMap.builder()
                .addHook(this, TinkerHooks.MELEE_DAMAGE)
        );
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        float dmg = damage;

        LivingEntity attacker = context.getAttacker();
        if(attacker.hasEffect(MobEffects.WITHER)) {
            dmg+=1.1f*modifier.getLevel();
        }

        return dmg;
    }
}
