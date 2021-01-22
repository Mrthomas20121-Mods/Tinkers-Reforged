package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitLiving extends AbstractTrait {
    public TraitLiving()
    {
        super("ref_living", 0x0);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {

        if(player instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)player;
            if(entityPlayer.experienceLevel >= 3) {
                entityPlayer.addExperienceLevel(-3);
                return newDamage+entityPlayer.experienceLevel;
            }
        }

        return super.damage(tool, player, target, damage, newDamage, isCritical);
    }
}
