package com.mrthomas20121.biolib.block;

import mrthomas20121.tinkers_reforged.Module.ModuleItems;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGlassCustom extends BlockGlass {
    public BlockGlassCustom(String modid, String name) {
        super(Material.GLASS, false);
        this.setRegistryName(modid, name+"_glass");
        this.setTranslationKey(modid + "." + name+"_glass");
        this.setCreativeTab(ModuleItems.creativetab);
        this.setHardness(3);
        this.setResistance(50);
        this.setHarvestLevel("pickaxe", 3);
    }
    @SideOnly(Side.CLIENT)
    public void initModels() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}