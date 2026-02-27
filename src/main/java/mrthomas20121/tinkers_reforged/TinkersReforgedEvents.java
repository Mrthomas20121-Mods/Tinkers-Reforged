package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.api.hook.TinkersReforgedModifierHooks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedAttributes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class TinkersReforgedEvents {

    public static void init() {
        MinecraftForge.EVENT_BUS.addListener(TinkersReforgedEvents::onEnderPearlThrow);
        MinecraftForge.EVENT_BUS.addListener(TinkersReforgedEvents::onRightClickBlock);
        MinecraftForge.EVENT_BUS.addListener(TinkersReforgedEvents::onRightClickItem);
    }

    public static void onEnderPearlThrow(EntityTeleportEvent.EnderPearl event) {
        if(!event.isCanceled()) {
            ServerPlayer player = event.getPlayer();
            double reduction = 1-player.getAttributeValue(TinkersReforgedAttributes.ENDER_PEARL_REDUCTION.get());

            if(reduction > 0) {
                double reducedDamage = event.getAttackDamage()*reduction;

                event.setAttackDamage((float) reducedDamage);
            }
        }
    }

    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if(!event.isCanceled()) {
            if(event.getCancellationResult().shouldSwing()) {
                Player player = event.getEntity();
                InteractionHand hand = event.getHand();
                ItemStack itemInHand = player.getItemInHand(hand);

                if(!itemInHand.isEmpty() && itemInHand.is(TinkerTags.Items.MODIFIABLE)) {
                    ToolStack tool = ToolStack.from(itemInHand);
                    for(ModifierEntry modifier: tool.getModifierList()) {
                        tool.getHook(TinkersReforgedModifierHooks.RIGHT_CLICK).onRightClickItem(tool, modifier, player, hand, event);
                    }
                }
            }
        }
    }

    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if(!event.isCanceled()) {
            if(event.getCancellationResult().shouldSwing()) {
                Player player = event.getEntity();
                InteractionHand hand = event.getHand();
                ItemStack itemInHand = player.getItemInHand(hand);

                if(!itemInHand.isEmpty() && itemInHand.is(TinkerTags.Items.MODIFIABLE)) {
                    ToolStack tool = ToolStack.from(itemInHand);
                    for(ModifierEntry modifier: tool.getModifierList()) {
                        tool.getHook(TinkersReforgedModifierHooks.RIGHT_CLICK).onRightClickBlock(tool, modifier, player, hand, event);
                    }
                }
            }
        }
    }
}
