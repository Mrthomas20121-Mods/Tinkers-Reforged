package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitRadioactive extends AbstractTrait {
    public TraitRadioactive() {
        super("radioactive", 0x8CFFAC);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(entity.isEntityAlive()) {
            if(entity instanceof EntityPlayer) {
                if(this.isToolWithTrait(((EntityPlayer) entity).getHeldItemMainhand())) {
                    ((EntityPlayer) entity).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 500, 2));
                    ((EntityPlayer) entity).addPotionEffect(new PotionEffect(MobEffects.HUNGER, 500, 2));
                }
            }
        }
    }
}
