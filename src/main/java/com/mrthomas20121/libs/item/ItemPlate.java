package com.mrthomas20121.libs.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemPlate extends Item {
    public ItemPlate(String modid, String name) {
        this.setRegistryName(modid, name+"_plate");
        this.setTranslationKey(modid+ "." + name+"_plate");
        setCreativeTab(CreativeTabs.MISC);
    }
}
