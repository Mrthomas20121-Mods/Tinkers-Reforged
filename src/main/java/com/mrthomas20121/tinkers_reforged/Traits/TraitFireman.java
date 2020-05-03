package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitFireman extends AbstractTrait {
    public TraitFireman() {
        super("fire_man", 0x0f1000);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        if(isCritical) {
            target.setFire(20);
        }
        return newDamage;
    }
}
