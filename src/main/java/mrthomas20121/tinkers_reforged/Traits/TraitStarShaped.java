package mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitStarShaped extends AbstractTrait {
  public TraitStarShaped() {
    super("ref_star_shaped", 0xfffff);
  }
  @Override
  public boolean isCriticalHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target) {
    return true;
  }
  @Override
  public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
    if(isCritical) {
      return newDamage;
    }
    return 0.5f;
  }
}