package mrthomas20121.tinkers_reforged.modifier;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class AdaptabilityModifier extends Modifier implements MeleeDamageModifierHook {

    public AdaptabilityModifier() {
        this.registerHooks(new ModifierHookMap.Builder().addHook(this, TinkerHooks.MELEE_DAMAGE));
    }

    /**
     * Calculate the bonus damage you get from the difference between the max and the current durability
     * @param max the max durability
     * @param current the current durability
     * @return
     */
    private float calcBonusDamage(int max, int current) {
        if(current == max) {
            return 0;
        }

        return (current-max*-1)*0.01f;
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        return damage+calcBonusDamage(tool.getStats().getInt(ToolStats.DURABILITY), tool.getCurrentDurability());
    }
}
