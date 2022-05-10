package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import slimeknights.tconstruct.library.modifiers.impl.SingleLevelModifier;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;
import java.lang.reflect.Modifier;

public class ModifierElectrostatic extends SingleLevelModifier {

    @Override
    public void afterBlockBreak(@Nonnull IToolStackView tool, int level, @Nonnull ToolHarvestContext context) {
        ServerPlayer player = context.getPlayer();
        if(player != null) {
            player.hurt(DamageSource.ANVIL.setScalesWithDifficulty(), 1.F);
        }
    }
}
