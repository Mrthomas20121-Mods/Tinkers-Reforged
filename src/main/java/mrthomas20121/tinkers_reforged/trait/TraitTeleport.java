package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import java.util.List;

public class TraitTeleport extends AbstractTrait {
    public TraitTeleport()
    {
        super("ref_teleport", 0x0);
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        if(isToolWithTrait(tool))
        {
            List<ItemStack> stacks = event.getDrops();
            World world = event.getWorld();
            if(!world.isRemote)
            {
                for(ItemStack stack : stacks)
                {
                    player.inventory.addItemStackToInventory(stack);
                }
            }
        }
    }
}
