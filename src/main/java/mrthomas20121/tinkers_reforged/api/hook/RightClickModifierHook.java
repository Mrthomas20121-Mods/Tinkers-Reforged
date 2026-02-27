package mrthomas20121.tinkers_reforged.api.hook;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Collection;

public interface RightClickModifierHook {

    /**
     * Called right before the player right-click on a block
     * @param tool the tool in hand
     * @param player player
     * @param hand the hand triggering it,
     * @param event the right click block event
     */
    default void onRightClickBlock(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand, PlayerInteractEvent.RightClickBlock event) {

    }

    /**
     * Called right before the player right-click on an item
     * @param tool the tool in hand
     * @param player player
     * @param hand the hand triggering it,
     * @param event the right click item event
     */
    default void onRightClickItem(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand, PlayerInteractEvent.RightClickItem event) {

    }

    record AllMerger(Collection<RightClickModifierHook> modules) implements RightClickModifierHook {
        @Override
        public void onRightClickBlock(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand, PlayerInteractEvent.RightClickBlock event) {
            for(RightClickModifierHook module: modules) {
                module.onRightClickBlock(tool, modifier, player, hand, event);
            }
        }

        @Override
        public void onRightClickItem(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand, PlayerInteractEvent.RightClickItem event) {
            for(RightClickModifierHook module: modules) {
                module.onRightClickItem(tool, modifier, player, hand, event);
            }
        }
    }
}
