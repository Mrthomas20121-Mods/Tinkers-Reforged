package mrthomas20121.tinkers_reforged.trait;

import mrthomas20121.tinkers_reforged.library.trait.RightClickTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;

public class TraitThaumicBomb extends RightClickTrait {

    public TraitThaumicBomb() {
        super("ref_thaumic_bomb", 0x0);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        float vis = ThaumcraftApi.internalMethods.getVis(player.getEntityWorld(), player.getPosition());
        if(vis-newDamage > 0) {
            ThaumcraftApi.internalMethods.drainVis(player.getEntityWorld(), player.getPosition(), newDamage,false);
            EntityTNTPrimed tnt = new EntityTNTPrimed(player.getEntityWorld(), target.posX, target.posY, target.posZ, player);
            tnt.setFuse(5);
            tnt.setFire(5);
            player.getEntityWorld().spawnEntity(tnt);
            return newDamage*2;
        }
        return newDamage;
    }
}
