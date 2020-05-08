package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import java.util.List;

public class TraitRadioactive extends AbstractTrait {
    public TraitRadioactive() {
        super("reforged_radioactive", 0x8CFFAC);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(entity.isEntityAlive()) {
            if(entity instanceof EntityPlayer) {
                if(this.isToolWithTrait(tool) && isSelected) {
                    List<Entity> entities = world.getLoadedEntityList();
                    for(Entity ent : entities) {
                        if(ent instanceof EntityLivingBase && !(ent instanceof EntityPlayer)) {
                            ((EntityLivingBase) ent).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 1));
                            ((EntityLivingBase) ent).addPotionEffect(new PotionEffect(MobEffects.POISON, 200, 1));
                        }
                    }
                }
            }
        }
    }
}
