package mrthomas20121.tinkers_reforged.trait;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitRod extends AbstractTrait {

    public TraitRod()
    {
        super("ref_rod", 0x0);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(wasHit)
        {
            World world = player.getEntityWorld();
            world.spawnEntity(new EntityLightningBolt(world, target.posX, target.posY, target.posZ, false));
        }
    }
}
