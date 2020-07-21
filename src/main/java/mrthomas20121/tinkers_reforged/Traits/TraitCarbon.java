package com.mrthomas20121.tinkers_reforged.Traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitCarbon extends AbstractTrait {
    public TraitCarbon() {
        super("ref_carbon", 0xfff999);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if(this.isToolWithTrait(tool)) {
            NBTTagCompound nbt = tool.getTagCompound();
            int durability = nbt.getInteger("Durability");
            nbt.setInteger("Durability", durability+1);
        }
    }
}