package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.ReforgedTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;

public class TraitFluxForce extends ReforgedTrait {

    public TraitFluxForce() {
        super("ref_flux_force", 0x0);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        return newDamage+ThaumcraftApi.internalMethods.getFlux(player.getEntityWorld(), target.getPosition());
    }
}
