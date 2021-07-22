package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.RightClickTrait;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * TraitAridGravitation.java
 * @author mrthomas20121
 * Trait Effect - if you break a sand block, it drop the blocks below it if they are sand blocks as well.
 */
public class TraitAridGravitation extends RightClickTrait {

    public TraitAridGravitation() {
        super("ref_arid_gravitation", 0x0);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if(state.getBlock() instanceof BlockSand) {
            boolean result = false;
            BlockPos downPos = pos.down();
            while(!result) {
                if(world.getBlockState(downPos).getBlock() instanceof BlockSand) {
                    world.destroyBlock(downPos, true);
                    downPos = pos.down();
                }
                else {
                    result = true;
                }
            }
        }
    }
}
