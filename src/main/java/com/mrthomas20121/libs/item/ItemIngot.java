package com.mrthomas20121.libs.item;

import net.minecraft.item.Item;

public class ItemIngot extends Item {
    public ItemIngot(String modid, String name) {
        this.setRegistryName(modid, name+"_ingot");
        this.setTranslationKey(modid+ "." + name+"_ingot");
    }
}
