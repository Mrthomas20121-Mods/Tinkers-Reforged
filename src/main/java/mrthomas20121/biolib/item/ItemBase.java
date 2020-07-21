package com.mrthomas20121.biolib.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase(String modid, String name) {
        this.setRegistryName(modid, name);
        this.setTranslationKey(modid+ "." + name);
        setCreativeTab(CreativeTabs.MISC);
    }
}
