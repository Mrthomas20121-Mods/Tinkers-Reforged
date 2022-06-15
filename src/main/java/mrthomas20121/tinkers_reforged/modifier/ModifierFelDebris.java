package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Deal more damage to things in the nether and less damage in the end
 */
public class ModifierFelDebris extends Modifier {

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if(target != null && target.level.dimension().equals(Level.NETHER)) {
            return baseDamage*1.5f;
        }
        else if(target != null && target.level.dimension().equals(Level.END)) {
            return baseDamage*0.8f;
        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }

    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        double bonus = 0d;
        if(player != null) {
            Level world = player.level;
            if(world.dimension().equals(Level.NETHER)) {
                bonus = 1.5;
            }
            else if(world.dimension().equals(Level.END)) {
                bonus = -0.8;
            }

            // make sure bonus is not empty
            if(bonus != 0d && tooltipKey == TooltipKey.SHIFT) addPercentTooltip(new TranslatableComponent("modifier.tinkers_reforged.fel_debris.bonus"), bonus, tooltip);
        }
    }
}
