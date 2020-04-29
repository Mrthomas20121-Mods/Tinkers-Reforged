package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class TraitPowerless extends AbstractTrait {

    public TraitPowerless() {
        super("powerless", 0xff);
        addAspects(ModifierAspect.weaponOnly);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        NBTTagCompound nbt = tool.getTagCompound();
        if(nbt.hasKey("mob_killed")) {
            if(nbt.getInteger("mob_killed") >= 10 && nbt.getInteger("mob_killed") < 50) {
                return newDamage/2;
            }
            else if(nbt.getInteger("mob_killed") >= 50) {
                if(isCritical) {
                    return newDamage/8;
                }
                return newDamage/4;
            }

        }
        return newDamage;
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        if(!target.isEntityAlive()) {
            if(player instanceof EntityPlayer) {
                if(target instanceof EntityMob) {
                    NBTTagCompound nbt = tool.getTagCompound();
                    if(nbt.hasKey("mob_killed")) {
                        NBTBase base = new NBTTagInt(nbt.getInteger("mob_killed")+1);
                        tool.setTagInfo("mob_killed", base);
                    }
                    else {
                        NBTBase base = new NBTTagInt(1);
                        tool.setTagInfo("mob_killed", base);
                    }
                }
            }
        }
    }
}
