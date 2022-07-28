package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;
import java.util.List;

public class EnderTaintModifier extends Modifier {

    public boolean isEndDimension(Entity entity) {
        return entity != null && isEndDimension(entity.level);
    }

    public boolean isEndDimension(Level level) {
        return level.dimension().equals(Level.END);
    }

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        if(context.getLivingTarget() != null) {
            LivingEntity target = context.getLivingTarget();
            if(isEndDimension(target.level)) {
                return damage*1.05f;
            }
        }
        return damage*0.9f;
    }

    @Override
    public void onBreakSpeed(@Nonnull IToolStackView tool, int level, @Nonnull PlayerEvent.BreakSpeed event, @Nonnull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        if(isEndDimension(event.getPlayer())) {
            event.setNewSpeed(event.getNewSpeed()*1.05f);
        }
        else {
            event.setNewSpeed(event.getNewSpeed()*0.9f);
        }
    }

    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        addPercentTooltip(new TranslatableComponent("modifier.tinkers_reforged.ender_taint.bonus"), 1.05f, tooltip);
        addPercentTooltip(new TranslatableComponent("modifier.tinkers_reforged.ender_taint.malus"), 0.9f, tooltip);
    }
}
