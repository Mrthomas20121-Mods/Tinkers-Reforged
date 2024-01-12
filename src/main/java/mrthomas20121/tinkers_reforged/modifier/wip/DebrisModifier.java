package mrthomas20121.tinkers_reforged.modifier.wip;

import net.minecraft.core.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.tools.data.ModifierIds;

public class DebrisModifier extends Modifier {

    @Override
    public void onBreakSpeed(IToolStackView tool, int level, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        if(tool.getModifierLevel(ModifierIds.netherite) > 0) {
            event.setNewSpeed(event.getNewSpeed()+1.1f*level);
        }
    }
}
