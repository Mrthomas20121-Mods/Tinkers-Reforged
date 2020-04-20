package com.mrthomas20121.tinkers_reforged.Modifiers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.tools.modifiers.ModBeheading;
import slimeknights.tconstruct.tools.modifiers.ToolModifier;

public class ModAstral extends ToolModifier {

    public ModAstral() {
        super("astral", 0xFFFFFF);

        addAspects(ModifierAspect.freeModifier, ModifierAspect.weaponOnly);
    }
    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {}
}
