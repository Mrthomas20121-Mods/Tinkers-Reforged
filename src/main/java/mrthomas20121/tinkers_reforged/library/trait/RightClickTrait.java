package mrthomas20121.tinkers_reforged.library.trait;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class RightClickTrait extends AbstractTrait {

    public RightClickTrait(String name, int color) {
        super(name, color);
    }

    public void onRightClick(PlayerInteractEvent.RightClickItem event) {}
}
