package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.RightClickTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

/**
 * TraitDimensionalPunch.java
 * @author mrthomas20121
 * Trait Effect - Deal more damage in another dimension
 */
public class TraitDimensionalPunch extends RightClickTrait {

    public TraitDimensionalPunch() {
        super("ref_dimensional_punch", 0x0);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        if(player.getEntityWorld().provider.getDimension() != 0) {
            return super.damage(tool, player, target, damage, newDamage, isCritical)+random.nextInt(10);
        }
        return super.damage(tool, player, target, damage, newDamage, isCritical);
    }
}
