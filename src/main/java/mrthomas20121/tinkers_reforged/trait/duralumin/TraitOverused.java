package mrthomas20121.tinkers_reforged.trait.duralumin;

import net.minecraft.util.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;

public class TraitOverused extends Modifier {

    public TraitOverused() {
        super(0xD1F1C1);
    }

    @Override
    public void onBreakSpeed(@Nonnull IModifierToolStack tool, int level, @Nonnull PlayerEvent.BreakSpeed event, @Nonnull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        float bonusSpeed = getBonusSpeed(tool);
        event.setNewSpeed(event.getNewSpeed()+bonusSpeed);
    }

    private float getBonusSpeed(@Nonnull IModifierToolStack tool) {
        int durability = tool.getCurrentDurability();
        int maxDurability = tool.getStats().getInt(ToolStats.DURABILITY);
        if(durability > maxDurability/2) {
            return 5;
        }
        return 0;
    }
}
