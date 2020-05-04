package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Optional;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitNuclearWaste extends AbstractTrait {
    public TraitNuclearWaste() {
        super("nuclear_waste", 0xFFFFFF);
    }
    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
    }

    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        if(entity.isEntityAlive()) {
            if(entity instanceof EntityPlayer) {

                if(this.isToolWithTrait(entity.getHeldItemMainhand())) {
                    entity.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 1));
                    entity.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 100, 1));
                    entity.addPotionEffect(new PotionEffect(MobEffects.POISON, 100, 0));
                }
            }
        }
        return newDamage;
    }

    @Override
    public void onArmorTick(ItemStack tool, World world, EntityPlayer player) { }
}
