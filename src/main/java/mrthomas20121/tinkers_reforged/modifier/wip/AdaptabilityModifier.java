package mrthomas20121.tinkers_reforged.modifier.wip;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class AdaptabilityModifier extends Modifier {

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
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        return super.getEntityDamage(tool, level, context, baseDamage, damage)+calcBonusDamage(tool.getStats().getInt(ToolStats.DURABILITY), tool.getCurrentDurability());
    }
}
