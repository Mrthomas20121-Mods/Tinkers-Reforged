package com.mrthomas20121.tinkers_reforged.Traits;

import c4.conarm.lib.armor.ArmorModifications;
import c4.conarm.lib.traits.IArmorAbility;
import c4.conarm.lib.traits.IArmorTrait;
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

@Optional.Interface(iface = "c4.conarm.lib.traits.IArmorTrait", modid = "conarm")
@Optional.Interface(iface = "c4.conarm.lib.traits.IArmorAbility", modid = "conarm")
public class TraitNuclearWaste extends AbstractTrait implements IArmorTrait, IArmorAbility {
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

    @Override
    public ArmorModifications getModifications(EntityPlayer arg0, ArmorModifications arg1, ItemStack arg2, DamageSource arg3, double arg4, int arg5) {
        return arg1;
    }

    @Override
    public int onArmorDamage(ItemStack item, DamageSource source, int arg2, int arg3, EntityPlayer player, int arg5) {
        if(player.isEntityAlive()) {
            if(this.isToolWithTrait(player.getHeldItemMainhand())) {
                player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 100, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.POISON, 100, 0));
            }
        }
        return arg3;
    }

    @Override
    public void onArmorEquipped(ItemStack item, EntityPlayer player, int arg2) {
        // nothing
    }

    @Override
    public int onArmorHeal(ItemStack item, DamageSource source, int arg2, int arg3, EntityPlayer player, int arg5) {
        return arg3;
    }

    @Override
    public void onArmorRemoved(ItemStack item, EntityPlayer player, int arg2) {
        // nothing
    }

    @Override
    public float onDamaged(ItemStack item, EntityPlayer player, DamageSource arg2, float arg3, float arg4, LivingDamageEvent event) {
        return arg4;
    }

    @Override
    public void onFalling(ItemStack item, EntityPlayer player, LivingFallEvent event) {
        // nothing
    }

    @Override
    public float onHeal(ItemStack item, EntityPlayer player, float arg2, float arg3, LivingHealEvent event) {
        return arg3;
    }

    @Override
    public float onHurt(ItemStack item, EntityPlayer player, DamageSource arg2, float arg3, float arg4, LivingHurtEvent event) {
        return arg4;
    }

    @Override
    public void onItemPickup(ItemStack item, EntityItem player, EntityItemPickupEvent event) {
        // nothing
    }

    @Override
    public void onJumping(ItemStack arg0, EntityPlayer player, LivingEvent.LivingJumpEvent event) {
        // nothing
    }

    @Override
    public void onKnockback(ItemStack arg0, EntityPlayer player, LivingKnockBackEvent event) {
        // nothing
    }

    @Override
    public void onAbilityTick(int arg0, World world, EntityPlayer player) {

    }

    @Override
    public boolean disableRendering(ItemStack item, EntityLivingBase entity) {
        return false;
    }

    @Override
    public int getAbilityLevel(ModifierNBT arg0) {
        return arg0.level;
    }
}
