package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class EnderUpgradeModifier extends Modifier {

    public boolean isEndDimension(Level level) {
        return level.dimension().equals(Level.END);
    }

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        if(context.getLivingTarget() != null) {
            LivingEntity target = context.getLivingTarget();
            if(isEndDimension(target.level) && target instanceof EnderDragon) {
                return damage*1.05f;
            }
        }
        return damage*0.9f;
    }
}
