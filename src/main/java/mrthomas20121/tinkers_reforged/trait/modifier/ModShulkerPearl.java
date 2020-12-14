package mrthomas20121.tinkers_reforged.trait.modifier;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;

public class ModShulkerPearl extends ModifierTrait {

    public ModShulkerPearl()
    {
        super("ref_shulker_pearl", 0xFFFFE8);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected)
        {
            if(!world.isRemote)
            {
                if(entity instanceof EntityLivingBase)
                {
                    EntityLivingBase ent = (EntityLivingBase)entity;

                    ent.removePotionEffect(MobEffects.LEVITATION);
                }
            }
        }
    }
}
