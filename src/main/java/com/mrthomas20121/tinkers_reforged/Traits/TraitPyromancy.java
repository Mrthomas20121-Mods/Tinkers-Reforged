package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitPyromancy extends AbstractTrait {
    public TraitPyromancy() {
        super("pyromancy", 0x0f1000);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        if(isCritical) {
            target.setFire(20);
        }
        return newDamage;
    }
}
