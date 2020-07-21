package mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import net.minecraft.entity.monster.EntityCreeper;

public class TraitSignal extends AbstractTrait {
    public TraitSignal() {
        super("ref_signal", 0xE65B10);
    }
    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(target instanceof EntityCreeper) {
            ((EntityCreeper)target).ignite();
        }
    }
}
