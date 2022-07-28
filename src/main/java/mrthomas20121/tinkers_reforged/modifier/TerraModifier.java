package mrthomas20121.tinkers_reforged.modifier;

import mrthomas20121.tinkers_reforged.init.TinkersReforgedTags;
import net.minecraft.core.Direction;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class TerraModifier extends Modifier {

    @Override
    public void onBreakSpeed(@Nonnull IToolStackView tool, int level, @Nonnull PlayerEvent.BreakSpeed event, @Nonnull Direction sideHit, boolean isEffective, float miningSpeedModifier) {
       if(ForgeRegistries.BLOCKS.tags().getTag(TinkersReforgedTags.Blocks.ROCK_TYPE_BLOCKS).contains(event.getState().getBlock())) {
           event.setNewSpeed(event.getNewSpeed()*1.5f);
       }
    }
}
