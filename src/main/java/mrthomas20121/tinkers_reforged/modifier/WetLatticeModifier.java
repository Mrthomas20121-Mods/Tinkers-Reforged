package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

// deal 110% more damage if it's raining, 130% damage instead if thundering.
public class WetLatticeModifier extends Modifier {

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {

        Level world = context.getAttacker().getLevel();

        if(world.isRainingAt(context.getAttacker().blockPosition())) {
            if(world.isThundering()) {
                return damage*1.3f;
            }
            return damage*1.1f;
        }

        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
}
