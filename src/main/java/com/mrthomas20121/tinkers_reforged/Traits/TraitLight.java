package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitLight extends AbstractTrait {
    public TraitLight() {
        super("light", 0xEAD981);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(entity.isEntityAlive()) {
            if(entity instanceof EntityPlayer) {
                if(this.isToolWithTrait(((EntityPlayer) entity).getHeldItemMainhand())) {
                    ((EntityPlayer) entity).addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100));
                }
                else {
                    if(((EntityPlayer) entity).getTotalArmorValue()>0) {
                        for(ItemStack stack : ((EntityPlayer) entity).getArmorInventoryList()) {
                            if(this.isToolWithTrait(stack)) {
                                ((EntityPlayer) entity).addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100));
                            }
                        }
                    }
                }
            }
        }
    }
}
