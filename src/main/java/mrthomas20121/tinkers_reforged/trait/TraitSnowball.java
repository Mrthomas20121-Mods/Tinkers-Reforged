package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.RightClickTrait;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitSnowball extends RightClickTrait {

    public TraitSnowball() {
        super("ref_snowball", 0x0);
    }

    @Override
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        EntityPlayer player = event.getEntityPlayer();
        ItemStack tool = event.getItemStack();
        World world = event.getWorld();

        if(isToolWithTrait(tool)) {
            world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (this.random.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote)
            {
                EntitySnowball entitysnowball = new EntitySnowball(world, player);
                entitysnowball.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
                world.spawnEntity(entitysnowball);
                ToolHelper.damageTool(tool, 10, null);
            }
        }
    }
}
