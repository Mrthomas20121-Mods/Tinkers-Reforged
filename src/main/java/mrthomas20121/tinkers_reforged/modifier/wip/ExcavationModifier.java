package mrthomas20121.tinkers_reforged.modifier.wip;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public class ExcavationModifier extends Modifier {

    private static final ResourceLocation VALUE = new ResourceLocation(TinkersReforged.MOD_ID, "block_mined");
    private static final ResourceLocation LEVEL = new ResourceLocation(TinkersReforged.MOD_ID, "level");

    @Override
    public void onBreakSpeed(IToolStackView tool, int level, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        if(isEffective) {
            if(tool.getPersistentData().contains(VALUE, Tag.TAG_INT)) {
                int value = tool.getPersistentData().getInt(VALUE);
                if(value == 100) {
                    tool.getPersistentData().putInt(VALUE, 1);
                    if(tool.getPersistentData().contains(LEVEL, Tag.TAG_INT)) {
                        if(tool.getPersistentData().getInt(LEVEL) == 5) {
                           // do nothing
                        }
                        else {
                            tool.getPersistentData().putInt(LEVEL, tool.getPersistentData().getInt(LEVEL)+1);
                        }
                    }
                }
                else {
                    tool.getPersistentData().putInt(VALUE, tool.getPersistentData().getInt(VALUE)+1);
                }
            }
            else {
                tool.getPersistentData().putInt(VALUE, 1);
            }

            if(tool.getPersistentData().contains(LEVEL, Tag.TAG_INT)) {
                int l = tool.getPersistentData().getInt(LEVEL);

                if(l > 0) {
                    event.setNewSpeed(event.getNewSpeed()+tool.getPersistentData().getInt(LEVEL)+level);
                }
            }
            else {
                tool.getPersistentData().putInt(LEVEL, 0);
            }
        }
    }

    @Override
    public void addInformation(IToolStackView tool, int level, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        super.addInformation(tool, level, player, tooltip, tooltipKey, tooltipFlag);

        if(tool.getPersistentData().contains(VALUE, Tag.TAG_INT) && tool.getPersistentData().contains(LEVEL, Tag.TAG_INT)) {
            int l = tool.getPersistentData().getInt(LEVEL);
            int value = tool.getPersistentData().getInt(VALUE);

            tooltip.add(new TranslatableComponent("tinkers_reforged.modifier.excavation.value", value).withStyle(ChatFormatting.AQUA));
            tooltip.add(new TranslatableComponent("tinkers_reforged.modifier.excavation.level", value).withStyle(ChatFormatting.AQUA));
        }
    }
}
