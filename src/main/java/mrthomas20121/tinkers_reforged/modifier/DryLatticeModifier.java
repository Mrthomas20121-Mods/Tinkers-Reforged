package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

// break blocks faster if it's not raining and you can see the sun
public class DryLatticeModifier extends Modifier {

    @Override
    public void onBreakSpeed(@Nonnull IToolStackView tool, int level, @Nonnull PlayerEvent.BreakSpeed event, @Nonnull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        Player player = event.getPlayer();
        if(!player.level.isRainingAt(player.blockPosition()) && player.level.canSeeSky(player.blockPosition())) {
            event.setNewSpeed(event.getOriginalSpeed()*1.25f);
        }
    }
}
