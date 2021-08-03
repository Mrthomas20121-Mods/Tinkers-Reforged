package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.ReforgedTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class TraitOverHealing extends ReforgedTrait {

    public TraitOverHealing() {
        super("ref_over_healing", 0x0);
    }

    @Override
    public void onEntityHeal(ItemStack tool, EntityLivingBase entity, float amount) {
        if(this.isToolWithTrait(tool)) {
            if(entity.getHealth()+amount > entity.getMaxHealth()) {
                float bonus = entity.getHealth()+amount-entity.getMaxHealth();
                entity.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 100, 0));
                entity.setAbsorptionAmount(bonus);
            }
        }
    }
}
