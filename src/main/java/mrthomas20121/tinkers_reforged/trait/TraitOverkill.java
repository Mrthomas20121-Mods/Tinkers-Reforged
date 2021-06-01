package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.RightClickTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TraitOverkill extends RightClickTrait {

    public TraitOverkill() {
        super("ref_overkill", 0x0);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(wasHit && damageDealt > target.getHealth()) {
            if(player instanceof EntityPlayer) {
                ((EntityPlayer) player).addExperience(100);
            }
        }
    }
}
