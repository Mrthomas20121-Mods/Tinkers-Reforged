package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitRefined extends AbstractTrait {

    private static int speed = 5;
    public TraitRefined() {
        super("ref_refined", 0x463763);
    }

    @Override
    public void beforeBlockBreak(ItemStack tool, BlockEvent.BreakEvent event) {
        if(event.getState().getBlock().getRegistryName().equals(Blocks.OBSIDIAN.getRegistryName())) {
            event.getState().getBlock().dropBlockAsItem(event.getWorld(), event.getPos(), event.getState(), 0);
            event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState());
            ToolHelper.damageTool(tool, 100, event.getPlayer());
        }
    }
}
