package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitEnder extends AbstractTrait {
    public TraitEnder() {
        super("ender", 0x376B64);
    }
    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        float dmg = newDamage;
        if(target.getName().contains("Ender")) {
            dmg = dmg*(dmg/2);
        }
        return dmg;
    }
}

