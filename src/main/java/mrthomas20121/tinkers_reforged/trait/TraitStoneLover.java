package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.RightClickTrait;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.oredict.OreDictionary;

public class TraitStoneLover extends RightClickTrait {

    public TraitStoneLover() {
        super("ref_stone_lover", 0x0);
    }

    @Override
    public void beforeBlockBreak(ItemStack tool, BlockEvent.BreakEvent event) {
        Block block = event.getState().getBlock();
        if(!OreDictionary.containsMatch(false, OreDictionary.getOres("stone"), new ItemStack(block))) {
            event.setResult(Event.Result.DENY);
            event.setCanceled(true);
        }

    }
}
