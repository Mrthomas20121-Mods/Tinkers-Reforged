package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;
import java.util.List;

public class GiantCellsModifier extends Modifier {

    private float getMissingHealth(LivingEntity entity) {
        return entity.getMaxHealth()-entity.getHealth();
    }

    @Override
    public void onBreakSpeed(@Nonnull IToolStackView tool, int level, @Nonnull PlayerEvent.BreakSpeed event, @Nonnull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        event.setNewSpeed(event.getNewSpeed()+getMissingHealth(event.getPlayer()));
    }

    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        if(player != null && tooltipKey.equals(TooltipKey.SHIFT)) {
            addMiningSpeedToolTip(tool, getMissingHealth(player), tooltip);
        }
    }

    public void addMiningSpeedToolTip(IToolStackView tool, float amount, List<Component> tooltip) {
        addStatTooltip(tool, ToolStats.MINING_SPEED, TinkerTags.Items.MELEE_OR_UNARMED, amount, tooltip);
    }
}
