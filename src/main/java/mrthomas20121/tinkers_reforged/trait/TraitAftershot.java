package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitAftershot extends AbstractTrait {

    public TraitAftershot() {
        super("ref_aftershot", 0x0);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(wasHit) {
            if(player instanceof EntityPlayer) {
                if(wasCritical) {
                    player.heal(10);
                }
                else {
                    player.heal(5);
                }
                player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100));
            }
        }
    }
}
