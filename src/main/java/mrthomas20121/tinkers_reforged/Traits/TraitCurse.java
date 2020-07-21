package mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitCurse extends AbstractTrait {
    public TraitCurse() {
        super("ref_curse", 0xffddff);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(!target.isEntityAlive() && target instanceof EntityMob && wasHit){
            World world = player.getEntityWorld();
            int chance = world.rand.nextInt(100);
            EntityLivingBase output = target;
            output.setDropItemsWhenDead(false);
            output.setHealth(output.getHealth()*0.5f);
            if(chance > 80) {
                world.spawnEntity(output);
            }
        }
    }
}