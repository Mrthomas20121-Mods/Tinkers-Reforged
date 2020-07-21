package mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitAstral extends AbstractTrait {
    public TraitAstral() {
        super("ref_astral", 0xFFFFFF);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(entity.isEntityAlive() && isSelected) {
            if(entity instanceof EntityPlayer) {
                if(((EntityPlayer) entity).world.getWorldTime() >= 13000 && this.isToolWithTrait(((EntityPlayer) entity).getHeldItemMainhand())) {
                    ((EntityPlayer) entity).addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 500));
                }
            }
        }
    }
}
