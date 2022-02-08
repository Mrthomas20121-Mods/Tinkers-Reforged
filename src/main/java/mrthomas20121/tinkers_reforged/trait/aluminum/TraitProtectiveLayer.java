package mrthomas20121.tinkers_reforged.trait.aluminum;

import net.minecraft.util.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

import javax.annotation.Nonnull;

public class TraitProtectiveLayer extends Modifier {

    public TraitProtectiveLayer() {
        super(0xD6E1E4);
    }

    @Override
    public void onBreakSpeed(@Nonnull IModifierToolStack tool, int level, @Nonnull PlayerEvent.BreakSpeed event, @Nonnull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        if(event.getPlayer().isInWater() && isEffective) {
            event.setNewSpeed(event.getOriginalSpeed()*2);
        }
    }
}
