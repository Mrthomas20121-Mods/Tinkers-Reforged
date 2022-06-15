package mrthomas20121.tinkers_reforged.modifier;

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

public class ModifierDamageLock extends Modifier {

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        if(context.getLivingTarget() != null) {
            LivingEntity target = context.getLivingTarget();
            if(target.level.dimension().equals(Level.END)) {
                return damage*1.05f;
            }
        }
        return 0;
    }

    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        if(tooltipKey == TooltipKey.SHIFT) {
            addPercentTooltip(new TranslatableComponent("modifier.tinkers_reforged.damage_lock.end_bonus"), 1.05f, tooltip);
        }
    }
}
