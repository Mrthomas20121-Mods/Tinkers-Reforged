package mrthomas20121.tinkers_reforged.modifier.wip;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierManager;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.data.ModifierIds;

public class RazorSharpModifier extends Modifier {

    @Override
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        int sharpLevel = tool.getModifierLevel(ModifierIds.sharpness);

        if(sharpLevel > 0) {
            return super.getEntityDamage(tool, level, context, baseDamage, damage)+0.75f*sharpLevel;
        }

        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
