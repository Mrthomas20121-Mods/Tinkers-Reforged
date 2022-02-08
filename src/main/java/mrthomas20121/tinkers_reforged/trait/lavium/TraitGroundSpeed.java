package mrthomas20121.tinkers_reforged.trait.lavium;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nonnull;

public class TraitGroundSpeed extends Modifier {

    public TraitGroundSpeed() {
        super(0x81B366);
    }

    @Override
    public void onBreakSpeed(@Nonnull IModifierToolStack tool, int level, @Nonnull PlayerEvent.BreakSpeed event, @Nonnull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        World world = event.getEntityLiving().getCommandSenderWorld();
        BlockPos pos = event.getPos();
        if(pos.getY() < world.getSeaLevel() && isEffective) {
            event.setNewSpeed(event.getNewSpeed()+3.2f);
        }
    }
}
