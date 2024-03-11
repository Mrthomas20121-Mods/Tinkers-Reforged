package mrthomas20121.tinkers_reforged.modifier;

import net.minecraft.core.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.tools.data.ModifierIds;

public class DebrisModifier extends Modifier implements BreakSpeedModifierHook {

    public DebrisModifier() {
        this.registerHooks(new ModifierHookMap.Builder().addHook(this, TinkerHooks.BREAK_SPEED));
    }

    @Override
    public void onBreakSpeed(IToolStackView tool, ModifierEntry modifier, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        if(tool.getModifierLevel(ModifierIds.netherite) > 0) {
            event.setNewSpeed(event.getNewSpeed()+1.1f*modifier.getLevel());
        }
    }
}
