package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitBright extends AbstractTrait {
    public TraitBright() {
        super("ref_bright", 0xEAD981);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (!world.isRaining()) {

        }
    }
    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        if(player instanceof EntityPlayer) {
            if(((EntityPlayer)player).dimension == ((EntityPlayer)player).getSpawnDimension()) {
                if(!player.getEntityWorld().isRaining()) {
                    return newDamage+2;
                }
            }
        }
        return newDamage;
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        EntityPlayer player = event.getEntityPlayer();
        if(player.dimension == player.getSpawnDimension()) {
            if(!player.getEntityWorld().isRaining()) {
                event.setNewSpeed(event.getNewSpeed()+2);
            }
        }
    }
}
