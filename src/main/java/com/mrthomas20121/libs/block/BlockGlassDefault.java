package com.mrthomas20121.libs.block;

import com.mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

public class BlockGlassDefault extends BlockGlass {
    public BlockGlassDefault(String modid, String name) {
        super(Material.GLASS, false);
        this.setRegistryName(modid, name+"_glass");
        this.setTranslationKey(modid + "." + name+"_glass");
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(7);
    }
}
