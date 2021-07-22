package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.RightClickTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TraitGlow extends RightClickTrait {

    public TraitGlow() {
        super("ref_glow", 0x0);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected) {
            if(entity instanceof EntityPlayer) {
                entity.setGlowing(true);
            }
        }
        else {
            if(entity instanceof EntityPlayer) {
                entity.setGlowing(false);

            }
        }
    }
}
