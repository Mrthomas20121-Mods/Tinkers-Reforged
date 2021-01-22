package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitBright extends AbstractTrait {
    public TraitBright() {
        super("ref_bright", 0xEAD981);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (!world.isRaining() || !world.isRemote || world.getWorldTime() % 20 == 0) {
            if(entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                BlockPos pos = player.getPosition();
                if(world.canSeeSky(pos)) {
                    ToolHelper.healTool(tool, 10, player);
                }
            }
        }
    }


}
