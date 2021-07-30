package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.potion.PotionRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitEnder extends AbstractTrait {
    public TraitEnder() {
        super("ref_ender", 0x376B64);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(wasHit && !target.isPotionActive(PotionRegistry.ender)) {
            target.addPotionEffect(new PotionEffect(PotionRegistry.ender, 100, 0, false, false));
        }
        else {
            target.removePotionEffect(PotionRegistry.ender);
        }
    }
}

