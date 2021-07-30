package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.ReforgedTrait;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitSnowball extends ReforgedTrait {

    public TraitSnowball() {
        super("ref_snowball", 0x0);
    }

    @Override
    public void onItemRightClick(ItemStack tool, World world, EntityPlayer player, BlockPos pos, EnumHand hand) {
        world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote)
        {
            EntitySnowball entitysnowball = new EntitySnowball(world, player);
            entitysnowball.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
            world.spawnEntity(entitysnowball);
            if(!player.isCreative()) ToolHelper.damageTool(tool, 10, null);
        }
    }
}
