package com.mrthomas20121.tinkers_reforged.Modifiers;

import c4.conarm.lib.modifiers.ArmorModifierTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.tools.modifiers.ModBeheading;
import slimeknights.tconstruct.tools.modifiers.ToolModifier;

public class ModCloth extends ArmorModifierTrait {

    public ModCloth() {
        super("cloth", 0xFFFFFF);
    }
    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        super.applyEffect(rootCompound, modifierTag);
    }

    @Override
    public void onAbilityTick(int level, World world, EntityPlayer player) {

    }
    public boolean isArmorWithTrait(Item item) {
        return this.isToolWithTrait(new ItemStack(item));
    }
}
