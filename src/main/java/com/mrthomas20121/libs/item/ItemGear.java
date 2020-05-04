package com.mrthomas20121.libs.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGear extends Item {
    public ItemGear(String modid, String name) {
        this.setRegistryName(modid, name+"_gear");
        this.setTranslationKey(modid+ "." + name+"_gear");
        setCreativeTab(CreativeTabs.MISC);
    }
}
