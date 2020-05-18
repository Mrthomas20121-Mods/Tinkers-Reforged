package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitLifeSteal extends AbstractTrait {

    public TraitLifeSteal() {
        super("life_steal", 0xff);
        addAspects(ModifierAspect.weaponOnly);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        target.attackEntityFrom(DamageSource.causeIndirectMagicDamage(player, target), 2);
        return newDamage;
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(player instanceof EntityPlayer && target instanceof EntityMob) {
            if(wasHit) {
                //player.heal(damageDealt/4);
                player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 100, (int)damageDealt/4));
            }
        }
    }
}
