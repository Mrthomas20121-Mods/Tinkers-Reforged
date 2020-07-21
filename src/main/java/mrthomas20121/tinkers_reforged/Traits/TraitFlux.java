package mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitFlux extends AbstractTrait {
    private int energyCost = 5;

    public TraitFlux() {
      super("ref_flux", 0x0f1000);
    }
    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {

        World world = entity.getEntityWorld();
        int rand = world.rand.nextInt(10);
        if(rand <=5)
        {
            if(entity instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer)entity;
                player.addExhaustion(10.5f);
            }
            return newDamage/2;
        }
        return newDamage;
    }
}