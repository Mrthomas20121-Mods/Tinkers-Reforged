package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import java.util.ArrayList;
import java.util.List;

public class TraitCrystalSurge extends AbstractTrait {

    public TraitCrystalSurge()
    {
        super("ref_crystal_surge", 0x0);
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        ResourceLocation registryName = event.getState().getBlock().getRegistryName();
        String localizedName = event.getState().getBlock().getLocalizedName();
        if( localizedName.toLowerCase().contains("crystal") && registryName.getNamespace().equals("thaumcraft") )
        {
            EntityPlayer player = event.getHarvester();
            World world = player.getEntityWorld();
            if(!world.isRemote)
            {
                List<ItemStack> items = event.getDrops();
                ArrayList<EntityItem> entityItems = new ArrayList<>();

                BlockPos pos = event.getPos();
                EntityItem entityItem = new EntityItem(world);
                entityItem.setPosition(pos.getX(), pos.getY(), pos.getZ());

                items.forEach((itemStack -> {
                    entityItem.setItem(itemStack);
                    entityItems.add(entityItem);
                }));

                entityItems.forEach(entity -> world.spawnEntity(entity));
            }
        }
    }
}
