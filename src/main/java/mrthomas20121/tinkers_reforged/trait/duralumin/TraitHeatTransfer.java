package mrthomas20121.tinkers_reforged.trait.duralumin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nonnull;

// mine blocks faster if they are next to a block with lava as Material.
public class TraitHeatTransfer extends Modifier {

    public TraitHeatTransfer() {
        super(0xE0B475);
    }

    @Override
    public void onBreakSpeed(@Nonnull IModifierToolStack tool, int level, @Nonnull PlayerEvent.BreakSpeed event, @Nonnull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        if(isEffective) {
            BlockPos pos = event.getPos();
            World world = event.getEntityLiving().level;
            BlockPos[] positions = { pos.above(), pos.below(), pos.east(), pos.west(), pos.north(), pos.south()};
            for(BlockPos p : positions) {
                BlockState blockState = world.getBlockState(pos);
                if(!blockState.getMaterial().equals(Material.AIR)) {
                    if(blockState.getMaterial().equals(Material.LAVA)) {
                        event.setNewSpeed(event.getNewSpeed()+5f);
                    }
                }
            }
        }
    }
}
