package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitStarryNight extends AbstractTrait {
    public TraitStarryNight() {
        super("ref_starry_night", 0xffffff);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected) {
            long time = world.getWorldTime();
            if(time >= 13000) {
                if(entity instanceof EntityLivingBase) {
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.HASTE, 100, 0));
                }
            }
        }
    }
}