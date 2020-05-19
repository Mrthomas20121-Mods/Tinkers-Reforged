package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitRose extends AbstractTrait {
    public TraitRose() {
        super("ref_rose", 0xffffff);
    }
    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(isSelected) {
            if(entity instanceof EntityPlayer) {
                //(EntityPlayer)entity.setD
            }
        }
    }
    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        String registryName = event.getState().getBlock().getRegistryName().toString();
        if(contains(registryName, "grass", "dirt")) {
            event.setCanceled(true);
        }
    }
    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        String registryName = state.getBlock().getRegistryName().toString();;
        if(contains(registryName, "grass", "dirt")) {
            int meta = world.rand.nextInt(9);
            world.spawnEntity( new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.DYE, 1, meta)));
        }
    }
    private boolean contains(String registryName, String... elements) {
        boolean result = false;
        for(String elem : elements) {
            result = registryName.contains(elem);
            if(result) break;
        }
        return result;
    }
}